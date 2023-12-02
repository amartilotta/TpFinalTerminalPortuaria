package tpFinalTerminalPortuaria.CircuitoMaritimo;

//import java.time.LocalDate;
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
	
	public Terminal getPuertoOrigen() {
		return tramos.isEmpty() ? null : tramos.first().getTerminalOrigen();
	    }

//	public Terminal getPuertoDestino() {
//	    return tramos.isEmpty() ? null : tramos.last().getTerminalOrigen();
//	    }
	
	public TreeSet<Tramo> getTramos() {
		return this.tramos;
	}
	
	
	public long calcularTiempoTotal() {
        return tramos.stream().mapToLong(Tramo::getDuracionEnDias).sum();
    }
	public boolean contieneTerminal(Terminal terminal) {
        return tramos.stream()
                .anyMatch(tramo -> tramo.getTerminalOrigen().equals(terminal) || tramo.getTerminalDestino().equals(terminal));
    }
	
	public boolean contieneTerminales(TerminalGestionada terminalGestionada, Terminal terminal) {
	    List<Terminal> terminales = getTerminales();

	    return terminales.contains(terminalGestionada) && terminales.contains(terminal);
	}


	public List<Terminal> getTerminales() {
        List<Terminal> terminales = new ArrayList<>();
        for (Tramo tramo : tramos) {
            terminales.add(tramo.getTerminalOrigen());
        }

        terminales = new ArrayList<>(new HashSet<>(terminales));//Eliminado de duplicados
        return terminales;
    }
	
	public long calcularPrecioTotal() {
        return tramos.stream().mapToLong(Tramo::getPrecio).sum();
    }
	
	
//	4. Devolver cuánto tarda una naviera en llegar desde la terminal gestionada hacia otra
//	terminal, independientemente de las fechas de los viajes programados.
	public long tiempoDesdeTerminalHastaTerminal(Terminal terminalOrigen, Terminal terminalDestino) {
	    long tiempoTotal = 0;
	    boolean iniciado = false;

	    for (Tramo tramo : tramos) {
	        if (tramo.getTerminalOrigen().equals(terminalOrigen)) {
	            iniciado = true;
	            tiempoTotal += tramo.getDuracionEnDias();
	        }

	        if (iniciado) {
	            tiempoTotal += tramo.getDuracionEnDias();
	        }

	        if (tramo.getTerminalDestino().equals(terminalDestino)) {
	            return tiempoTotal; // Salir del bucle si llegamos a la terminal de destino
	        }
	    }

	    // Si no se encontró la terminal de destino después de la terminal de origen
	    return -1;
	}
	
	
//	public long tiempoDesdeTerminalHastaTerminal(TerminalGestionada terminalGestionada, Terminal terminal) {
//		long tiempoTotal = 0;
//		
//		// Iterar sobre los tramos
//		Iterator<Tramo> iterator = tramos.iterator();
//		while (iterator.hasNext()) {
//			Tramo tramo = iterator.next();
//			
//			// Verificar si la terminal de origen del tramo coincide con la terminalGestionada
//			if (tramo.getTerminalOrigen().equals(terminalGestionada)) {
//				// Sumo el tiempo del tramo que estoy iterando
//				tiempoTotal += tramo.getDuracionEnDias();
//				
//				// la terminal que estoy iterando es la que me pasan por parametro?
//				if (tramo.getTerminalDestino().equals(terminal)) {
//					break; // Salgo del bucle 
//				}
//			}
//		}
//		
//		return tiempoTotal;
//	}
	
	
}
