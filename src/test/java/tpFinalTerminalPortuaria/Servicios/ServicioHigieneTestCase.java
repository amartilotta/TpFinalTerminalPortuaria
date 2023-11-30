package tpFinalTerminalPortuaria.Servicios;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.Container;

public class ServicioHigieneTestCase {
	private ServicioHigiene servicio;
	private Container container;
	
	@Before
	public void setUp() throws Exception {
		container = mock(Container.class);
		servicio  = new ServicioHigiene(1200d, 100d, container);
	}
 
	@Test
	public void cuandoSeCreaUnServicioHigiene_TieneUnPrecioFijoYUnPrecioPorMinimoVolumen() {
		assertTrue(servicio.getPrecioFijo() == 1200d);
		assertTrue(servicio.getPrecioPorMinimoVol() == 100d);
	}

	@Test
	public void cambioElValorDelPrecioFijo_Y_VerificoElCambio() {
		servicio.setPrecioFijo(100d);
		assertTrue(servicio.getPrecioFijo() == 100d);
	}
	
	@Test
	public void cambioElValorDelMinimoVolumenYVerifico() {
		servicio.setPrecioPorMinimoVol(80d);
		assertTrue(servicio.getPrecioPorMinimoVol()== 80d);
	}

	@Test
	public void verificoQueElPrecioFinalDelServicioEs_100d_PorQueElContainerTieneUnVolumenMenorA70() {
		when(container.volumen()).thenReturn(60d);
		assertTrue(servicio.precioFinal() == 100d);
	} 
}
