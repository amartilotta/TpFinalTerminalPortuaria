package tpFinalTerminalPortuaria.Orden;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Servicios.ServicioPesaje;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenImportacionTestCase {
	private OrdenImportacion orden;
	private Viaje viaje;
	private Consignee cliente;
	private Chofer chofer;
	private Camion camion;
	private List<Servicio> servicios;
	private Container container;
	private ServicioPesaje servicioPesaje;
	
	@Before
	public void setUp() throws Exception {
		viaje     = mock(Viaje.class);
		cliente   = mock(Consignee.class);
		chofer    = mock(Chofer.class);
		camion    = mock(Camion.class);
		servicios = new ArrayList<Servicio>();
		servicioPesaje = mock(ServicioPesaje.class);
		orden	  = new OrdenImportacion(viaje, container, chofer, camion, servicios, cliente);
	}

	@Test
	public void cuandoSeCreaUnaOrdenTiene_Viaje_Cliente_chofer_camion_servicios_orden() {
		assertEquals(orden.getCamion(), camion);
		assertEquals(orden.getChofer(), chofer);
		assertEquals(orden.getCliente(), cliente);
		assertEquals(orden.getServicios(), servicios);
		assertEquals(orden.getViaje(), viaje);
	}
	
	@Test
	public void cuandoSeCreaUnaOrdenNoTieneServiciosCargados() {
		assertEquals(orden.getServicios().size(), 0);
	}
	
	@Test
	public void cuandoSeCreaUnaOrden_EstaPendienteAProcesar() {
		assertTrue(orden.estaPendiente());
	}
	
	@Test
	public void agregoServicioPesajeALaOrdenYVerificoQueLaCantidadDeServiciosEs1() {
		orden.agregarServicio(servicioPesaje);
		assertEquals(orden.getServicios().size(), 1);	
	}
	
	@Test
	public void eliminoServicioDePesajeALaOrdenQueTieneEseServicioYVerificoQueYaNoExiste() {
		orden.agregarServicio(servicioPesaje);
		assertTrue(orden.getServicios().contains(servicioPesaje));
		orden.eliminarServicio(servicioPesaje);
		assertFalse(orden.getServicios().contains(servicioPesaje));
	}
	
	@Test
	public void verificoQueElPrecioTotalDeServicioEs0d_PorqueNoHayServiciosEnLaOrden() {
		assertTrue(orden.precioTotalServicios() == 0d);
	}
	
	@Test
	public void agregoServicioDePesajeConUnValorDe90ALaOrden_Y_VerificoQueElPrecioTotalDeServiciosEs90d() {
		orden.agregarServicio(servicioPesaje);
		when(servicioPesaje.precioFinal(container)).thenReturn(90d);
		assertTrue(orden.precioTotalServicios() == 90d);
	}
}




