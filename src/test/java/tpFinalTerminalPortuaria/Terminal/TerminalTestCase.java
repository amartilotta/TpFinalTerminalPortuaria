package tpFinalTerminalPortuaria.Terminal;

import static org.junit.Assert.*;

import org.junit.Test;


import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.LineaNaviera.LineaNaviera;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalConcreta;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Before;
public class TerminalTestCase {

	private Terminal terminal;
    private Ubicacion ubicacion;
    private LineaNaviera lineaNaviera;

    @Before
    public void setUp() {
        ubicacion = mock(Ubicacion.class);
        terminal = new TerminalConcreta(ubicacion);
    }

    @Test
    public void testObtenerCircuitosHaciaDestino() {

        Terminal terminalDestino = mock(Terminal.class);
        CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
        lineaNaviera = mock(LineaNaviera.class);
        
        when(lineaNaviera.getCircuitos()).thenReturn(Arrays.asList(circuito1, circuito2));

       

        terminal.agregarLineaNaviera(lineaNaviera);

        when(circuito1.contieneTerminal(terminal)).thenReturn(true);
        when(circuito1.contieneTerminal(terminalDestino)).thenReturn(true);
        when(circuito2.contieneTerminal(terminalDestino)).thenReturn(false);
        //when(circuito2.contieneTerminal(terminal)).thenReturn(true);

        List<CircuitoMaritimo> circuitosHaciaDestino = terminal.obtenerCircuitosHaciaDestino(terminalDestino);
        System.out.println("circuitosHaciaDestino: " + circuitosHaciaDestino);
        assertEquals(1, circuitosHaciaDestino.size());
        assertTrue(circuitosHaciaDestino.contains(circuito1));
        assertFalse(circuitosHaciaDestino.contains(circuito2));
    }

    @Test
    public void testAgregarLineaNaviera() {
        LineaNaviera lineaNaviera = mock(LineaNaviera.class);

        terminal.agregarLineaNaviera(lineaNaviera);

        assertTrue(terminal.obtenerLineasNavieras().contains(lineaNaviera));
    }
    
    @Test
    public void testgetUbicacion() {

        assertEquals(ubicacion, terminal.getUbicacion() );
    }


}


