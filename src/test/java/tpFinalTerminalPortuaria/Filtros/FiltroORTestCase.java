package tpFinalTerminalPortuaria.Filtros;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Viaje.Viaje;

import java.util.Arrays;
import java.util.List;

public class FiltroORTestCase {

    private FiltroOR filtroOR;
    private IFiltroDeBusqueda filtroA;
    private IFiltroDeBusqueda filtroB;

    @Before
    public void setUp() {
        filtroA = mock(IFiltroDeBusqueda.class);
        filtroB = mock(IFiltroDeBusqueda.class);

        filtroOR = new FiltroOR(filtroA, filtroB);
    }

    @Test
    public void testFiltrar() {
        Viaje viaje1 = mock(Viaje.class);
        Viaje viaje2 = mock(Viaje.class);
        Viaje viaje3 = mock(Viaje.class);

        List<Viaje> todosLosViajes = Arrays.asList(viaje1, viaje2, viaje3);

        when(filtroA.filtrar(todosLosViajes)).thenReturn(Arrays.asList(viaje1, viaje3));
        when(filtroB.filtrar(todosLosViajes)).thenReturn(Arrays.asList(viaje2, viaje3));

        List<Viaje> viajesFiltrados = filtroOR.filtrar(todosLosViajes);

        assertEquals(3, viajesFiltrados.size());
        assertTrue(viajesFiltrados.contains(viaje1));
        assertTrue(viajesFiltrados.contains(viaje2));
        assertTrue(viajesFiltrados.contains(viaje3));
    }

}
