package tpFinalTerminalPortuaria.EmpresaTransportistaTest;

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
		chofer = new Chofer("Valentina", "Reigada", "22334");
	}

	@Test
	void validoQueElChoferTieneSusDatosPersonalesCargados() {
		assertEquals(chofer.getApellido(), "Reigada");
		assertEquals(chofer.getNombre(), "Valentina");
		assertEquals(chofer.getDNI(), "22334");
	}

}
