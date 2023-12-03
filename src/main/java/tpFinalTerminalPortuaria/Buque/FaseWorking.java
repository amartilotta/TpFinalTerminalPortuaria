package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseWorking extends Fase{
	
	public FaseWorking(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		Fase faseNueva = new FaseDeparting(this.getBuque());
		this.getBuque().setFase(faseNueva);
	}

	@Override
	public void depart(TerminalGestionada terminal) {
		this.actualizar(terminal);
	}

	@Override
	public void iniciarTrabajo(TerminalGestionada terminal) {
	}



}
