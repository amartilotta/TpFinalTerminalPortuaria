package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseOutbound extends Fase{
	
	public FaseOutbound(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(TerminalGestionada terminal) {
		if(this.getBuque().distanciaA(terminal.getUbicacion()) < 50d) {
			Fase faseNueva = new FaseInbound(this.getBuque());
			this.getBuque().setFase(faseNueva);
		}
		
	}

	@Override
	public void depart(TerminalGestionada terminal) {
	}

	@Override
	public void iniciarTrabajo(TerminalGestionada terminal) {
	}


}
