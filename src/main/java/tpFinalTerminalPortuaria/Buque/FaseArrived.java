package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseArrived extends Fase{
	
	public FaseArrived(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		if(this.getBuque().estaConTrabajoEnCurso()) {
			FaseWorking faseNueva = new FaseWorking(this.getBuque());
			this.getBuque().setFase(faseNueva);	
		}
	}


} 
