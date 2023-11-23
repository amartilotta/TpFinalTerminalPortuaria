package tpFinalTerminalPortuaria.Filtros;

import java.time.LocalDate;
import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class FiltroFechaLlegadaIgualQue extends FiltroSimple{
	private LocalDate fecha;
	
	public FiltroFechaLlegadaIgualQue(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	//GETTERS.
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	@Override
	public List<CircuitoMaritimo> filtrar(List<CircuitoMaritimo> circuitos) {
		// TODO Auto-generated method stub
		return null;
	}

}
