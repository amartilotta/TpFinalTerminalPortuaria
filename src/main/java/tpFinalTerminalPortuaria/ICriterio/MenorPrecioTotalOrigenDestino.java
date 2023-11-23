package tpFinalTerminalPortuaria.ICriterio;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

import java.util.*;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class MenorPrecioTotalOrigenDestino implements ICriterio{

	@Override
	public CircuitoMaritimo calcularMejorCircuito(TerminalGestionada terminalGestionada, Terminal terminalDestino) {
        List<CircuitoMaritimo> circuitosDisponibles = terminalGestionada.obtenerCircuitosHaciaDestino(terminalDestino);
        return circuitosDisponibles.stream()
                .min(Comparator.comparingDouble(CircuitoMaritimo::calcularPrecioTotal))
                .orElse(null);
    }

}
