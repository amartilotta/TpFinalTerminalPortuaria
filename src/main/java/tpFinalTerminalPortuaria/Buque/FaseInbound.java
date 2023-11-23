package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseInbound extends Fase{
	
	public FaseInbound(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(Terminal terminal) {
		if (this.getBuque().distanciaA(terminal) == 0) {
			Fase fase = new FaseArrived(this.getBuque());
			this.getBuque().setFase(fase);
			this.getBuque().setEstaConTrabajoEnCurso(false);
		}
	}

}
