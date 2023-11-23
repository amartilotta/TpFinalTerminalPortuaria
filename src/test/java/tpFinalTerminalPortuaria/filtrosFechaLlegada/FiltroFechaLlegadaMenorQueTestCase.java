package tpFinalTerminalPortuaria.filtrosFechaLlegada;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Filtros.FiltroFechaLlegadaMenorQue;


public class FiltroFechaLlegadaMenorQueTestCase {
	private LocalDate fecha1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private FiltroFechaLlegadaMenorQue filtro;
	private CircuitoMaritimo circuitoA;
	private CircuitoMaritimo circuitoB;
	private List<CircuitoMaritimo> circuitos;
	
	
	@Before
	public void SetUp() {
		fecha1 = LocalDate.of(2015, 10, 4);
		fecha2 = LocalDate.of(2015, 10, 4);
		fecha3 = LocalDate.of(1977, 7, 15);
		filtro = new FiltroFechaLlegadaMenorQue(fecha1);
		circuitoA = mock(CircuitoMaritimo.class);
		circuitoB = mock(CircuitoMaritimo.class);
		circuitos = new ArrayList<CircuitoMaritimo>();
	}
	
	@Test
	public void cuandoSeCreaUnFiltroFechaLlegadaMenorQue_EsteTieneUnaFechaDada() {
		assertEquals(fecha1, filtro.getFecha());
	}
	
	@Test
	public void cuandoAUnFiltroFechaLlegadaMenorQue_LePidoFiltrarUnaListaDeCircuitosVacia_EntoncesDevuelveUnaListaVacía() {
		assertEquals(0, filtro.filtrar(circuitos).size());
	}
	
	@Test
	public void verificar() {
		
	}
	
}
