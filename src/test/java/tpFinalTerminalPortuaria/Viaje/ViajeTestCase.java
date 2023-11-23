package tpFinalTerminalPortuaria.Viaje;

import static org.junit.Assert.*;

import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Tramo.Tramo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.TreeSet;

import org.junit.Before;


public class ViajeTestCase {

    private LocalDate fechaSalida;
    private Buque buque;
    private CircuitoMaritimo circuito;
    private  Tramo tramo1;
    private  Tramo tramo2;

    @Before
    public void setUp() {
        fechaSalida = LocalDate.now();
        buque = mock(Buque.class);
        circuito = mock(CircuitoMaritimo.class);
        tramo1 = mock(Tramo.class);
        tramo2 = mock(Tramo.class);
        
    }

    @Test
    public void testGetPrecioDelViaje() {
        Viaje viaje = new Viaje(fechaSalida, circuito, buque);
        when(circuito.calcularPrecioTotal()).thenReturn((long) 1000);


        // Comprueba que el precio del viaje coincide con el valor esperado
        assertEquals((long) 1000, viaje.costoCircuito(), 0.001);
    }

    @Test
    public void testGetFechaSalida() {
        Viaje viaje = new Viaje(fechaSalida, circuito, buque);

        // Comprueba que la fecha de salida coincide con el valor esperado
        assertEquals(fechaSalida, viaje.getFechaSalida());
    }

    @Test
    public void testGetBuque() {
        Viaje viaje = new Viaje(fechaSalida, circuito, buque);

        // Comprueba que el buque coincide con el valor esperado
        assertEquals(buque, viaje.getBuque());
    }

    @Test
    public void testGetCircuito() {
        Viaje viaje = new Viaje(fechaSalida, circuito, buque);

        // Comprueba que el circuito coincide con el valor esperado
        assertEquals(circuito, viaje.getCircuito());
    }

    @Test
    public void testGetCronograma() {
        Viaje viaje = new Viaje(fechaSalida, circuito, buque);

        // Comprueba que el cronograma no es nulo
        assertEquals(true, viaje.getCronograma() != null);
    }

}