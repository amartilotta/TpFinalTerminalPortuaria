package tpFinalTerminalPortuaria.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;

class ServicioPesajeTestCase {
	private ServicioPesaje servicio;
	private Container container;
	
	@BeforeEach
	void setUp() throws Exception {
		container = mock(Container.class);
		servicio  = new ServicioPesaje(1200d);
	}

	@Test
	void cuandoSeCreaUnServicioPesajeTieneUnPrecioFijo() {
		assertTrue(servicio.getPrecioFijo() == 1200d);
	}

	@Test
	void cambioElValorDelPrecioFijoYVerificoElCambio() {
		servicio.setPrecioFijo(100d);
		assertEquals(servicio.getPrecioFijo(), 100d);
	}
	
	@Test 
	void verificoQueElPrecioFinalDelServicioEsIgualAlPrecioFijo(){
		assertEquals(servicio.precioFinal(container), servicio.getPrecioFijo());
	}
}
