package tpFinalTerminalPortuaria.Buque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class BuqueTestCase {
	private Buque buque;
	private Container container;
	private FaseInbound faseInbound;
	private FaseOutbound faseOutbound;
	private FaseArrived faseArrived;
	private FaseWorking faseWorking;
	private FaseDeparting faseDeparting;
	private TerminalGestionada terminal;
	
	@Before
	public void setUp() throws Exception {
		buque = new Buque("BUQUE");
		container     = mock(Container.class);
		faseInbound   =	mock(FaseInbound.class);
		faseOutbound  = mock(FaseOutbound.class);
		faseArrived   = mock(FaseArrived.class);
		faseWorking   = mock(FaseWorking.class);
		faseDeparting = mock(FaseDeparting.class);
		terminal      = mock(TerminalGestionada.class);
	}

	@Test
	public void verificoQueElBuqueRecienCreadoTieneUnNombreAsignado() {
		assertEquals(buque.getNombre(), "BUQUE");
	}
	
	@Test
	public void verificoQueElBuqueRecienCreadoTieneUnaFaseAsignada() {
		assertTrue(buque.getFase() != null);
	}
	
	@Test
	public void verificoQueElBuqueRecienCreadoNoTieneContainerAsignado() {
		assertEquals(buque.getContainer().size(), 0);
	}
	
	@Test
	public void agregoUnContainerYVerificoQueElBuqueTieneUnaListaDeContainerConTamañoUno() {
		buque.agregarContainer(container);
		assertEquals(buque.getContainer().size(), 1);
	}
	
	@Test
	public void agregoUnContainerALaLista_Y_DespuesLoElimino_YVerificoQueLaEliminacionFueExitosa() {
		buque.agregarContainer(container);
		assertEquals(buque.getContainer().size(), 1);
		buque.eliminarContainer(container);
		assertEquals(buque.getContainer().size(), 0);
	}
	
	//TEST DE LAS FASES.
	@Test
	public void elBuqueEstaEnFaseOutboundYSeEncuentraConUnaDistanciaDe70ATerminal_Entonces_AlPedirQueSeActualiceFase_SigueLaMisma() {
		Ubicacion ubicacionBuque = buque.ubicacionActual();
		Ubicacion ubicacionTerminal = buque.ubicacionActual() + 70; //setear ubicacion de terminal, a una distancia de 70.
		when(terminal.getUbicacion()).thenReturn(ubicacionTerminal);
		buque.setFase(faseOutbound);
		buque.actualizarFase(terminal);
		verify(terminal, times(0)).procesarOrdenSegunBuque(buque);
		assertEquals(buque.getFase(), faseOutbound);
	}

	@Test
	public void elBuqueEstaEnFaseOutboundYSeEncuentraConUnaDistanciaDe30ATerminal_Entonces_AlPedirQueSeActualiceFase_CambiaAInbound() {
		Ubicacion ubicacionBuque = buque.ubicacionActual();
		Ubicacion ubicacionTerminal = buque.ubicacionActual() + 30; //setear ubicacion de terminal, a una distancia de 70.
		when(terminal.getUbicacion()).thenReturn(ubicacionTerminal);
		buque.setFase(faseOutbound);
		buque.actualizarFase(terminal);
		verify(terminal, times(1)).procesarOrdenSegunBuque(buque);//a terminal le llega mensaje de procesar orden
		assertTrue(buque.getFase()!= faseOutbound);
	}
	
	@Test
	public void elBuqueEstaEnFaseInboundYSeEncuentraConUnaDistanciaIgualATerminal_Entonces_AlPedirQueSeActualiceFase_CambiaArrived() {
		Ubicacion ubicacionBuque = buque.ubicacionActual();
		when(terminal.getUbicacion()).thenReturn(ubicacionBuque);
		buque.setFase(faseInbound);
		buque.actualizarFase(terminal);
		
		assertTrue(buque.getFase()!= faseInbound);
	}
	
	
}




