package tpFinalTerminalPortuaria.CircuitoMaritimo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class CircuitoMaritimo {
	
	private TreeSet<Tramo> tramos;
	
	
	public CircuitoMaritimo(TreeSet<Tramo> tramos) {
        this.tramos = tramos;
    }
	
	
	public Map<Terminal, LocalDate> getTerminalesYFechasSalida() {
		Map<Terminal, LocalDate> mapaTerminalesSalida = new HashMap<>();
		// Iterar sobre la lista de tramos
        for (Tramo tramo : tramos) {
            Terminal terminal = tramo.getTerminalOrigen();
            LocalDate fechaSalida = tramo.getFechaSalida();

            // Agregar la terminal y la fecha de salida al mapa
            mapaTerminalesSalida.put(terminal, fechaSalida);
        }

        return mapaTerminalesSalida;
	}
	
	public Terminal getPuertoOrigen() {
		return tramos.isEmpty() ? null : tramos.first().getTerminalOrigen();
	    }

	public Terminal getPuertoDestino() {
	    return tramos.isEmpty() ? null : tramos.last().getTerminalOrigen();
	    }
	
	public long tiempoDesdeTerminalHastaTerminal(TerminalGestionada terminalGestionada, Terminal terminal) {
	    long tiempoTotal = 0;

	    // Iterar sobre los tramos
	    Iterator<Tramo> iterator = tramos.iterator();
	    while (iterator.hasNext()) {
	        Tramo tramo = iterator.next();

	        // Verificar si la terminal de origen del tramo coincide con la terminalGestionada
	        if (tramo.getTerminalOrigen().equals(terminalGestionada)) {
	            // Sumo el tiempo del tramo que estoy iterando
	            tiempoTotal += tramo.calcularTiempoDeRecorrido();

	            // la terminal que estoy iterando es la que me pasan por parametro?
	            if (tramo.getTerminalDestino().equals(terminal)) {
	                break; // Salgo del bucle 
	            }
	        }
	    }

	    return tiempoTotal;
	}
	
}
