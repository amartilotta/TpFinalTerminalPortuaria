package tpFinalTerminalPortuaria.Servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.ContainerReefer;

public class ServicioElectricidadTestCase {
	private ServicioElectricidad servicio;
	private ContainerReefer container;
	private LocalDateTime fechaYHInicio;
	private LocalDateTime fechaYHFin;
	 
	@Before
	public void setUp() throws Exception {
		container     = mock(ContainerReefer.class);
		fechaYHInicio = LocalDateTime.of(2023, 12, 25, 15, 30);
		fechaYHFin    = LocalDateTime.of(2023, 12, 26, 15, 30);
		servicio      = new ServicioElectricidad(1200d, fechaYHInicio, fechaYHFin, container);	
	}
	
	
	@Test
	public void cuandoSeCreaServicioElectricidad_TieneSusDatosCargados() {
		assertEquals(servicio.getFechaYHoraFin(), fechaYHFin);
		assertEquals(servicio.getFechaYHoraInicio(), fechaYHInicio);
		assertTrue(servicio.getPrecioFijo() == 1200d);
	}

	@Test
	public void verificoQueElCambioDePreciFijoEsExitoso() {
		servicio.setPrecioFijo(2000d);
		assertTrue(servicio.getPrecioFijo() == 2000d);
	}
	
	@Test
	public void verificoQueElCambioDeFechaYHoraFin_EsExitoso() {
		LocalDateTime fechaYHora = LocalDateTime.now().plusDays(1);
		servicio.setFechaYHoraFin(fechaYHora);
		assertEquals(servicio.getFechaYHoraFin(), fechaYHora);
	}
	
	@Test
	public void verificoQueLosKWConsumidosSon_28800d() {
		//SEGUN LAS FECHAS DADAS HAY UNA DIFERENCIA DE 24HS.
		//24 * consumoDelRefer() seria los kwconsumidos.
		when(container.getConsumo()).thenReturn(1200d);
		Double kwConsumidos = servicio.totalKWConsumidos();
		assertTrue(kwConsumidos ==  28800.0d);
		
	}
	
	@Test 
	public void verificoQueElPrecioFinalDelServicioEs3456E7(){
		when(container.getConsumo()).thenReturn(1200d);
		//Double kwConsumidos = servicio.totalKWConsumidos();
		//Double precioFinalEsperado = kwConsumidos * servicio.getPrecioFijo();
		assertTrue(servicio.precioFinal() == 3.456E7);
	}
	 
}







