package tpFinalTerminalPortuaria.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;

class ServicioElectricidadTestCase {
	private ServicioElectricidad servicio;
	private Container container;
	private LocalDateTime fechaYHInicio;
	private LocalDateTime fechaYHFin;
	
	@BeforeEach
	void setUp() throws Exception {
		container = mock(Container.class);
		fechaYHInicio = LocalDateTime.of(2023, 12, 25, 15, 30);
		fechaYHFin = LocalDateTime.of(2023, 12, 26, 15, 30);
		servicio  = new ServicioElectricidad(1200d, fechaYHInicio, fechaYHFin);	
	}
	
	
	@Test
	void cuandoSeCreaServicioElectricidad_TieneSusDatosCargados() {
		assertEquals(servicio.getFechaYHoraFin(), fechaYHFin);
		assertEquals(servicio.getFechaYHoraInicio(), fechaYHInicio);
		assertEquals(servicio.getPrecioFijo(), 1200d);
	}

	@Test
	void verificoQueElCambioDePreciFijoEsExitoso() {
		servicio.setPrecioFijo(2000d);
		assertEquals(servicio.getPrecioFijo(), 2000d);
	}
	
	@Test
	void verificoQueElCambioDeFechaYHoraFin_EsExitoso() {
		LocalDateTime fechaYHora = LocalDateTime.now().plusDays(1);
		servicio.setFechaYHoraFin(fechaYHora);
		assertEquals(servicio.getFechaYHoraFin(), fechaYHora);
	}
	
	@Test
	void verificoQueLosKWConsumidosSon_28800d() {
		//SEGUN LAS FECHAS DADAS HAY UNA DIFERENCIA DE 24HS.
		//24 * consumoDelRefer() seria los kwconsumidos.
		Double kwConsumidos = servicio.totalKWConsumidos(container);
		assertEquals(kwConsumidos, 28800.0d);
		
	}
	
	@Test 
	void verificoQueElPrecioFinalDelServicioEs(){
		Double kwConsumidos = servicio.totalKWConsumidos(container);
		Double precioFinalEsperado = kwConsumidos * servicio.getPrecioFijo();
		assertEquals(servicio.precioFinal(container), precioFinalEsperado);
	}
	
}







