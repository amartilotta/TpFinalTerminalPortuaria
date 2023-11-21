package tpFinalTerminalPortuaria.Persona;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShipperTestCase {
	private Shipper shipper;
	
	@Before
	public void setUp() throws Exception {
		shipper = new Shipper("MATIAS", "SOSA", "1234");
	}

	@Test
	public void cuandoSeCreaUnshipper_EsteTieneSusDatosPersonalesCargados() {
		assertEquals(shipper.getNombre(), "MATIAS");
		assertEquals(shipper.getApellido(), "SOSA");
		assertEquals(shipper.getDNI(), "1234");
	}
	
	@Test
	public void verificoQueElCambioDeApellidoFunciona() {
		assertEquals(shipper.getApellido(), "SOSA");
		shipper.setApellido("PEREZ");
		assertEquals(shipper.getApellido(), "PEREZ");
	}
	
	@Test
	public void verificoQueElCambioDeNombreFunciona() {
		assertEquals(shipper.getNombre(), "MATIAS");
		shipper.setNombre("JUANA");
		assertEquals(shipper.getNombre(), "JUANA");
	}
	
	@Test
	public void verificoQueElCambioDeDNIFunciona() {
		assertEquals(shipper.getDNI(), "1234");
		shipper.setDNI("4321");
		assertEquals(shipper.getDNI(), "4321");
	}
	

}
