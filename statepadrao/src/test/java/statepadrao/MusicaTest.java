package statepadrao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MusicaTest {
	
    private Musica musica;
    private ListaDeReproducao listaReproducao;

    @BeforeEach
    public void Given_MusicaValida() {
        musica = new Musica("Nome da Música", "Artista", 6, 180, listaReproducao);
    }

    @Test
    public void Given_MusicaValida_When_TocarMusicaNoEstadoParada_Then_ReturnaTrue() {
    	musica.setEstado(ReproducaoParada.getInstance());
        boolean result = musica.tocar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaValida_When_PausarMusicaNoEstadoParada_Then_ReturnaFalse() {
    	musica.setEstado(ReproducaoParada.getInstance());
        boolean result = musica.pausar();
        assertFalse(result);
    }

    @Test
    public void Given_MusicaValida_When_PararMusicaNoEstadoParada_Then_ReturnaFalse() {
    	musica.setEstado(ReproducaoParada.getInstance());
        boolean result = musica.parar();
        assertFalse(result);
    }
    
    @Test
    public void Given_MusicaValida_When_TocarMusicaNoEstadoPausada_Then_ReturnaTrue() {
    	musica.setEstado(ReproducaoPausada.getInstance());
        boolean result = musica.tocar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaValida_When_PausarMusicaNoEstadoPausada_Then_ReturnaFalse() {
    	musica.setEstado(ReproducaoPausada.getInstance());
        boolean result = musica.pausar();
        assertFalse(result);
    }

    @Test
    public void Given_MusicaValida_When_PararMusicaNoEstadoPausada_Then_ReturnaTrue() {
    	musica.setEstado(ReproducaoPausada.getInstance());
        boolean result = musica.parar();
        assertTrue(result);
    }
    
    @Test
    public void Given_MusicaValida_When_TocarMusicaNoEstadoTocando_Then_ReturnaFalse() {
    	musica.setEstado(ReproducaoTocando.getInstance());
        boolean result = musica.tocar();
        assertFalse(result);
    }

    @Test
    public void Given_MusicaValida_When_PausarMusicaNoEstadoTocando_Then_ReturnaTrue() {
    	musica.setEstado(ReproducaoTocando.getInstance());
        boolean result = musica.pausar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaValida_When_PararMusicaNoEstadoTocando_Then_ReturnaTrue() {
    	musica.setEstado(ReproducaoTocando.getInstance());
        boolean result = musica.parar();
        assertTrue(result);
    }
    @Test
    public void Given_MusicaValida_When_SetEstadoTocando_Then_AtualizaOEstadoDaMusica() {
        musica.setEstado(ReproducaoParada.getInstance());
        musica.setEstado(ReproducaoTocando.getInstance());
        Class<?> estadoClass = musica.getEstado().getClass();
        assertEquals(ReproducaoTocando.class, estadoClass);
    }

    @Test
    public void Given_MusicaValida_When_SetEstadoParada_Then_AtualizaOEstadoDaMusica() {
        musica.setEstado(ReproducaoTocando.getInstance());
        musica.setEstado(ReproducaoParada.getInstance());
        Class<?> estadoClass = musica.getEstado().getClass();
        assertEquals(ReproducaoParada.class, estadoClass);
    }

    @Test
    public void Given_MusicaValida_When_SetEstadoPausada_Then_AtualizaOEstadoDaMusica() {
        musica.setEstado(ReproducaoTocando.getInstance());
        musica.setEstado(ReproducaoPausada.getInstance());
        Class<?> estadoClass = musica.getEstado().getClass();
        assertEquals(ReproducaoPausada.class, estadoClass);
    }

    @Test
    public void Given_MusicaValida_When_GetNome_Then_RetornaONomeDaMusica() {
        assertEquals("Nome da Música", musica.getNome());
    }

    @Test
    public void Given_MusicaValida_When_GetArtista_Then_RetornaOArtistaDaMusica() {
        assertEquals("Artista", musica.getArtista());
    }

    @Test
    public void Given_MusicaValida_When_GetDuracao_Then_RetornaADuracaoDaMusica() {
        assertEquals(180, musica.getDuracao());
    }
    
    @Test
    public void Given_MusicaValida_When_SetNome_Then_AtualizaONomeDaMusica() {
        musica.setNome("Novo Nome da Música");
        assertEquals("Novo Nome da Música", musica.getNome());
    }

    @Test
    public void Given_MusicaValida_When_SetArtista_Then_AtualizaOArtistaDaMusica() {
        musica.setArtista("Novo Artista");
        assertEquals("Novo Artista", musica.getArtista());
    }

    @Test
    public void Given_MusicaValida_When_SetDuracao_Then_AtualizaADuracaoDaMusica() {
        musica.setDuracao(240);
        assertEquals(240, musica.getDuracao());
    }

}

