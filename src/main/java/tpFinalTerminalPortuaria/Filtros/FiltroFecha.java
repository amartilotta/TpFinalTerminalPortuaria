package tpFinalTerminalPortuaria.Filtros;

import java.time.LocalDate;

import tpFinalTerminalPortuaria.terminal.Terminal;

public abstract class FiltroFecha extends FiltroSimple {
	private LocalDate fecha;
	private Terminal terminal;
	
	public FiltroFecha(LocalDate fecha, Terminal terminal) {
		this.fecha 		= fecha;
		this.terminal	= terminal;
	}
	
	//GETTERS.
	public LocalDate getFecha() {
		return this.fecha;
	}	
	public Terminal getTerminal() {
		return this.terminal;
	}
	
	
	//METODOS PARA VALIDAR LAS FECHAS
	
	public Boolean fechaEsMayorALaDelFiltro(LocalDate fecha) {
		return fecha.isAfter(this.getFecha());
	}
	public Boolean fechaEsDistintaALaDelFiltro(LocalDate fecha) {
		return fecha != this.getFecha();
	}
	public Boolean fechaEsIgualALaDelFiltro(LocalDate fecha) {
		return fecha == this.getFecha();
	}
	public Boolean fechaEsMenorALaDelFiltro(LocalDate fecha) {
		return fecha.isBefore(this.getFecha());
	}
	
	
}
