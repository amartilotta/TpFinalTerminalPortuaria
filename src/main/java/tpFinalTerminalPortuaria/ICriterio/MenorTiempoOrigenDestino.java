package tpFinalTerminalPortuaria.ICriterio;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

import java.util.*;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class MenorTiempoOrigenDestino implements ICriterio{

	@Override
	public CircuitoMaritimo calcularMejorCircuito(List<CircuitoMaritimo> circuitos) {
        return circuitos.stream()
                .min(Comparator.comparingLong(CircuitoMaritimo::calcularTiempoTotal))
                .orElse(null);
    }
}
