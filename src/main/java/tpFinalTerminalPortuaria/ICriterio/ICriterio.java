package tpFinalTerminalPortuaria.ICriterio;
import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public interface ICriterio {

	public CircuitoMaritimo calcularMejorCircuito(List<CircuitoMaritimo> circuitos);
}// pasar una lista de circuitos desde la terminal nomas
