package tpFinalTerminalPortuaria.Tramo;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Tramo {

	private Terminal terminalOrigen;
	private Terminal terminalDestino;
	private int precio;
	private LocalDate diaLLegada;
	private LocalDate diaSalida;
	private long duracion; // en días
	
	public Tramo(Terminal terminalOrigen, Terminal terminalDestino, int precio, LocalDate diaLlegada, LocalDate diaSalida, long duracion) {
		this.terminalOrigen = terminalOrigen;
		this.terminalDestino = terminalDestino;
		this.precio = precio;
		this.diaLLegada = diaLlegada;
		this.diaSalida = diaSalida;
		this.duracion = duracion;
	}

	public Terminal getTerminalOrigen() {
		return this.terminalOrigen;
	}

	public LocalDate getFechaSalida() {
		return this.diaSalida;
	}
	
	 public long calcularTiempoDeRecorrido() {
	        return this.duracion;
	    }

	public Terminal getTerminalDestino() {
		return this.terminalDestino;
	}
}
