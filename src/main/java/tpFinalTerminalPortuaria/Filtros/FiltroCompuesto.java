package tpFinalTerminalPortuaria.Filtros;

import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public abstract class FiltroCompuesto implements IFiltroDeBusqueda{

	@Override
	public abstract List<CircuitoMaritimo> filtrar(List<CircuitoMaritimo> circuitos);

}
