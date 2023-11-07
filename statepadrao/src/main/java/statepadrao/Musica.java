package statepadrao;

public class Musica {
    private ReproducaoEstado estado;
    private String nome;
    private String artista;
    private int volume;
    private int duracao;
    private ListaDeReproducao listaDeReproducao;

    public Musica(String nome, String artista, int volume, int duracao, ListaDeReproducao listaDeReproducao) {
        this.setNome(nome);
        this.setArtista(artista);
        this.setDuracao(duracao);
        this.setVolume(volume);
        this.estado = ReproducaoParada.getInstance();
        this.setListaDeReproducao(listaDeReproducao);
    }

    public boolean tocar() {
        return estado.tocar(this);
    }

    public boolean pausar() {
        return estado.pausar(this);
    }

    public boolean parar() {
        return estado.parar(this);
    }

    public void setEstado(ReproducaoEstado estado) {
        this.estado = estado;
    }
    
    public ReproducaoEstado getEstado() {
        return estado;
    }    

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void avancar() {
        estado.avancar(this);
    }

    public void retroceder() {
        estado.retroceder(this);
    }

    public void ajustarVolume(int volume) {
        estado.ajustarVolume(this, volume);
    }

	public ListaDeReproducao getListaDeReproducao() {
		return listaDeReproducao;
	}

	public void setListaDeReproducao(ListaDeReproducao listaDeReproducao) {
		this.listaDeReproducao = listaDeReproducao;
	}
}