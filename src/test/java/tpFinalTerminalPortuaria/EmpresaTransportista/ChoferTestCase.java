package tpFinalTerminalPortuaria.EmpresaTransportista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;

class ChoferTestCase {
	private Chofer chofer;
	 
	@BeforeEach
	void setUp() throws Exception {
		chofer = new Chofer("Juana", "Viale", "22334");
	}

	@Test
	void validoQueElChoferTieneSusDatosPersonalesCargados() {
		assertEquals(chofer.getApellido(), "Viale");
		assertEquals(chofer.getNombre(), "Juana");
		assertEquals(chofer.getDNI(), "22334");
	}

	@Test
	void cambioApellidoPor_Perez_YVerificoElCambio() {
		chofer.setApellido("Perez");
		assertEquals(chofer.getApellido(), "Perez");
	}
}
