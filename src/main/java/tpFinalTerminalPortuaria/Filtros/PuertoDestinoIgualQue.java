package tpFinalTerminalPortuaria.Filtros;

import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class PuertoDestinoIgualQue extends FiltroSimple{
	private Terminal puertoDestino;
	
	public PuertoDestinoIgualQue(Terminal puertoDestino) {
		this.puertoDestino = puertoDestino;
	}
	
	//GETTER.
	public Terminal getDestino() {
		return this.puertoDestino;
	}
	
	@Override
	public List<CircuitoMaritimo> filtrar(List<CircuitoMaritimo> circuitos) {
		// TODO Auto-generated method stub
		return null;
	}

}
