package tpFinalTerminalPortuaria.Orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Servicios.ServicioHigiene;
import tpFinalTerminalPortuaria.Viaje.Viaje;

class OrdenExportacionTestCase {
	private OrdenExportacion orden;
	private Viaje viaje;
	private Shipper cliente;
	private Chofer chofer;
	private Camion camion;
	private List<Servicio> servicios;
	private Container container;
	private ServicioHigiene servicioHigiene;
	
	@BeforeEach
	void setUp() throws Exception {
		viaje     = mock(Viaje.class);
		cliente   = mock(Shipper.class);
		chofer    = mock(Chofer.class);
		camion    = mock(Camion.class);
		servicios = new ArrayList<Servicio>();
		servicioHigiene = mock(ServicioHigiene.class);
		orden	  = new OrdenExportacion(viaje, container, cliente, chofer, camion, servicios);
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
	void agregoServicioHigieneALaOrdenYVerificoQueLaCantidadDeServiciosEs1() {
		orden.agregarServicio(servicioHigiene);
		assertEquals(orden.getServicios().size(), 1);	
	}
	
	@Test
	void agregoServicioDeHigieneConUnValorDe90ALaOrden_Y_VerificoQueElPrecioTotalDeServiciosEs90d() {
		when(container.volumen()).thenReturn(50d);
		when(servicioHigiene.getPrecioPorMinimoVol()).thenReturn(90d);
		when(servicioHigiene.precioFinal(container)).thenReturn(90d);
		orden.agregarServicio(servicioHigiene);
		assertEquals(orden.precioTotalServicios(), 90d);
	}
	

}















