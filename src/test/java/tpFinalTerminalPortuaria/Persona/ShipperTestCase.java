package tpFinalTerminalPortuaria.Persona;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Persona.Shipper;

class ShipperTestCase {
	private Shipper shipper;
	
	@BeforeEach
	void setUp() throws Exception {
		shipper = new Shipper("MATIAS", "SOSA", "1234");
	}

	@Test
	void cuandoSeCreaUnshipper_EsteTieneSusDatosPersonalesCargados() {
		assertEquals(shipper.getNombre(), "MATIAS");
		assertEquals(shipper.getApellido(), "SOSA");
		assertEquals(shipper.getDNI(), "1234");
	}
	
	@Test
	void verificoQueElCambioDeApellidoFunciona() {
		assertEquals(shipper.getApellido(), "SOSA");
		shipper.setApellido("PEREZ");
		assertEquals(shipper.getApellido(), "PEREZ");
	}
	
	@Test
	void verificoQueElCambioDeNombreFunciona() {
		assertEquals(shipper.getNombre(), "MATIAS");
		shipper.setNombre("JUANA");
		assertEquals(shipper.getNombre(), "JUANA");
	}
	
	@Test
	void verificoQueElCambioDeDNIFunciona() {
		assertEquals(shipper.getDNI(), "1234");
		shipper.setDNI("4321");
		assertEquals(shipper.getDNI(), "4321");
	}
	

}
