package tpFinalTerminalPortuaria.Buque;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public abstract class Fase {
	private Buque buque;
	
	public Fase(Buque buque) {
		this.buque = buque;
	}

	public Buque getBuque() {
		return this.buque;
	}
	
	public abstract void actualizar(TerminalGestionada terminal);
	public abstract void depart(TerminalGestionada terminal);
	public abstract void iniciarTrabajo(TerminalGestionada terminal);
}
