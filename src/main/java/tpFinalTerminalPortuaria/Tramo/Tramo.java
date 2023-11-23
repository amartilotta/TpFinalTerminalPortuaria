package tpFinalTerminalPortuaria.Tramo;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Tramo {

	private Terminal terminalOrigen;
	private Terminal terminalDestino;
	private int precio;
	private int duracion; // en días
	
	public Tramo(Terminal terminalOrigen, Terminal terminalDestino, int precio, int duracion) {
		this.terminalOrigen = terminalOrigen;
		this.terminalDestino = terminalDestino;
		this.precio = precio;
		this.duracion = duracion;
	}

	public Terminal getTerminalOrigen() {
		return this.terminalOrigen;
	}
	
	 public int getDuracionEnDias() {
	        return this.duracion;
	    }

	public Terminal getTerminalDestino() {
		return this.terminalDestino;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}
