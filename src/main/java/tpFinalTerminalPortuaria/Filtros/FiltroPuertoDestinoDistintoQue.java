package tpFinalTerminalPortuaria.Filtros;

import java.util.List;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroPuertoDestinoDistintoQue extends FiltroSimple{
	private Terminal puertoDestino;
	
	public FiltroPuertoDestinoDistintoQue(Terminal puertoDestino) {
		this.puertoDestino = puertoDestino;
	}
	
	//GETTER.
	public Terminal getDestino() {
		return this.puertoDestino;
	}
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		
		List<Viaje> filtrados = viajes.stream()
									  .filter(viaje -> !viaje.tieneTerminal(puertoDestino))
									  .collect(Collectors.toList());

		return filtrados;
	}

}
