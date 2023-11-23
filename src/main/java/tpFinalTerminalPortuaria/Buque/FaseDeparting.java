package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseDeparting extends Fase{
	
	public FaseDeparting(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(this.getBuque().distanciaA(terminal) > 1) {//1km
			Fase faseNueva = new FaseOutbound(this.getBuque());
			this.getBuque().setFase(faseNueva);
			//terminal.procesarOrdenSegunBuque(this.getBuque());
		}
		
	}



}
