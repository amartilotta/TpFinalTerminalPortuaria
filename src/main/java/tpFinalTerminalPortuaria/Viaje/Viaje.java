package tpFinalTerminalPortuaria.Viaje;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.terminal.Terminal;


public class Viaje {
	
	private String nombre;
	private double precioDelViaje;
	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
	private Terminal terminalOrigen;
	private Buque buque;
	
	public Viaje(String nombre, double precioDelViaje, LocalDate fechaSalida,LocalDate fechaLlegada,Terminal terminalOrigen) {
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.precioDelViaje = precioDelViaje;
		this.terminalOrigen = terminalOrigen;
	}
	
	public double costoCircuito() {
		return 0;
	}
	
	public Container datosDeCarga() {
		return this.buque.
	}

}
