package statepadrao;

public class ReproducaoTocando extends ReproducaoEstado {
	private ReproducaoTocando() {};
	
    public static ReproducaoTocando getInstance() {
        return new ReproducaoTocando();
    }
    
    public String getEstadoReproducao() {
        return "Tocando";
    }
    
    public boolean parar(Musica musica) {
    	musica.setEstado(ReproducaoParada.getInstance());
        return true;
    }

    public boolean pausar(Musica musica) {
    	musica.setEstado(ReproducaoTocando.getInstance());
        return true;
    }
}
