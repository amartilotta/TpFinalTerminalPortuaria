package tpFinalTerminalPortuaria.Viaje;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;
import java.util.*;


public class Viaje {
	
	private long precioDelViaje;
	private LocalDate fechaSalida;
	private Buque buque;
	private CircuitoMaritimo circuito;
	private Map<Terminal, LocalDate> cronograma;
	
	public Viaje(LocalDate fechaSalida, CircuitoMaritimo circuito, Buque buque) {
		this.fechaSalida = fechaSalida;
		this.buque = buque;
		this.circuito = circuito;
		this.cronograma = generarCronograma();
		this.precioDelViaje = costoCircuito();
	}
	
	public long getPrecioDelViaje() {
		return precioDelViaje;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public Buque getBuque() {
		return buque;
	}

	public CircuitoMaritimo getCircuito() {
		return circuito;
	}

	public Map<Terminal, LocalDate> getCronograma() {
		return this.cronograma;
	}
	
	private long costoCircuito() {
		return this.circuito.calcularPrecioTotal();
	}

	protected Map<Terminal, LocalDate> generarCronograma() {
	    Map<Terminal, LocalDate> cronograma = new HashMap<>();
	    LocalDate fechaActual = fechaSalida;

	    // Iterar sobre los tramos ordenados en el TreeSet
	    for (Tramo tramo : circuito.getTramos()) {
	        Terminal terminalOrigen = tramo.getTerminalOrigen();

	        // Verificar si la terminal ya está en el cronograma
	        if (!cronograma.containsKey(terminalOrigen)) {
	            // Si no está en el cronograma, agregar con la fecha actual
	            cronograma.put(terminalOrigen, fechaActual);
	        }

	        // Calcular la fecha de salida para la siguiente terminal
	        fechaActual = fechaActual.plusDays(tramo.getDuracionEnDias());
	    }

	    return cronograma;
	}
	
	public boolean tieneTerminal(Terminal terminal) {
	    return cronograma.containsKey(terminal);
	}
	
	public LocalDate obtenerFechaSalidaDeTerminal(Terminal terminal) {
	    for (Map.Entry<Terminal, LocalDate> entry : cronograma.entrySet()) {
	        if (entry.getKey().equals(terminal)) {
	            return entry.getValue();
	        }
	    }
	    return null;
	}
	
	
//	5. Devolver la próxima fecha de partida de un buque desde la terminal gestionada
//	hasta otra terminal de destino.(metodo auxiliar, principal esta en LineaNaviera)
	public LocalDate calcularFechaProxima(TerminalGestionada terminalGestionada, Terminal puertoDestino, LocalDate fechaActual) {
	    LocalDate fechaProxima = getFechaSalida();
	    boolean iniciado = false;

	    for (Tramo tramo : circuito.getTramos()) {
	        if (tramo.getTerminalOrigen().equals(terminalGestionada)) {
	            iniciado = true;
	            fechaProxima = fechaProxima.plusDays(tramo.getDuracionEnDias());

	            if (tramo.getTerminalDestino().equals(puertoDestino) && fechaProxima.isAfter(fechaActual)) {
	                return fechaProxima;
	            }
	        }

	        if (iniciado) {
	            fechaProxima = fechaProxima.plusDays(tramo.getDuracionEnDias());

	            if (tramo.getTerminalDestino().equals(puertoDestino) && fechaProxima.isAfter(fechaActual)) {
	                return fechaProxima;
	            }
	        }
	    }
	    return null;
	}

	public LocalDate fechaAsignadaA(Terminal terminal) {
        LocalDate fecha = null;
        if(this.tieneTerminal(terminal)) {
            fecha = cronograma.get(terminal);
        }
        return fecha;
    }

	public String getNombreBuque() {
		return this.buque.getNombre();
	}

}
