package tpFinalTerminalPortuaria.Filtros;

import java.util.List;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroPuertoDestinoIgualQue extends FiltroSimple{
	private Terminal puertoDestino;
	
	public FiltroPuertoDestinoIgualQue(Terminal puertoDestino) {
		this.puertoDestino = puertoDestino;
	}
	
	//GETTER.
	public Terminal getDestino() {
		return this.puertoDestino;
	}
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
	/*	List<CircuitoMaritimo> filtrados = viajes.stream().
				filter(circuito -> circuito.getPuertoDestino() == this.getDestino())
				.collect(Collectors.toList());		*/		
		return null;
	}

}
