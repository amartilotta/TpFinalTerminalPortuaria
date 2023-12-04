package tpFinalTerminalPortuaria.Viaje;

import static org.junit.Assert.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.Before;


public class ViajeTestCase {

    private LocalDate fechaSalida;
    private Buque buque;
    private CircuitoMaritimo circuito;
    private  Tramo tramo1;
    private  Tramo tramo2;
    private  Tramo tramo3;
    private  Tramo tramo4;
    private  Tramo tramo5;
    private Viaje viaje;
    private Terminal terminal;
    private Terminal terminal1;
    private Terminal terminal2;
    private TerminalGestionada terminalGestionada;
    private TerminalGestionada terminalGestionada2;


    @Before
    public void setUp() {
        fechaSalida = LocalDate.of(2023, 12, 1);
        buque = mock(Buque.class);
        //circuito = mock(CircuitoMaritimo.class);
        tramo1 = mock(Tramo.class);
        tramo2 = mock(Tramo.class);
        tramo3 = mock(Tramo.class);
        tramo4 = mock(Tramo.class);
        tramo5 = mock(Tramo.class);
        terminal = mock(Terminal.class);
        terminal1 = mock(Terminal.class);
        terminal2 = mock(Terminal.class);
        terminalGestionada = mock(TerminalGestionada.class);
        terminalGestionada2 = mock(TerminalGestionada.class);
        
        //when(circuito.calcularPrecioTotal()).thenReturn((long) 1000);
        when(tramo1.getTerminalOrigen()).thenReturn(terminal);
        when(tramo1.getPrecio()).thenReturn(500);
        when(tramo1.getDuracionEnDias()).thenReturn(3);
        when(tramo1.getTerminalDestino()).thenReturn(terminal1);
        when(tramo2.getTerminalOrigen()).thenReturn(terminal1);
        when(tramo2.getDuracionEnDias()).thenReturn(2);
        when(tramo2.getPrecio()).thenReturn(500);
        
        when(tramo3.getTerminalOrigen()).thenReturn(terminalGestionada);
        when(tramo3.getTerminalDestino()).thenReturn(terminal);
        when(tramo3.getDuracionEnDias()).thenReturn(10);
        
        when(tramo4.getTerminalOrigen()).thenReturn(terminalGestionada2);
        when(tramo4.getTerminalDestino()).thenReturn(terminal1);
        when(tramo4.getDuracionEnDias()).thenReturn(20);
        
        when(tramo5.getTerminalOrigen()).thenReturn(terminal1);
        when(tramo5.getTerminalDestino()).thenReturn(terminal);
        when(tramo5.getDuracionEnDias()).thenReturn(20);
        
        
        
        TreeSet<Tramo> tramosDelCircuito = new TreeSet<>();
        tramosDelCircuito.add(tramo1);
        tramosDelCircuito.add(tramo2);
        tramosDelCircuito.add(tramo3);
        tramosDelCircuito.add(tramo4);
        tramosDelCircuito.add(tramo5);
        
        circuito = new CircuitoMaritimo(tramosDelCircuito);
        viaje = new Viaje(fechaSalida, circuito, buque);
        
    }


	@Test
    public void testGetPrecioDelViaje() {

        assertEquals(1000, viaje.getPrecioDelViaje(), 0.001);

    }

    @Test
    public void testGetFechaSalida() {
    	
        assertEquals(fechaSalida, viaje.getFechaSalida());
    }

    @Test
    public void testGetBuque() {
   
        assertEquals(buque, viaje.getBuque());
    }

    @Test
    public void testGetCircuito() {


        assertEquals(circuito, viaje.getCircuito());
    }

    @Test
    public void testGetCronograma() {
    	
    	Map<Terminal, LocalDate> cronograma = viaje.getCronograma();

        assertTrue(viaje.getCronograma() != null);
    }
    
    @Test 
    public void tieneTerminalEsTrue() {
    	assertTrue(viaje.tieneTerminal(terminal));
    }
    
//    @Test
//    public void testObtenerEntradaCronogramaNoExistente() {
//        // Cuando se llama a obtenerEntradaCronograma con una terminal que no está en el cronograma, debería devolver null
//        Map.Entry<Terminal, LocalDate> entradaCronograma = viaje.obtenerEntradaCronograma(mock(Terminal.class));
//
//        assertNull(entradaCronograma);
//    }
    
    @Test
    public void testObtenerFechaSalidaDeTerminal() {
        // Crear instancias necesarias para el test
        Terminal terminalExistente = mock(Terminal.class);
        Terminal terminalNoExistente = mock(Terminal.class);
        LocalDate fechaSalida = LocalDate.of(2023, 12, 1); // Cambia la fecha según tus necesidades

        viaje.getCronograma().put(terminalExistente, fechaSalida);

        // Verificar que la fecha de salida para un terminal existente sea la esperada
        assertEquals(fechaSalida, viaje.obtenerFechaSalidaDeTerminal(terminalExistente));

        // Verificar que la fecha de salida para un terminal no existente sea null
        assertNull(viaje.obtenerFechaSalidaDeTerminal(terminalNoExistente));
    }
    
    @Test
    public void testCalcularFechaProxima() {

        LocalDate fechaActual = LocalDate.of(2023, 12, 10); // Cambia la fecha según tus necesidades

        // Verificar que la fecha próxima sea la esperada
        LocalDate fechaProxima = viaje.calcularFechaProxima(terminalGestionada, terminal, fechaActual);
        assertEquals(LocalDate.of(2023, 12, 11), fechaProxima); // La fecha de salida más 5 días del tramo
    }
    
    @Test
    public void testCalcularFechaProximaSegundoCaso() {

        LocalDate fechaActual = LocalDate.of(2023, 12, 10); // Cambia la fecha según tus necesidades

        // Verificar que la fecha próxima sea la esperada
        LocalDate fechaProxima = viaje.calcularFechaProxima(terminalGestionada2, terminal, fechaActual);
        assertEquals(LocalDate.of(2024, 01, 30), fechaProxima); // La fecha de salida más 5 días del tramo
    }
    
    @Test
    public void testCalcularFechaProximaTercerCaso() {

        LocalDate fechaActual = LocalDate.of(2023, 12, 10); // Cambia la fecha según tus necesidades

        // Verificar que la fecha próxima sea la esperada
        LocalDate fechaProxima = viaje.calcularFechaProxima(terminalGestionada2, terminal2, fechaActual);
        assertNull(fechaProxima); // La fecha de salida más 5 días del tramo
    
    }
//    @Test
//    public void testObtenerEntradaCronogramaExistente() {
//        // Cuando se llama a obtenerEntradaCronograma con terminal1, debería devolver la entrada correspondiente
//        Map.Entry<Terminal, LocalDate> entradaCronograma = viaje.obtenerEntradaCronograma(terminal);
//
//        assertNotNull(entradaCronograma);
//        assertEquals(terminal, entradaCronograma.getKey());
//        //assertEquals(LocalDate.of(2023, 1, 1), entradaCronograma.getValue());
//    }

}