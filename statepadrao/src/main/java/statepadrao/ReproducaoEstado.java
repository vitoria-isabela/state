package statepadrao;

public abstract class ReproducaoEstado {
    public abstract String getEstadoReproducao();

    public boolean tocar(Musica musica) {
    	return false;
    }

    public boolean pausar(Musica musica) {
    	return false;
    }

    public boolean parar(Musica musica) {
    	return false;
    }
    
    public void avancar(Musica musica) {
        ListaDeReproducao lista = musica.getListaDeReproducao();
        int indiceAtual = lista.getIndiceAtual();
        
        if (indiceAtual < lista.size() - 1) {
            lista.setIndiceAtual(indiceAtual + 1);
        }
    }

    public void retroceder(Musica musica) {
        ListaDeReproducao lista = musica.getListaDeReproducao();
        int indiceAtual = lista.getIndiceAtual();
        
        if (indiceAtual > 0) {
            lista.setIndiceAtual(indiceAtual - 1);
        }
    }
    
    public void ajustarVolume(Musica musica, int volume) {
        if (volume >= 0 && volume <= 100) {
            musica.setVolume(volume);
        }
    }
}
