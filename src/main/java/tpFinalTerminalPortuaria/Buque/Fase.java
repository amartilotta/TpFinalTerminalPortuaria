package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;

public abstract class Fase {
	private Buque buque;
	
	public Fase(Buque buque) {
		this.buque = buque;
	}

	public Buque getBuque() {
		return this.buque;
	}
	
	public abstract void actualizar(Terminal terminal);
}
