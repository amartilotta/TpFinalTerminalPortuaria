package tpFinalTerminalPortuaria.Tramo;

import java.time.LocalDate;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Tramo {

	private Terminal terminalOrigen;
	private Terminal terminalDestino;
	private int precio;
	private LocalDate diaLLegada;
	private LocalDate diaSalida;
	
	public Tramo(Terminal terminalOrigen, Terminal terminalDestino, int precio, LocalDate diaLlegada, LocalDate diaSalida) {
		this.terminalOrigen = terminalOrigen;
		this.terminalDestino = terminalDestino;
		this.precio = precio;
		this.diaLLegada = diaLlegada;
		this.diaSalida = diaSalida;
	}
}
