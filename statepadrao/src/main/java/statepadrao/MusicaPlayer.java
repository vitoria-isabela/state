package statepadrao;

public class MusicaPlayer {
    private Musica musicaAtual;
    private ListaDeReproducao listaReproducao;
    
    public MusicaPlayer(Musica musica, ListaDeReproducao listaReproducao) {
        this.musicaAtual = musica;
        this.listaReproducao = listaReproducao;
    }

    public boolean tocar() {
        return musicaAtual.tocar();
    }

    public boolean pausar() {
        return musicaAtual.pausar();
    }

    public boolean parar() {
        return musicaAtual.parar();
    }

    public void avancarMusica() {
        musicaAtual.avancar();
    }

    public void retrocederMusica() {
        musicaAtual.retroceder();
    }

    public void ajustarVolume(int volume) {
        musicaAtual.ajustarVolume(volume);
    }

    public String listarMusicas() {
        StringBuilder result = new StringBuilder("Lista de Músicas Disponíveis:\n");
        for (int i = 0; i < listaReproducao.size(); i++) {
            Musica musica = listaReproducao.getMusicaAtual(i);
            result.append(i).append(". ").append(musica.getNome()).append(" - ").append(musica.getArtista()).append("\n");
        }
        return result.toString();
    }

    public String adicionarMusica(Musica musica) {
        listaReproducao.adicionarMusica(musica);
        return "Música adicionada com sucesso!";
    }

    public String selecionarMusica(int indice) {
        if (indice >= 0 && indice < listaReproducao.size()) {
            musicaAtual = listaReproducao.getMusicaAtual(indice);
            return "Selecionada: " + musicaAtual.getNome() + " - " + musicaAtual.getArtista();
        } else {
            return "Índice inválido.";
        }
    }

    public void aumentarVolume(int incremento) {
        int novoVolume = musicaAtual.getVolume() + incremento;
        if (novoVolume <= 100) {
            musicaAtual.setVolume(novoVolume);
        } else {
            System.out.println("Volume máximo atingido.");
        }
    }

    public void diminuirVolume(int incremento) {
        int novoVolume = musicaAtual.getVolume() - incremento;
        if (novoVolume >= 0) {
            musicaAtual.setVolume(novoVolume);
        } else {
            System.out.println("Volume mínimo atingido.");
        }
    }
}
