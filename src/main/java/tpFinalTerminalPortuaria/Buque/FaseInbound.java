package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseInbound implements Fase{
	private Buque buque;
	
	public FaseInbound(Buque buque) {
		this.buque = buque;
	}

	@Override
	public void actualizar(Terminal terminal) {
		if (this.buque.ubicacionActual() == terminal.ubicacionActual()) {
			Fase fase = new FaseArrived(this.buque);
			this.buque.setFase(fase);
			this.buque.setEstaConTrabajoEnCurso(false);
		}
	}

}
