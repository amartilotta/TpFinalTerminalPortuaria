package tpFinalTerminalPortuaria.Container;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ContainerDryTestCase {
	private ContainerDry container;
	
	@Before
	public void setUp() throws Exception {
		this.container = new ContainerDry(300d, 200d, 1200d, 5100d);
	}

	@Test
	public void verificoQueCuandoSeCreaContainerTieneTodasSusDimencionesDeclaradas() {
		assertTrue(container.getAltura() == 1200d);
		assertTrue(container.getAncho()== 300d);
		assertTrue(container.getLargo()== 200d);
		assertTrue(container.getPeso()== 5100d);
		
	}
	
	@Test
	public void verificoQueElVolumenDelContainerEs_72000000d() {
		assertTrue(container.volumen() == 72000000d);
	}

	@Test
	public void cambioAlturaA_1300dYVerificoQueLaModificacionFueExitosa() {
		container.setAltura(1300d);
		assertTrue(container.getAltura() == 1300d);
	}
	
}
