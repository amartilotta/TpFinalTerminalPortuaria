package tpFinalTerminalPortuaria.Filtros;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroFechaLlegadaIgualQue extends FiltroFecha{
	
	public FiltroFechaLlegadaIgualQue(LocalDate fecha, Terminal terminal) {
		super(fecha, terminal);
	}
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		
		List<Viaje> filtrados = viajes.stream()
									  .filter(viaje -> viaje.tieneTerminal(terminal) 
									   && this.fechaEsIgualALaDelFiltro(viaje.fechaAsignadaA(terminal)))
									  .collect(Collectors.toList());
				
				
		return filtrados;
	}
	
}
