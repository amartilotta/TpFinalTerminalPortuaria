package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FaseDeparting implements Fase{
	private Buque buque;
	
	public FaseDeparting(Buque buque) {
		this.buque = buque;
	}
	
	@Override
	public void actualizar(Terminal terminal) {
		if(this.buque.ubicacionActual() > 1) {//1km
			Fase faseNueva = new FaseOutbound(this.buque);
			this.buque.setFase(faseNueva);
			terminal.procesarOrdenSegunBuque(this.buque);
		}
		
	}



}
