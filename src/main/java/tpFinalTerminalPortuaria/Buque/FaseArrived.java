package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseArrived implements Fase{
	private Buque buque;
	
	public FaseArrived(Buque buque) {
		this.buque = buque;
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(this.buque.estaConTrabajoEnCurso()) {
			Fase faseNueva = new FaseWorking(this.buque);
			this.buque.setFase(faseNueva);	
		}
	}


}
