package tpFinalTerminalPortuaria.ICriterio;
import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;


public interface ICriterio {

	public CircuitoMaritimo calcularMejorCircuito(List<CircuitoMaritimo> circuitos);
}// pasar una lista de circuitos desde la terminal nomas
