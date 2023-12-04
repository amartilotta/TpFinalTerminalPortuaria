package tpFinalTerminalPortuaria.EmpresaTransportista;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class ChoferTestCase {
	private Chofer chofer;
	 
	@Before
	public void setUp() throws Exception {
		chofer = new Chofer("Juana", "Viale", "22334", "email@yahoo.com");
	}

	@Test
	public void validoQueElChoferTieneSusDatosPersonalesCargados() {
		assertEquals(chofer.getApellido(), "Viale");
		assertEquals(chofer.getNombre(), "Juana");
		assertEquals(chofer.getDNI(), "22334");
		assertEquals(chofer.getEmail(), "email@yahoo.com");
	}

	@Test
	public void cambioApellidoPor_Perez_YVerificoElCambio() {
		chofer.setApellido("Perez");
		assertEquals(chofer.getApellido(), "Perez");
	}
	
	@Test
	public void verificoQueElCambioDeEmailFunciona() {
		assertEquals(chofer.getEmail(), "email@yahoo.com");
		chofer.setEmail("email2@yahoo.com");
		assertEquals(chofer.getEmail(), "email2@yahoo.com");
	}
}
