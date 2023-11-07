package statepadrao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDeReproducaoTest {
	
    private ListaDeReproducao listaReproducao;

    @BeforeEach
    public void Given_ListaDeReproducaoVazia() {
        listaReproducao = new ListaDeReproducao();
    }

    @Test
    public void Given_ListaDeReproducaoVazia_When_AdicionarMusica_Then_MusicaDeveSerAdicionada() {
        Musica musica = new Musica("Nome da Música", "Artista", 6, 180, listaReproducao);
        listaReproducao.adicionarMusica(musica);
        assertEquals(1, listaReproducao.size());
    }

    @Test
    public void Given_ListaDeReproducaoComMusica_When_GetMusicaAtual_Then_DeveRetornarAMusicaAtual() {
        Musica musica = new Musica("Nome da Música", "Artista", 6, 180, listaReproducao);
        listaReproducao.adicionarMusica(musica);

        Musica musicaAtual = listaReproducao.getMusicaAtual(0);
        assertEquals(musica, musicaAtual);
    }

    @Test
    public void Given_ListaDeReproducaoComMusica_When_GetMusicaAtualComIndiceInvalido_Then_DeveRetornarNull() {
        Musica musica = new Musica("Nome da Música", "Artista", 6, 180, listaReproducao);
        listaReproducao.adicionarMusica(musica);

        Musica musicaAtual = listaReproducao.getMusicaAtual(1);
        assertNull(musicaAtual);
    }

    @Test
    public void Given_ListaDeReproducaoComMusica_When_SetIndiceAtual_Then_DeveAtualizarOIndiceAtual() {
        Musica musica1 = new Musica("Música 1", "Artista 1", 5, 200, listaReproducao);
        Musica musica2 = new Musica("Música 2", "Artista 2", 4, 150, listaReproducao);

        listaReproducao.adicionarMusica(musica1);
        listaReproducao.adicionarMusica(musica2);

        listaReproducao.setIndiceAtual(1);
        assertEquals(1, listaReproducao.getIndiceAtual());
    }

    @Test
    public void Given_ListaDeReproducaoComMusica_When_SetIndiceAtualComIndiceInvalido_Then_NaoDeveAtualizarOIndiceAtual() {
        Musica musica1 = new Musica("Música 1", "Artista 1", 5, 200, listaReproducao);
        Musica musica2 = new Musica("Música 2", "Artista 2", 4, 150, listaReproducao);

        listaReproducao.adicionarMusica(musica1);
        listaReproducao.adicionarMusica(musica2);

        listaReproducao.setIndiceAtual(2);
        assertEquals(0, listaReproducao.getIndiceAtual());
    }

    @Test
    public void Given_ListaDeReproducaoComMusica_When_GetTamanho_Then_DeveRetornarOTamanhoDaLista() {
        Musica musica1 = new Musica("Música 1", "Artista 1", 5, 200, listaReproducao);
        Musica musica2 = new Musica("Música 2", "Artista 2", 4, 150, listaReproducao);

        listaReproducao.adicionarMusica(musica1);
        listaReproducao.adicionarMusica(musica2);

        assertEquals(2, listaReproducao.size());
    }
}
