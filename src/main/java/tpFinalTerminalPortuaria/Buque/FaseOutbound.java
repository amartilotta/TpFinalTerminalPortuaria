package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseOutbound extends Fase{
	
	public FaseOutbound(Buque buque) {
		super(buque);
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(this.getBuque().distanciaA(terminal) < 50) {
			Fase faseNueva = new FaseInbound(this.getBuque());
			this.getBuque().setFase(faseNueva);
			//terminal.procesarOrdenSegunBuque(this.getBuque());
		}
		
	}


}
