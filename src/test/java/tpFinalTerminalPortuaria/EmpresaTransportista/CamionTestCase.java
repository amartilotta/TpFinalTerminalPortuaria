package tpFinalTerminalPortuaria.EmpresaTransportista;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class CamionTestCase {
	private Camion camion;
	
	@Before
	public void setUp() throws Exception {
		camion = new Camion("73C");
	}

	@Test
	public void verificoQueElCamionTienePatente() {
		assertFalse(camion.getPatente().isEmpty());
	}
	
	@Test
	public void cambioLaPatenteYVerificoQueElCambioFueExitoso() {
		camion.setPatente("32A");
		assertEquals(camion.getPatente(), "32A");
	}

}
