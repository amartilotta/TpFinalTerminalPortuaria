package tpFinalTerminalPortuaria.Viaje;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.Cronograma.Cronograma;
import java.util.*;


public class Viaje {
	
	private double precioDelViaje;
	private LocalDate fechaSalida;
	private Buque buque;
	private CircuitoMaritimo circuito;
	private Cronograma cronograma;
	
	public Viaje(LocalDate fechaSalida, CircuitoMaritimo circuito, Buque buque) {
		this.fechaSalida = fechaSalida;
		this.buque = buque;
		this.circuito = circuito;
		this.cronograma = generarCronograma();
	}
	
	public double getPrecioDelViaje() {
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

	public Cronograma getCronograma() {
		return cronograma;
	}
	
	public long costoCircuito() {
		return this.circuito.calcularPrecioTotal();
	}

	private Cronograma generarCronograma() {
	    Map<Terminal, LocalDate> cronograma = new HashMap<>();

	    // Iterar sobre los tramos ordenados en el TreeSet
	    for (Tramo tramo : circuito.getTramos()) {
	        Terminal terminalOrigen = tramo.getTerminalOrigen();

	        // Verificar si la terminal ya está en el cronograma
	        if (!cronograma.containsKey(terminalOrigen)) {
	            // Si no está en el cronograma, agregar con la fecha actual
	            cronograma.put(terminalOrigen, fechaSalida);
	        }

	        // Calcular la fecha de salida para la siguiente terminal
	        fechaSalida = fechaSalida.plusDays(tramo.getDuracionEnDias());
	    }

	    return new Cronograma(cronograma);
	}
	

}
