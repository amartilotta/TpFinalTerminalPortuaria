package tpFinalTerminalPortuaria.ICriterio;

import java.util.*;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class MenorPrecioTotalOrigenDestino implements ICriterio{

	@Override
	public CircuitoMaritimo calcularMejorCircuito(List<CircuitoMaritimo> circuitos) {
        return circuitos.stream()
                .min(Comparator.comparingDouble(CircuitoMaritimo::calcularPrecioTotal))
                .orElse(null);
    }

}
