package tpFinalTerminalPortuaria.Container;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ContainerTestCase {
	private Container container;
	private Tipo tipo;
	
	@Before
	public void setUp() throws Exception {
		this.container = new Container(300d, 200d, 1200d, 5100d, tipo.DRY);
	}

	@Test
	public void verificoQueCuandoSeCreaContainerTieneTodasSusDimencionesDeclaradas() {
		assertTrue(container.getAltura() == 1200d);
		assertTrue(container.getAncho()== 300d);
		assertTrue(container.getLargo()== 200d);
		assertTrue(container.getPeso()== 5100d);
		
	}
	
	@Test
	public void verificoQueElContainerEsDeTipoDRY() {
		assertEquals(container.getTipo(), tipo.DRY);
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
	
	@Test
	public void cambioAContainerRefeerConConsumo200KW_YVerificoQueTieneEseValor() {
		Tipo tipoRefeer = Tipo.REFEER;
		tipoRefeer.setConsumo(200d);
		container.setTipo(tipoRefeer);
		assertTrue(container.getConsumoKwHr() ==  200d);
	}
}
