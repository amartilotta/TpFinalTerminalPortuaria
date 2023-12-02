package tpFinalTerminalPortuaria.Filtros;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FiltroFechaSalidaMenorQue extends FiltroFecha{//Recibe terminalGestionada
	private LocalDate fecha;
	private TerminalGestionada terminal;
	
	public FiltroFechaSalidaMenorQue(LocalDate fecha, TerminalGestionada terminal) {
		super(fecha, terminal);
	}
	
	
	@Override //FECHA DE SALIDA DE LA TERMINAL DESDE EL VIAJE.
	public List<Viaje> filtrar(List<Viaje> viajes) {
		
		List<Viaje> filtrados = viajes.stream()
									  .filter(viaje -> viaje.tieneTerminal(terminal) 
									   && this.fechaEsMenorALaDelFiltro(viaje.fechaAsignadaA(terminal)))
									  .collect(Collectors.toList());
				
				
		return filtrados;
	}

}
