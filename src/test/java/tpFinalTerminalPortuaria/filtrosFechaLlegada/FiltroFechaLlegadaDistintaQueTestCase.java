package tpFinalTerminalPortuaria.filtrosFechaLlegada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Filtros.FiltroFechaLlegadaDistintaQue;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;


public class FiltroFechaLlegadaDistintaQueTestCase {
    private LocalDate fecha1;
    private LocalDate fecha2;
    private LocalDate fecha3;
    private FiltroFechaLlegadaDistintaQue filtro;
    private Viaje viajeA;
    private Viaje viajeB;
    private List<Viaje> viajes;
    private Terminal terminal;

    @Before
    public void SetUp() {
        fecha1 = LocalDate.of(2015, 10, 4);
        fecha2 = LocalDate.of(2015, 10, 4);
        fecha3     = LocalDate.of(1977, 7, 15);
        terminal = mock(Terminal.class);
        filtro = new FiltroFechaLlegadaDistintaQue(fecha1, terminal);
        viajeA = mock(Viaje.class);
        viajeB = mock(Viaje.class);
        viajes = new ArrayList<Viaje>();
    }

    @Test
    public void cuandoSeCreaUnFiltroFechaLlegadaDistintaQue_EsteTieneUnaFechaYTerminal() {
        assertEquals(terminal, filtro.getTerminal());
        assertEquals(fecha1, filtro.getFecha());
    }


    @Test
    public void cuandoAUnFiltroFechaLlegadaDistintaQue_LePidoFiltrarUnaListaDeViajesVacia_EntoncesDevuelveUnaListaVacía() {
        assertEquals(0, filtro.filtrar(viajes).size());
    }


    @Test
    public void verificoQueUnViajeTieneUnaFechaDistintaALaDelFiltro() {
        when(viajeA.fechaAsignadaA(terminal)).thenReturn(fecha2);
        assertTrue(filtro.fechaEsDistintaALaDelFiltro(viajeA.fechaAsignadaA(terminal)));
    } 
//METODOS DE FILTRADO::

    @Test
    public void cuandoAlFiltroLePidoFiltrarUnaListaConViajesQueNoTienenALaTerminalDadaComoDestino_EntoncesDevuelveUnaListaVacia() {
        when(viajeA.tieneTerminal(terminal)).thenReturn(false);
        when(viajeB.tieneTerminal(terminal)).thenReturn(false);
        when(viajeA.fechaAsignadaA(terminal)).thenReturn(fecha1);
        when(viajeB.fechaAsignadaA(terminal)).thenReturn(fecha1);
        viajes.add(viajeA);
        viajes.add(viajeB);
        List<Viaje> filtrados = filtro.filtrar(viajes);
        assertEquals(filtrados.size(), 0);
    }

    @Test
    public void cuandoAlFiltroLePidoFiltrarUnaListaConViajesQueTienenALaTerminalDadaPeroUnaFechaIgualALaDelFiltro_EntoncesDevuelveUnaListaVacia() {
        when(viajeA.tieneTerminal(terminal)).thenReturn(true);
        when(viajeB.tieneTerminal(terminal)).thenReturn(true);
        when(viajeA.fechaAsignadaA(terminal)).thenReturn(fecha1);
        when(viajeB.fechaAsignadaA(terminal)).thenReturn(fecha1);
        viajes.add(viajeA);
        viajes.add(viajeB);
        List<Viaje> filtrados = filtro.filtrar(viajes);
        assertEquals(filtrados.size(), 0);
    }

    @Test
    public void cuandoAlFiltroLePidoFiltrarUnaListaConViajesQueTienenALaTerminalDada_YUnViajeTieneFechaDistintaDeLlegada_EntoncesDevuelveUnaListaConUnViaje() {
        when(viajeA.tieneTerminal(terminal)).thenReturn(true);
        when(viajeB.tieneTerminal(terminal)).thenReturn(true);
        when(viajeA.fechaAsignadaA(terminal)).thenReturn(fecha2);
        when(viajeB.fechaAsignadaA(terminal)).thenReturn(fecha1);
        viajes.add(viajeA);
        viajes.add(viajeB);
        List<Viaje> filtrados = filtro.filtrar(viajes);
        assertEquals(filtrados.size(), 1);
    }

}

