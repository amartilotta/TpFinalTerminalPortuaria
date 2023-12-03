package tpFinalTerminalPortuaria.Filtros;

import java.util.List;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public interface IFiltroDeBusqueda {
	public List<Viaje> filtrar(List<Viaje> viajes);

}
