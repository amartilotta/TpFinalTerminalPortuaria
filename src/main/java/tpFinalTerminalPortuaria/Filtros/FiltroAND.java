package tpFinalTerminalPortuaria.Filtros;

import java.util.ArrayList;
import java.util.List;

import tpFinalTerminalPortuaria.Viaje.Viaje;

public class FiltroAND extends FiltroCompuesto{
	private IFiltroDeBusqueda filtroA;
	private IFiltroDeBusqueda filtroB;
	
	public FiltroAND(IFiltroDeBusqueda filtroA, IFiltroDeBusqueda filtroB ) {
		super();
		this.filtroA = filtroA;
		this.filtroB = filtroB;
	}
	
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		
		List<Viaje> viajesDelFiltroA = this.filtroA.filtrar(viajes);
		List<Viaje> viajesDelFiltroB = this.filtroB.filtrar(viajes);
		List<Viaje> viajesFiltrados  = new ArrayList<Viaje>();
		
		viajesDelFiltroB.forEach(viaje ->{
			if (viajesDelFiltroA.contains(viaje)) {
				viajesFiltrados.add(viaje);
			}
		});

		return viajesFiltrados;
	}
}
