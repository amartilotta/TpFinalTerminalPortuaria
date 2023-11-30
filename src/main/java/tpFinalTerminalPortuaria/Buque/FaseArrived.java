package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseArrived extends Fase{
	
	public FaseArrived(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		FaseWorking faseNueva = new FaseWorking(this.getBuque());
		this.getBuque().setFase(faseNueva);	
	}

	@Override
	public void depart(TerminalGestionada terminal) {

	}

	@Override
	public void iniciarTrabajo(TerminalGestionada terminal) {
		this.actualizar(terminal);
	}

} 
