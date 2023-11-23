package tpFinalTerminalPortuaria.ICriterio;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;


public interface ICriterio {

	public CircuitoMaritimo calcularMejorCircuito(TerminalGestionada terminalGestionada, Terminal terminalDestino);
}
