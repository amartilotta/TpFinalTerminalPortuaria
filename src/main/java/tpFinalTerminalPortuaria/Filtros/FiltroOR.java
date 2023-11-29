package tpFinalTerminalPortuaria.Filtros;

import java.util.ArrayList;
import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public class FiltroOR extends FiltroCompuesto{
	private IFiltroDeBusqueda filtroA;
	private IFiltroDeBusqueda filtroB;
	
	public FiltroOR(IFiltroDeBusqueda filtroA, IFiltroDeBusqueda filtroB ) {
		super();
		this.filtroA = filtroA;
		this.filtroB = filtroB;
	}
	
	@Override
	public List<CircuitoMaritimo> filtrar(List<CircuitoMaritimo> circuitos) {
		List<CircuitoMaritimo> circuitosDelFiltroA = this.filtroA.filtrar(circuitos);
		List<CircuitoMaritimo> circuitosDelFiltroB = this.filtroB.filtrar(circuitos);
		List<CircuitoMaritimo> circuitosFiltrados  = new ArrayList<CircuitoMaritimo>(circuitosDelFiltroA);
		
		circuitosDelFiltroB.forEach(circuito ->{
			if (!circuitosFiltrados.contains(circuito)) {
				circuitosFiltrados.add(circuito);
			}
		});

		return circuitosFiltrados;
	}

}