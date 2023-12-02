package tpFinalTerminalPortuaria.Servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.Container;

public class ServicioPesajeTestCase {
	private ServicioPesaje servicio;
	private Container container;
	
	@Before
	public void setUp() throws Exception {
		container = mock(Container.class);
		servicio  = new ServicioPesaje(1200d, container);
	}

	@Test
	public void cuandoSeCreaUnServicioPesajeTieneUnPrecioFijo() {
		assertTrue(servicio.getPrecioFijo() == 1200d);
	}

	@Test
	public void cambioElValorDelPrecioFijoYVerificoElCambio() {
		servicio.setPrecioFijo(100d);
		assertTrue(servicio.getPrecioFijo() == 100d);
	}
	
	@Test 
	public void verificoQueElPrecioFinalDelServicioEsIgualAlPrecioFijo(){
		assertEquals(servicio.precioFinal(), servicio.getPrecioFijo());
	}
}
