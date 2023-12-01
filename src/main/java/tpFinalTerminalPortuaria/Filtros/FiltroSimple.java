package tpFinalTerminalPortuaria.Filtros;

import java.util.List;

import tpFinalTerminalPortuaria.Viaje.Viaje;

public abstract class FiltroSimple implements IFiltroDeBusqueda{

	@Override
	public abstract List<Viaje> filtrar(List<Viaje> viajes);

}
