package tpFinalTerminalPortuaria.Persona;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.Persona.Consignee;

class ConsigneeTestCase {
	private Consignee consignee;
	
	@BeforeEach
	void setUp() throws Exception {
		this.consignee = new Consignee("JUAN","GARCIA", "1234" );
	}

	@Test
	void cuandoSeCreaUnConsignee_EsteTieneSusDatosPersonalesCargados() {
		assertEquals(consignee.getNombre(), "JUAN");
		assertEquals(consignee.getApellido(), "GARCIA");
		assertEquals(consignee.getDNI(), "1234");
	}
	
	@Test
	void verificoQueElCambioDeApellidoFunciona() {
		assertEquals(consignee.getApellido(), "GARCIA");
		consignee.setApellido("PEREZ");
		assertEquals(consignee.getApellido(), "PEREZ");
	}
	
	@Test
	void verificoQueElCambioDeNombreFunciona() {
		assertEquals(consignee.getNombre(), "JUAN");
		consignee.setNombre("JUANA");
		assertEquals(consignee.getNombre(), "JUANA");
	}
	
	@Test
	void verificoQueElCambioDeDNIFunciona() {
		assertEquals(consignee.getDNI(), "1234");
		consignee.setDNI("4321");
		assertEquals(consignee.getDNI(), "4321");
	}
	

}
