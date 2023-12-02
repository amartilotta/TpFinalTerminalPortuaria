package tpFinalTerminalPortuaria.CircuitoMaritimo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.*;

import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;



public class CircuitoMaritimoTestCase {

	private CircuitoMaritimo circuito;
	private TreeSet<Tramo> tramosDelCircuito = new TreeSet<>();
	private Tramo tramo1;
	private Tramo tramo2;
	private Terminal terminal;
	private Terminal terminal1;
	private Terminal terminal2;

	@Before
	public void setUp() {

		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		terminal = mock(Terminal.class);
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);

		tramosDelCircuito.add(tramo1);
		tramosDelCircuito.add(tramo2);

		circuito = new CircuitoMaritimo(tramosDelCircuito);

	}

	@Test
	public void getTramos() {
		assertEquals(tramosDelCircuito, circuito.getTramos());
	}

	@Test
	public void getTerminales() {
		when(tramo1.getTerminalOrigen()).thenReturn(terminal);
        when(tramo2.getTerminalOrigen()).thenReturn(terminal1);
        List<Terminal> terminales = new ArrayList<>();
        terminales.add(terminal);
        terminales.add(terminal1);



		assertEquals(terminales, circuito.getTerminales());
	}

	@Test
	public void contieneTerminal() {
		when(tramo1.getTerminalOrigen()).thenReturn(terminal);


		assertTrue(circuito.contieneTerminal(terminal));
	}

	@Test
	public void contieneTerminalDestino() {
		when(tramo1.getTerminalOrigen()).thenReturn(terminal);
		when(tramo1.getTerminalDestino()).thenReturn(terminal1);
		when(tramo2.getTerminalOrigen()).thenReturn(terminal1);
		when(tramo2.getTerminalDestino()).thenReturn(terminal2);


		assertTrue(circuito.contieneTerminal(terminal2));
	}


	@Test
	public void getPuertoOrigenIsEmpy() {
		TreeSet<Tramo> tramosDelCircuito1 = new TreeSet<>();
		circuito = new CircuitoMaritimo(tramosDelCircuito1);
		assertEquals(null, circuito.getPuertoOrigen());
	}

	@Test 
	public void getPuertoOrigenIsTerminal() {

		when(tramo1.getTerminalOrigen()).thenReturn(terminal);
		assertEquals(terminal, circuito.getPuertoOrigen());
	}

	@Test 
	public void calcularTiempoTotalEs5() {

        when(tramo1.getDuracionEnDias()).thenReturn(3);
        when(tramo2.getDuracionEnDias()).thenReturn(2);


		assertEquals(5, circuito.calcularTiempoTotal());
	}

	@Test 
	public void calcularPrecioTotalEs1000() {

        when(tramo1.getPrecio()).thenReturn(500);
        when(tramo2.getPrecio()).thenReturn(500);



		assertEquals(1000, circuito.calcularPrecioTotal());
	}

}