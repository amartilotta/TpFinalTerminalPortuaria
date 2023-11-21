package tpFinalTerminalPortuaria.Persona;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConsigneeTestCase {
	private Consignee consignee;
	
	@Before
	public void setUp() throws Exception {
		this.consignee = new Consignee("JUAN","GARCIA", "1234" );
	}

	@Test
	public void cuandoSeCreaUnConsignee_EsteTieneSusDatosPersonalesCargados() {
		assertEquals(consignee.getNombre(), "JUAN");
		assertEquals(consignee.getApellido(), "GARCIA");
		assertEquals(consignee.getDNI(), "1234");
	}
	
	@Test
	public void verificoQueElCambioDeApellidoFunciona() {
		assertEquals(consignee.getApellido(), "GARCIA");
		consignee.setApellido("PEREZ");
		assertEquals(consignee.getApellido(), "PEREZ");
	}
	
	@Test
	public void verificoQueElCambioDeNombreFunciona() {
		assertEquals(consignee.getNombre(), "JUAN");
		consignee.setNombre("JUANA");
		assertEquals(consignee.getNombre(), "JUANA");
	}
	
	@Test
	public void verificoQueElCambioDeDNIFunciona() {
		assertEquals(consignee.getDNI(), "1234");
		consignee.setDNI("4321");
		assertEquals(consignee.getDNI(), "4321");
	}
	

}
