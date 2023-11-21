package tpFinalTerminalPortuaria.Orden;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Servicios.ServicioHigiene;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenExportacionTestCase {
	private OrdenExportacion orden;
	private Viaje viaje;
	private Shipper cliente;
	private Chofer chofer;
	private Camion camion;
	private List<Servicio> servicios;
	private Container container;
	private ServicioHigiene servicioHigiene;
	
	@Before
	public void setUp() throws Exception {
		viaje     = mock(Viaje.class);
		cliente   = mock(Shipper.class);
		chofer    = mock(Chofer.class);
		camion    = mock(Camion.class);
		container = mock(Container.class);
		servicios = new ArrayList<Servicio>();
		servicioHigiene = mock(ServicioHigiene.class);
		orden	  = new OrdenExportacion(viaje, container, chofer, camion, servicios, cliente);
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
	public void agregoServicioHigieneALaOrdenYVerificoQueLaCantidadDeServiciosEs1() {
		orden.agregarServicio(servicioHigiene);
		assertEquals(orden.getServicios().size(), 1);	
	}
	
	@Test
	public void agregoServicioDeHigieneConUnValorDe90ALaOrden_Y_VerificoQueElPrecioTotalDeServiciosEs90d() {
		when(container.volumen()).thenReturn(50d);
		when(servicioHigiene.getPrecioPorMinimoVol()).thenReturn(90d);
		when(servicioHigiene.precioFinal(container)).thenReturn(90d);
		orden.agregarServicio(servicioHigiene);
		assertTrue(orden.precioTotalServicios() == 90d);
	}
	

}















