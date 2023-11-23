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
import tpFinalTerminalPortuaria.Filtros.FiltroPuertoDestinoIgualQue;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroPuertoDestinoIgualQueTestCase {
	private CircuitoMaritimo circuitoA;
	private CircuitoMaritimo circuitoB;
	private List<CircuitoMaritimo> circuitos;
	private List<CircuitoMaritimo> circuitosB;
	private FiltroPuertoDestinoIgualQue filtro;
	private Terminal terminalMock;
	private Terminal terminalMock2;
	@Before
	public void SetUp() {
		circuitoA = mock(CircuitoMaritimo.class);
		circuitoB = mock(CircuitoMaritimo.class);
		circuitos = new ArrayList<CircuitoMaritimo>();
		circuitosB = new ArrayList<CircuitoMaritimo>();
		terminalMock  = mock(Terminal.class);
		terminalMock2 = mock(Terminal.class);
		filtro = new FiltroPuertoDestinoIgualQue(terminalMock);
	}
	
	@Test
	public void cuandoCreoFiltroPuertoDestinoIgualQue_EsteTieneUnaTerminal() {
		assertEquals(filtro.getDestino(), terminalMock);
	}
	
	@Test
	public void cuandoAUnFiltroPuertoDestinoIgualQue_LePidoFiltrarUnaListaDeCircuitosVacia_EntoncesDevuelveUnaListaVacía() {
		assertTrue(filtro.filtrar(circuitos).size() == 0);
	}
	
	@Test
	public void cuandoFiltroConCircuitosQueNoTienenPuertoDestinoIgualQueElPuertoDelFiltro_EntoncesDevuelveListaVacia() {
		when(circuitoA.getPuertoDestino()).thenReturn(terminalMock2);
		when(circuitoB.getPuertoDestino()).thenReturn(terminalMock2);
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
	
	
}



