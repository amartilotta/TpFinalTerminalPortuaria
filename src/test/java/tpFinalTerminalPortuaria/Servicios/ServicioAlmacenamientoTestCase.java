package tpFinalTerminalPortuaria.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;

class ServicioAlmacenamientoTestCase {
	private ServicioAlmacenamiento servicio;
	private Container container;
	
	@BeforeEach
	void setUp() throws Exception {
		container = mock(Container.class);
		servicio  = new ServicioAlmacenamiento(1200d);
	}

	@Test
	void cuandoSeCreaUnServicioAlmacenamiento_TieneUnPrecioFijo() {
		assertTrue(servicio.getPrecioFijo() == 1200d);
	}

	@Test
	void cambioElValorDelPrecioFijo_Y_VerificoElCambio() {
		servicio.setPrecioFijo(100d);
		assertEquals(servicio.getPrecioFijo(), 100d);
	}
	
	@Test 
	void verificoQueElPrecioFinalDelServicioEsIgualAlPrecioFijo(){
		assertEquals(servicio.precioFinal(container), servicio.getPrecioFijo());
	}

}
