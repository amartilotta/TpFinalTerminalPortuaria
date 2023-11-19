package tpFinalTerminalPortuaria.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;

class ServicioHigieneTestCase {
	private ServicioHigiene servicio;
	private Container container;
	
	@BeforeEach
	void setUp() throws Exception {
		container = mock(Container.class);
		servicio  = new ServicioHigiene(1200d, 100d);
	}

	@Test
	void cuandoSeCreaUnServicioHigiene_TieneUnPrecioFijoYUnPrecioPorMinimoVolumen() {
		assertTrue(servicio.getPrecioFijo() == 1200d);
		assertTrue(servicio.getPrecioPorMinimoVol() == 100d);
	}

	@Test
	void cambioElValorDelPrecioFijo_Y_VerificoElCambio() {
		servicio.setPrecioFijo(100d);
		assertEquals(servicio.getPrecioFijo(), 100d);
	}
	
	@Test
	void cambioElValorDelMinimoVolumenYVerifico() {
		servicio.setPrecioPorMinimoVol(80d);
		assertEquals(servicio.getPrecioPorMinimoVol(), 80d);
	}

	@Test
	void verificoQueElPrecioFinalDelServicioEs_100d_PorQueElContainerTieneUnVolumenMenorA70() {
		when(container.volumen()).thenReturn(60d);
		assertEquals(servicio.precioFinal(container), 100d);
	} 
}
