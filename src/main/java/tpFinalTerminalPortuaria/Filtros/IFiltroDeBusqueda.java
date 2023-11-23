package tpFinalTerminalPortuaria.Filtros;

import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

public interface IFiltroDeBusqueda {
	public List<CircuitoMaritimo> filtrar(List<CircuitoMaritimo> circuitos);

}
