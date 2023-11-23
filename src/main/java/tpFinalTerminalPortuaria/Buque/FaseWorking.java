package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseWorking extends Fase{
	
	public FaseWorking(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		if(!this.getBuque().estaConTrabajoEnCurso()) {
			Fase faseNueva = new FaseDeparting(this.getBuque());
			this.getBuque().setFase(faseNueva);
		}
	}



}
