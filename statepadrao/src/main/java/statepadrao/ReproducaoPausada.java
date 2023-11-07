package statepadrao;

public class ReproducaoPausada extends ReproducaoEstado {
	private ReproducaoPausada() {};
	
	static ReproducaoPausada getInstance() {
        return new ReproducaoPausada();
    }
    
    public String getEstadoReproducao() {
        return "Pausada";
    }
    
    public boolean tocar(Musica musica) {
    	musica.setEstado(ReproducaoPausada.getInstance());
        return true;
    }

    public boolean parar(Musica musica) {
    	musica.setEstado(ReproducaoParada.getInstance());
        return true;
    }
}
