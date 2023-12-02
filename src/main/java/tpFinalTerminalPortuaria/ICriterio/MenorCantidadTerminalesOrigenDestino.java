package tpFinalTerminalPortuaria.ICriterio;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

import java.util.*;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class MenorCantidadTerminalesOrigenDestino implements ICriterio{
	
	@Override
	public CircuitoMaritimo calcularMejorCircuito(List<CircuitoMaritimo> circuitos) {
        return circuitos.stream()
                .min(Comparator.comparingInt(circuito -> circuito.getTerminales().size()))
                .orElse(null);
    }

}
