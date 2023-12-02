package tpFinalTerminalPortuaria.Tramo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.terminal.Terminal;

public class TramoTestCase {

	private Tramo tramo;
	private Terminal terminal;
	private Terminal terminal1;
	private Tramo otroTramo;
	@Before
	public void setUp() {

		terminal = mock(Terminal.class);
		terminal1 = mock(Terminal.class);
		otroTramo = mock(Tramo.class);



		tramo = new Tramo(terminal, terminal1, 500,2);
	}



	@Test
	public void getTerminalOrigen() {
		assertEquals(terminal, tramo.getTerminalOrigen());
	}

	@Test
	public void getTerminalDestino() {
		assertEquals(terminal1, tramo.getTerminalDestino());
	}

	@Test
	public void getDuracionEnDias() {
		assertEquals(2, tramo.getDuracionEnDias());
	}

	@Test
	public void getPrecio() {
		assertEquals(500, tramo.getPrecio());
	}

	@Test
	public void compareTo() {
		when(otroTramo.getDuracionEnDias()).thenReturn(1);
		assertEquals(1, tramo.compareTo(otroTramo));
	}

}