package tpFinalTerminalPortuaria.Orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Servicios.ServicioPesaje;
import tpFinalTerminalPortuaria.Viaje.Viaje;

class OrdenImportacionTestCase {
	private OrdenImportacion orden;
	private Viaje viaje;
	private Consignee cliente;
	private Chofer chofer;
	private Camion camion;
	private List<Servicio> servicios;
	private Container container;
	private ServicioPesaje servicioPesaje;
	
	@BeforeEach
	void setUp() throws Exception {
		viaje     = mock(Viaje.class);
		cliente   = mock(Consignee.class);
		chofer    = mock(Chofer.class);
		camion    = mock(Camion.class);
		servicios = new ArrayList<Servicio>();
		servicioPesaje = mock(ServicioPesaje.class);
		orden	  = new OrdenImportacion(viaje, container, cliente, chofer, camion, servicios);
	}

	@Test
	void cuandoSeCreaUnaOrdenTiene_Viaje_Cliente_chofer_camion_servicios_orden() {
		assertEquals(orden.getCamion(), camion);
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getCliente(), cliente);
		assertEquals(orden.getServicios(), servicios);
		assertEquals(orden.getViaje(), viaje);
	}
	
	@Test
	void cuandoSeCreaUnaOrdenNoTieneServiciosCargados() {
		assertEquals(orden.getServicios().size(), 0);
	}
	
	@Test
	void cuandoSeCreaUnaOrden_EstaPendienteAProcesar() {
		assertTrue(orden.estaPendiente());
	}
	
	@Test
	void agregoServicioPesajeALaOrdenYVerificoQueLaCantidadDeServiciosEs1() {
		orden.agregarServicio(servicioPesaje);
		assertEquals(orden.getServicios().size(), 1);	
	}
	
	@Test
	void eliminoServicioDePesajeALaOrdenQueTieneEseServicioYVerificoQueYaNoExiste() {
		orden.agregarServicio(servicioPesaje);
		assertTrue(orden.getServicios().contains(servicioPesaje));
		orden.eliminarServicio(servicioPesaje);
		assertFalse(orden.getServicios().contains(servicioPesaje));
	}
	
	@Test
	void verificoQueElPrecioTotalDeServicioEs0d_PorqueNoHayServiciosEnLaOrden() {
		assertEquals(orden.precioTotalServicios(), 0d);
	}
	
	@Test
	void agregoServicioDePesajeConUnValorDe90ALaOrden_Y_VerificoQueElPrecioTotalDeServiciosEs90d() {
		orden.agregarServicio(servicioPesaje);
		when(servicioPesaje.precioFinal(container)).thenReturn(90d);
		assertEquals(orden.precioTotalServicios(), 90d);
	}
}




