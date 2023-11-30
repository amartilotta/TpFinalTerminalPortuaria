package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseInbound extends Fase{
	
	public FaseInbound(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(TerminalGestionada terminal) {
		if (this.getBuque().distanciaA(terminal) == 0d) {
			Fase fase = new FaseArrived(this.getBuque());
			this.getBuque().setFase(fase);
		}
	}

	@Override
	public void depart(TerminalGestionada terminal) {
	}

	@Override
	public void iniciarTrabajo(TerminalGestionada terminal) {
	}

}
