package tpFinalTerminalPortuaria.ICriterio;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class MenorPrecioTotalOrigenDestino implements ICriterio{
	
	private Terminal origen;
	private Terminal destino;
	
	public MenorPrecioTotalOrigenDestino(Terminal terminalGestionada, Terminal terminal) {
		this.origen = terminalGestionada;
		this.destino = terminal;
	}

	@Override
	public CircuitoMaritimo calcularMejorCircuito() {

		return null;
	}

}
