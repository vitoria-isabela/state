package statepadrao;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproducao {
    private List<Musica> musicas;
    private int indiceAtual;

    public ListaDeReproducao() {
        this.musicas = new ArrayList<>();
        this.indiceAtual = 0;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public Musica getMusicaAtual(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            return musicas.get(indice);
        } else {
            return null;
        }
    }

    public int getIndiceAtual() {
        return indiceAtual;
    }

    public void setIndiceAtual(int novoIndice) {
        if (novoIndice >= 0 && novoIndice < musicas.size()) {
            indiceAtual = novoIndice;
        }
    }

    public int size() {
        return musicas.size();
    }
}
