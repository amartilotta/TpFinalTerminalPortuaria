package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseOutbound implements Fase{
	private Buque buque;
	
	public FaseOutbound(Buque buque) {
		this.buque = buque;
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(this.buque.ubicacionActual() < 50) {
			Fase faseNueva = new FaseInbound(this.buque);
			this.buque.setFase(faseNueva);
			terminal.procesarOrdenSegunBuque(this.buque);
		}
		
	}


}
