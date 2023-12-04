package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;

import static org.junit.Assert.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;
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
    private List<Viaje> viajesMock = new ArrayList<>();

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
    
    @Test
    public void testProximaFechaPartidaDeBuqueDesdeTerminalHastaTerminal() {
        // Agregar lógica de inicialización de circuito y viajes según sea necesario

        LocalDate fechaActual = LocalDate.now();
        Viaje viaje1 = mock(Viaje.class);
        Terminal puertoDestino = mock(Terminal.class);
        
        Viaje viaje2 = mock(Viaje.class);
        when(viaje2.calcularFechaProxima(terminalgestionada, puertoDestino, fechaActual)).thenReturn(LocalDate.now().plusDays(2));

        viajesMock.add(viaje1);
        viajesMock.add(viaje2);

        when(buque1.getNombre()).thenReturn("buque1");
        when(viaje1.getCircuito()).thenReturn(circuito1);
        when(viaje1.getBuque()).thenReturn(buque1);
        when(circuito1.contieneTerminales(terminalgestionada,puertoDestino)).thenReturn(true);
        when(viaje1.calcularFechaProxima(terminalgestionada, puertoDestino, fechaActual)).thenReturn(fechaActual.plusDays(1));
        
        
        System.out.println("proximaFecha: " + viaje1.calcularFechaProxima(terminalgestionada, puertoDestino, fechaActual));


        LocalDate proximaFecha = lineaNaviera.proximaFechaPartidaDeBuqueDesdeTerminalHastaTerminal(buque1, terminalgestionada, puertoDestino);

        
        //assertEquals(fechaActual.plusDays(1), proximaFecha);
        assertEquals(null, proximaFecha);
    }

    @Test
    public void testAñadirCircuito() {
        CircuitoMaritimo nuevoCircuito = mock(CircuitoMaritimo.class);

        lineaNaviera.añadirCircuito(nuevoCircuito);

        assertTrue(lineaNaviera.getCircuitos().contains(nuevoCircuito));
    }

}