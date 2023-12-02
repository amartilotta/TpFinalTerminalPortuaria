package tpFinalTerminalPortuaria.Viaje;

import static org.junit.Assert.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Tramo.Tramo;
import tpFinalTerminalPortuaria.terminal.Terminal;

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
    private Viaje viaje;
    private Terminal terminal;
    private Terminal terminal1;


    @Before
    public void setUp() {
        fechaSalida = LocalDate.now();
        buque = mock(Buque.class);
        //circuito = mock(CircuitoMaritimo.class);
        tramo1 = mock(Tramo.class);
        tramo2 = mock(Tramo.class);
        terminal = mock(Terminal.class);
        terminal1 = mock(Terminal.class);
        
        //when(circuito.calcularPrecioTotal()).thenReturn((long) 1000);
        when(tramo1.getTerminalOrigen()).thenReturn(terminal);
        when(tramo1.getPrecio()).thenReturn(500);
        when(tramo1.getDuracionEnDias()).thenReturn(3);
        when(tramo2.getTerminalOrigen()).thenReturn(terminal1);
        when(tramo2.getDuracionEnDias()).thenReturn(2);
        when(tramo2.getPrecio()).thenReturn(500);
        
        TreeSet<Tramo> tramosDelCircuito = new TreeSet<>();
        tramosDelCircuito.add(tramo1);
        tramosDelCircuito.add(tramo2);
        
        circuito = new CircuitoMaritimo(tramosDelCircuito);
        viaje = new Viaje(fechaSalida, circuito, buque);
        
    }


	@Test
    public void testGetPrecioDelViaje() {

        assertEquals(1000, viaje.getPrecioDelViaje(), 0.001);

    }

    @Test
    public void testGetFechaSalida() {
    	System.out.println("Fecha de salida configurada en setUp: " + fechaSalida);
        System.out.println("Fecha de salida en el viaje: " + viaje.getFechaSalida());

        // Comprueba que la fecha de salida coincide con el valor esperado
        assertEquals(fechaSalida, viaje.getFechaSalida());
    }

    @Test
    public void testGetBuque() {
   
        // Comprueba que el buque coincide con el valor esperado
        assertEquals(buque, viaje.getBuque());
    }

    @Test
    public void testGetCircuito() {


        // Comprueba que el circuito coincide con el valor esperado
        assertEquals(circuito, viaje.getCircuito());
    }

    @Test
    public void testGetCronograma() {
    	
    	Map<Terminal, LocalDate> cronograma = viaje.getCronograma();

        // Imprime el contenido del cronograma
        System.out.println("Cronograma: " + cronograma);


        // Comprueba que el cronograma no es nulo
        assertTrue(viaje.getCronograma() != null);
    }
    
    @Test 
    public void tieneTerminalEsTrue() {
    	assertTrue(viaje.tieneTerminal(terminal));
    }
    
    @Test
    public void testObtenerEntradaCronogramaNoExistente() {
        // Cuando se llama a obtenerEntradaCronograma con una terminal que no está en el cronograma, debería devolver null
        Map.Entry<Terminal, LocalDate> entradaCronograma = viaje.obtenerEntradaCronograma(mock(Terminal.class));

        assertNull(entradaCronograma);
    }
    
    @Test
    public void testObtenerEntradaCronogramaExistente() {
        // Cuando se llama a obtenerEntradaCronograma con terminal1, debería devolver la entrada correspondiente
        Map.Entry<Terminal, LocalDate> entradaCronograma = viaje.obtenerEntradaCronograma(terminal);

        assertNotNull(entradaCronograma);
        assertEquals(terminal, entradaCronograma.getKey());
        //assertEquals(LocalDate.of(2023, 1, 1), entradaCronograma.getValue());
    }

}