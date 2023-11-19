package tpFinalTerminalPortuaria.Container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainerTestCase {
	private Container container;
	private Tipo tipo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.container = new Container(300d, 200d, 1200d, 5100d, tipo.DRY);
	}

	@Test
	void verificoQueCuandoSeCreaContainerTieneTodasSusDimencionesDeclaradas() {
		assertEquals(container.getAltura(), 1200d);
		assertEquals(container.getAncho(), 300d);
		assertEquals(container.getLargo(), 200d);
		assertEquals(container.getPeso(), 5100d);
		
	}
	
	@Test
	void verificoQueElContainerEsDeTipoDRY() {
		assertEquals(container.getTipo(), tipo.DRY);
	}
	
	@Test
	void verificoQueElVolumenDelContainerEs_72000000d() {
		assertEquals(container.volumen(), 72000000d);
	}

	@Test
	void cambioAlturaA_1300dYVerificoQueLaModificacionFueExitosa() {
		container.setAltura(1300d);
		assertEquals(container.getAltura(), 1300d);
	}
	
	@Test
	void cambioAContainerRefeerConConsumo200KW_YVerificoQueTieneEseValor() {
		Tipo tipoRefeer = Tipo.REFEER;
		tipoRefeer.setConsumo(200d);
		container.setTipo(tipoRefeer);
		assertEquals(container.getConsumoKwHr(), 200d);
	}
}
