package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseWorking implements Fase{
	private Buque buque;
	
	public FaseWorking(Buque buque) {
		this.buque = buque;
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(!this.buque.estaConTrabajoEnCurso()) {
			Fase faseNueva = new FaseDeparting(this.buque);
			this.buque.setFase(faseNueva);
		}
		
	}



}
