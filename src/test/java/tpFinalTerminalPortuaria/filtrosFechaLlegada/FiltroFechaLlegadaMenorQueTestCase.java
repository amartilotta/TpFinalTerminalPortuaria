package tpFinalTerminalPortuaria.filtrosFechaLlegada;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Filtros.FiltroFechaLlegadaMayorQue;
import tpFinalTerminalPortuaria.Filtros.FiltroFechaLlegadaMenorQue;
import tpFinalTerminalPortuaria.Viaje.Viaje;


public class FiltroFechaLlegadaMenorQueTestCase {
	private LocalDate fecha1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private FiltroFechaLlegadaMenorQue filtro;
	private Viaje viajeA;
	private Viaje viajeB;
	private List<Viaje> viajes;
	
	
	@Before
	public void SetUp() {
		fecha1 = LocalDate.of(2015, 10, 4);
		fecha2 = LocalDate.of(2015, 10, 4);
		fecha3 = LocalDate.of(1977, 7, 15);
		filtro = new FiltroFechaLlegadaMenorQue(fecha1);
		viajeA = mock(Viaje.class);
		viajeB = mock(Viaje.class);
		viajes = new ArrayList<Viaje>();
	}
	
	@Test
	public void cuandoSeCreaUnFiltroFechaLlegadaMenorQue_EsteTieneUnaFechaDada() {
		assertEquals(fecha1, filtro.getFecha());
	}
	
	@Test
	public void cuandoAUnFiltroFechaLlegadaMenorQue_LePidoFiltrarUnaListaDeCircuitosVacia_EntoncesDevuelveUnaListaVacía() {
		assertEquals(0, filtro.filtrar(viajes).size());
	}
	
	@Test
	public void verificar() {
		
	}
	
}
