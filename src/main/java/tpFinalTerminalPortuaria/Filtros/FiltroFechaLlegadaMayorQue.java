package tpFinalTerminalPortuaria.Filtros;

import java.time.LocalDate;
import java.util.List;

import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroFechaLlegadaMayorQue extends FiltroSimple{
	private LocalDate fecha;
	private Terminal terminal;
	
	public FiltroFechaLlegadaMayorQue(LocalDate fecha, Terminal terminal) {
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
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return null;
	}

}
