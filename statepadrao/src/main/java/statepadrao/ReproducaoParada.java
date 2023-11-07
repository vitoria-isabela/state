package statepadrao;

public class ReproducaoParada extends ReproducaoEstado {
	
	private ReproducaoParada() {};
	
    public static ReproducaoParada getInstance() {
        return new ReproducaoParada();
    }
    
    public String getEstadoReproducao() {
        return "Parada";
    }
    
    public boolean tocar(Musica musica) {
    	musica.setEstado(ReproducaoTocando.getInstance());
        return true;
    }

    public boolean pausar(Musica musica) {
    	return false;
    }

}

