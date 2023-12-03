package tpFinalTerminalPortuaria.filtrosPuertoDestino;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Filtros.FiltroPuertoDestinoDistintoQue;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroPuertoDestinoDistintoQueTestCase {
	private CircuitoMaritimo circuitoA;
	private CircuitoMaritimo circuitoB;
	private List<CircuitoMaritimo> circuitos;
	private FiltroPuertoDestinoDistintoQue filtro;
	private Terminal terminalMock;
	private Terminal terminalMock2;
	@Before
	public void SetUp() {
		circuitoA = mock(CircuitoMaritimo.class);
		circuitoB = mock(CircuitoMaritimo.class);
		circuitos = new ArrayList<CircuitoMaritimo>();
		terminalMock = mock(Terminal.class);
		terminalMock2 = mock(Terminal.class);
		filtro = new FiltroPuertoDestinoDistintoQue(terminalMock);
	}
	
	@Test
	public void cuandoCreoFiltroPuertoDestinoDistintoQue_EsteTieneUnaTerminal() {
		assertEquals(filtro.getDestino(), terminalMock);
	}
	
	@Test
	public void cuandoAUnFiltroPuertoDestinoDistintoQue_LePidoFiltrarUnaListaDeCircuitosVacia_EntoncesDevuelveUnaListaVacía() {
	//	assertTrue(filtro.filtrar(circuitos).size() == 0);
	}
	
	
/*	@Test
	public void cuandoFiltroConCircuitosQueNoTienenPuertoDestinoDistintoQueElPuertoDelFiltro_EntoncesDevuelveListaVacia() {
		when(circuitoA.getPuertoDestino()).thenReturn(terminalMock);
		when(circuitoB.getPuertoDestino()).thenReturn(terminalMock);
		circuitos.add(circuitoA);
		circuitos.add(circuitoB);
		List<CircuitoMaritimo> filtrados = filtro.filtrar(circuitos);
		assertTrue(filtrados.size() == 0);
	}
	
	@Test
	public void cuandoFiltroConCircuitosQueUnoTienenPuertoDestinoIgualQueElPuertoDelFiltro_EntoncesDevuelveListaConUnElemento() {
		when(circuitoA.getPuertoDestino()).thenReturn(terminalMock2);
		when(circuitoB.getPuertoDestino()).thenReturn(terminalMock);
		circuitos.add(circuitoA);
		circuitos.add(circuitoB);
		List<CircuitoMaritimo> filtrados = filtro.filtrar(circuitos);
		assertTrue(filtrados.size() == 1);
	}
	*/
}
