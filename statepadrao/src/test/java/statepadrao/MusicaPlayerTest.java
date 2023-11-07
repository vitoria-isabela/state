package statepadrao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MusicaPlayerTest {

    private MusicaPlayer musicaPlayer;
    private Musica musica;
    private ListaDeReproducao listaReproducao;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        listaReproducao = new ListaDeReproducao();
        musica = new Musica("Nome da Música", "Artista", 180, 50, listaReproducao);
        musicaPlayer = new MusicaPlayer(musica, listaReproducao);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }
    
    @Test
    public void Given_MusicaPlayerWithMusica_When_AjustarVolumeAboveMax_Then_PrintsVolumeMaximoAtigindo() {
        musicaPlayer.ajustarVolume(101);
        assertEquals("Volume máximo atingido.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_AjustarVolumeBelowMin_Then_PrintsVolumeMinimoAtigindo() {
        musicaPlayer.ajustarVolume(-1);
        assertEquals("Volume mínimo atingido.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_TocarMusica_Then_ReturnsTrue() {
        boolean result = musicaPlayer.tocar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_PausarMusica_Then_ReturnsTrue() {
        boolean result = musicaPlayer.pausar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_PararMusica_Then_ReturnsTrue() {
        boolean result = musicaPlayer.parar();
        assertTrue(result);
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_AvancarMusica_Then_DoesNotThrowException() {
        assertDoesNotThrow(() -> musicaPlayer.avancarMusica());
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_RetrocederMusica_Then_DoesNotThrowException() {
        assertDoesNotThrow(() -> musicaPlayer.retrocederMusica());
    }

    @Test
    public void Given_MusicaPlayerWithMusica_When_AjustarVolumeWithinBounds_Then_DoesNotThrowException() {
        assertDoesNotThrow(() -> musicaPlayer.ajustarVolume(50));
    }

    @Test
    public void Given_MusicaPlayerWithListaDeReproducao_When_ListarMusicas_Then_ReturnsStringWithMusicas() {
        Musica outraMusica = new Musica("Outra Música", "Outro Artista", 200, 300, listaReproducao);
        listaReproducao.adicionarMusica(outraMusica);

        String result = musicaPlayer.listarMusicas();
        String expected = "Lista de Músicas Disponíveis:\n0. Nome da Música - Artista\n1. Outra Música - Outro Artista\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_MusicaPlayerWithListaDeReproducao_When_AdicionarMusica_Then_ReturnsSuccessMessage() {
        Musica outraMusica = new Musica("Outra Música", "Outro Artista", 200, 300, listaReproducao);
        String result = musicaPlayer.adicionarMusica(outraMusica);
        assertEquals("Música adicionada com sucesso!", result);
    }

    @Test
    public void Given_MusicaPlayerWithListaDeReproducao_When_SelecionarMusicaValidIndex_Then_ReturnsSelectionMessage() {
        Musica outraMusica = new Musica("Outra Música", "Outro Artista", 200, 300, listaReproducao);
        listaReproducao.adicionarMusica(outraMusica);

        String result = musicaPlayer.selecionarMusica(1);
        assertEquals("Selecionada: Outra Música - Outro Artista", result);
    }


    @Test
    public void Given_MusicaPlayerWithListaDeReproducao_When_SelecionarMusicaInvalidIndex_Then_ReturnsInvalidIndexMessage() {
        String result = musicaPlayer.selecionarMusica(1);
        assertEquals("Índice inválido.", result);
    }
}
