package tpFinalTerminalPortuaria.Terminal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.Orden.Orden;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.Terminal;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class TerminalGestionadaTestCase {

	private TerminalGestionada terminalGestionada;
    private Ubicacion ubicacion;
    private ICriterio estrategiaMock;

    @Before
    public void setUp() {
        ubicacion = mock(Ubicacion.class);
        estrategiaMock = mock(ICriterio.class);
        terminalGestionada = new TerminalGestionada(ubicacion, estrategiaMock);
    }

    @Test
    public void testCalcularMejorCircuito() {
        // Crear instancias necesarias para el test
        Terminal terminalDestino = mock(Terminal.class);
        CircuitoMaritimo circuitoMaritimo = mock(CircuitoMaritimo.class);
        List<CircuitoMaritimo> circuitosDisponibles = Arrays.asList(circuitoMaritimo);


        when(estrategiaMock.calcularMejorCircuito(terminalGestionada.obtenerCircuitosHaciaDestino(terminalDestino))).thenReturn(circuitoMaritimo);
        when(circuitoMaritimo.contieneTerminal(terminalDestino)).thenReturn(true);
        

        assertEquals(circuitoMaritimo, terminalGestionada.calcularMejorCircuito(terminalDestino));
    }

    @Test
    public void testAgregarEmpresaTrasnportista() {

        EmpresaTransportista empresaTransportista = mock(EmpresaTransportista.class);


        terminalGestionada.agregarEmpresaTrasnportista(empresaTransportista);


        assertTrue(terminalGestionada.getEmpresasTransportistas().contains(empresaTransportista));
    }

//    @Test
//    public void testRegistrarOrden() {
//
//        Orden orden = mock(Orden.class);
//
//
//        terminalGestionada.registrarOrden(orden);
//
//
//        assertTrue(terminalGestionada.getOrdenes().contains(orden));
//    }

    @Test
    public void testRegistrarShipper() {

        Shipper shipper = mock(Shipper.class);


        terminalGestionada.registrarShipper(shipper);


        assertTrue(terminalGestionada.getShippers().contains(shipper));
    }

    @Test
    public void testRegistrarConsignee() {

        Consignee consignee = mock(Consignee.class);


        terminalGestionada.registrarConsignee(consignee);


        assertTrue(terminalGestionada.getConsignees().contains(consignee));
    }
    
    @Test
    public void testSetEstrategia() {

    	ICriterio otroCriterio = mock(ICriterio.class);

 
        terminalGestionada.setEstrategiaCircuito(otroCriterio);


        assertEquals(terminalGestionada.getEstrategiaCircuito(), otroCriterio);
    }

}
