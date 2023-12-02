package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseDeparting extends Fase{
	
	public FaseDeparting(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		if(this.getBuque().distanciaA(terminal) > 1d) {//1km
			Fase faseNueva = new FaseOutbound(this.getBuque());
			this.getBuque().setFase(faseNueva);
			terminal.procesarOrdenSegunBuque(this.getBuque());
		}	
	}

	@Override
	public void depart(TerminalGestionada terminal) {
	}

	@Override
	public void iniciarTrabajo(TerminalGestionada terminal) {
	}

	
	
	


}
