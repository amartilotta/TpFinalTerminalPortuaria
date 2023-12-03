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

        // Configurar el comportamiento esperado para el método de estrategiaMock
        when(estrategiaMock.calcularMejorCircuito(circuitosDisponibles)).thenReturn(circuitoMaritimo);

        // Verificar que el método calcularMejorCircuito devuelve el circuito esperado
        assertEquals(circuitoMaritimo, terminalGestionada.calcularMejorCircuito(terminalDestino));
    }

    @Test
    public void testAgregarEmpresaTrasnportista() {
        // Crear una instancia de EmpresaTransportista mock para el test
        EmpresaTransportista empresaTransportista = mock(EmpresaTransportista.class);

        // Agregar la empresa transportista a la terminal gestionada
        terminalGestionada.agregarEmpresaTrasnportista(empresaTransportista);

        // Verificar que la empresa transportista se agrega correctamente
        assertTrue(terminalGestionada.getEmpresasTransportistas().contains(empresaTransportista));
    }

    @Test
    public void testRegistrarOrden() {
        // Crear una instancia de Orden mock para el test
        Orden orden = mock(Orden.class);

        // Registrar la orden en la terminal gestionada
        terminalGestionada.registrarOrden(orden);

        // Verificar que la orden se registra correctamente
        assertTrue(terminalGestionada.getOrdenes().contains(orden));
    }

    @Test
    public void testRegistrarShipper() {
        // Crear una instancia de Shipper mock para el test
        Shipper shipper = mock(Shipper.class);

        // Registrar el shipper en la terminal gestionada
        terminalGestionada.registrarShipper(shipper);

        // Verificar que el shipper se registra correctamente
        assertTrue(terminalGestionada.getShippers().contains(shipper));
    }

    @Test
    public void testRegistrarConsignee() {
        // Crear una instancia de Consignee mock para el test
        Consignee consignee = mock(Consignee.class);

        // Registrar el consignee en la terminal gestionada
        terminalGestionada.registrarConsignee(consignee);

        // Verificar que el consignee se registra correctamente
        assertTrue(terminalGestionada.getConsignees().contains(consignee));
    }

}
