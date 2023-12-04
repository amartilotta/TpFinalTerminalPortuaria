package tpFinalTerminalPortuaria.Orden;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	public void cambioCLienteA_OtroClienteYVerificoQueLaModificacionFueExitosa() {
		Shipper otroCliente = mock(Shipper.class);
		orden.setCliente(otroCliente);
		assertEquals(orden.getCliente(),otroCliente);
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
		when(servicioHigiene.precioFinal()).thenReturn(90d);
		orden.agregarServicio(servicioHigiene);
		assertTrue(orden.precioTotalServicios() == 90d);
	}
	
	@Test
	public void cambioViajeA_OtroViajeYVerificoQueLaModificacionFueExitosa() {
		Viaje otroViaje = mock(Viaje.class);
		orden.setViaje(otroViaje);
		assertEquals(orden.getViaje(),otroViaje);
	}
	
	@Test
	public void cambioContainerA_OtroContainerYVerificoQueLaModificacionFueExitosa() {
		Container otroContainer = mock(Container.class);
		orden.setContainer(otroContainer);
		assertEquals(orden.getContainer(),otroContainer);
	}
	
	@Test
	public void cambioChoferA_OtroChoferYVerificoQueLaModificacionFueExitosa() {
		Chofer otroChofer = mock(Chofer.class);
		orden.setChofer(otroChofer);
		assertEquals(orden.getChofer(),otroChofer);
	}
	
	@Test
	public void cambioCamionA_OtroCamionYVerificoQueLaModificacionFueExitosa() {
		Camion otroCamion = mock(Camion.class);
		orden.setCamion(otroCamion);
		assertEquals(orden.getCamion(),otroCamion);
	}
	
	@Test
	public void cambioElEstadoDeEstaPendienteA_FalsoYVerificoQueLaModificacionFueExitosa() {
		orden.setEstaPendiente(false);
		assertFalse(orden.estaPendiente());
	}
	

}















