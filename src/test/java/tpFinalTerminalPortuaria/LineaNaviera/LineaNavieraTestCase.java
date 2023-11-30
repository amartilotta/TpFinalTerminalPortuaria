package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

import static org.junit.Assert.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;


public class LineaNavieraTestCase {

    private LineaNaviera lineaNaviera;
    private List<Buque> buques = new ArrayList<>();
    private Buque buque1;
    private Buque buque2;
    private TerminalGestionada terminalgestionada;
    private CircuitoMaritimo circuito1;
    private List<Viaje> viajesMock;

    @Before
    public void setUp() {
    	buque1 = mock(Buque.class);
    	buque2 = mock(Buque.class);
    	terminalgestionada = mock(TerminalGestionada.class);
    	circuito1 = mock(CircuitoMaritimo.class);
    	buques.add(buque1);
    	buques.add(buque2);



        List<CircuitoMaritimo> circuitos = new ArrayList<>();
        // Agrega buques y circuitos según sea necesario
        // ...




        lineaNaviera = new LineaNaviera("MiLineaNaviera", buques, circuitos);
    }

    @Test
    public void testGetNombreEmpresa() {
        assertEquals("MiLineaNaviera", lineaNaviera.getNombreEmpresa());
    }

    @Test
    public void testGetBuques() {


        assertEquals(2, lineaNaviera.getBuques().size());
    }

    @Test
    public void testGetViajes() {

        assertEquals(0, lineaNaviera.getViajes().size());
    }

    @Test
    public void testGetCircuitos() {

        assertEquals(0, lineaNaviera.getCircuitos().size());
    }

    @Test
    public void testProximaFechaPartida() {

        assertEquals(null, lineaNaviera.proximaFechaPartidaDeBuqueEnTerminal(buque1, terminalgestionada));
    }

    @Test
    public void cantidadDeViajesEs1() {
    	lineaNaviera.crearViaje(buque1, circuito1, LocalDate.now());

        assertEquals(1, lineaNaviera.getViajes().size());
    }

    @Test
    public void filtrarViajes() {

        assertEquals(0, lineaNaviera.filtrarViajesPorBuque("buque1").size());
    }

}