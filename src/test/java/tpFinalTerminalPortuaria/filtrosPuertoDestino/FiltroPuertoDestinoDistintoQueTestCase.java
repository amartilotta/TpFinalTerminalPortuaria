package tpFinalTerminalPortuaria.filtrosPuertoDestino;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Filtros.FiltroPuertoDestinoDistintoQue;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class FiltroPuertoDestinoDistintoQueTestCase {
    private Viaje viajeA;
    private Viaje viajeB;
    private List<Viaje> viajes;
    private FiltroPuertoDestinoDistintoQue filtro;
    private Terminal terminalMock;

    @Before
    public void SetUp() {
        viajeA = mock(Viaje.class);
        viajeB = mock(Viaje.class);
        viajes = new ArrayList<Viaje>();
        terminalMock = mock(Terminal.class);
        filtro = new FiltroPuertoDestinoDistintoQue(terminalMock);
    }

    @Test
    public void cuandoCreoFiltroPuertoDestinoDistintoQue_EsteTieneUnaTerminal() {
        assertEquals(filtro.getDestino(), terminalMock);
    }

    @Test
    public void cuandoAUnFiltroPuertoDestinoDistintoQue_LePidoFiltrarUnaListaDeViajesVacia_EntoncesDevuelveUnaListaVacía() {
        assertTrue(filtro.filtrar(viajes).size() == 0);
    }


    @Test
    public void cuandoFiltroConViajesQueNoTienenPuertoDestinoDistintoQueElPuertoDelFiltro_EntoncesDevuelveListaVacia() {
        when(viajeA.tieneTerminal(terminalMock)).thenReturn(true);
        when(viajeB.tieneTerminal(terminalMock)).thenReturn(true);
        viajes.add(viajeA);
        viajes.add(viajeB);
        List<Viaje> filtrados = filtro.filtrar(viajes);
        assertTrue(filtrados.size() == 0);
    }

    @Test
    public void cuandoFiltroConViajesQueUnoTienenPuertoDestinoDiferenteQueElPuertoDelFiltro_EntoncesDevuelveListaConUnElemento() {
        when(viajeA.tieneTerminal(terminalMock)).thenReturn(true);
        when(viajeB.tieneTerminal(terminalMock)).thenReturn(false);
        viajes.add(viajeA);
        viajes.add(viajeB);
        List<Viaje> filtrados = filtro.filtrar(viajes);
        assertTrue(filtrados.size() == 1);
    }

}