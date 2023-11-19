package tpFinalTerminalPortuaria.EmpresaTransportistaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;

class CamionTestCase {
	private Camion camion;
	
	@BeforeEach
	void setUp() throws Exception {
		camion = new Camion("73C");
	}

	@Test
	void verificoQueElCamionTienePatente() {
		assertFalse(camion.getPatente().isEmpty());
	}

}
