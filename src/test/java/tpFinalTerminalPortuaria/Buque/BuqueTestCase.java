package tpFinalTerminalPortuaria.Buque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class BuqueTestCase {
	private Buque buque;
	private Container container;
	private FaseArrived faseArrived;
	private TerminalGestionada terminal;
	
	@Before
	public void setUp() throws Exception {
		buque 		  = new Buque("BUQUE");
		container     = mock(Container.class);
		faseArrived   = mock(FaseArrived.class);
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
	
	@Test
	public void verificoQueCuandoCambioLaFaseDelBuqueAFaseArrived_ElCambioFueExitoso() {
		buque.setFase(faseArrived);
		assertEquals(buque.getFase(), faseArrived);
	}
	
	@Test 
	public void verificoQueElBuqueSeEncuentraALaMismaDistanciaDeTerminal() {
		when(terminal.getUbicacion()).thenReturn(buque.getUbicacion());
		assertTrue(buque.distanciaA(terminal.getUbicacion())== 0);
	}
	
	@Test
	public void verificoQueSiCambioElNombreABuque_ElCambioEsExitoso() {
		buque.setNombre("PRUEBA");
		assertEquals(buque.getNombre(), "PRUEBA");
	}
	
	@Test
	public void verificoQueSiABuqueLeMandanOrdenDepart_SeLoDelegaASuFase() {
		buque.setFase(faseArrived);
		buque.depart(terminal);
		verify(faseArrived).depart(terminal); 
	}
	
	@Test
	public void verificoQueSiABuqueLeMandanOrdenIniciarTrabajo_SeLoDelegaASuFase() {
		buque.setFase(faseArrived);
		buque.iniciarTrabajo(terminal);
		verify(faseArrived).iniciarTrabajo(terminal); 
	}
	
	@Test
	public void verificoQueSiABuqueLeMandanActualizar_SeLoDelegaASuFase() {
		buque.setFase(faseArrived);
		buque.actualizarFase(terminal);
		verify(faseArrived).actualizar(terminal); 
	}
} 

 


