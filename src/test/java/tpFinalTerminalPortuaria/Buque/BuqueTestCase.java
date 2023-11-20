package tpFinalTerminalPortuaria.Buque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuqueTestCase {
	private Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		buque = new Buque("BUQUE");
	}

	@Test
	void verificoQueElBuqueRecienCreadoTieneUnNombreAsignado() {
		assertEquals(buque.getNombre(), "BUQUE");
	}
	
	@Test
	void verificoQueElBuqueRecienCreadoTieneUnaFaseAsignada() {
		assertTrue(buque.getFase() != null);
	}

}
