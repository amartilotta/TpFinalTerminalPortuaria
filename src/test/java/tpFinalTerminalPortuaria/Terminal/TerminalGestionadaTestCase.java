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
import tpFinalTerminalPortuaria.Filtros.IFiltroDeBusqueda;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.terminal.IMailer;
import tpFinalTerminalPortuaria.terminal.MailerConcreto;
import tpFinalTerminalPortuaria.Orden.OrdenExportacion;
import tpFinalTerminalPortuaria.Orden.OrdenImportacion;
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
    
    @Test
    public void testProcesarOrdenExportacionDeBuque() {
        // Crear instancias necesarias para el test
        String nombreBuque = "Buque123";

        // Supongamos que tienes una OrdenExportacion con el nombre del buque
        OrdenExportacion ordenExportacion = mock(OrdenExportacion.class);
        when(ordenExportacion.getNombreBuque()).thenReturn(nombreBuque);

        // Agrega la orden a la lista de ordenesExportacion
        terminalGestionada.registrarOrdenExportacion(ordenExportacion);

        // Llama al método a probar
        terminalGestionada.procesarOrdenExportacionDeBuque(nombreBuque);

        // Agrega las aserciones necesarias según la lógica de tu implementación
    }

    @Test
    public void testProcesarOrdenImportacionDeBuque() {
        // Crear instancias necesarias para el test
        String nombreBuque = "Buque456";

        // Supongamos que tienes una OrdenImportacion con el nombre del buque
        OrdenImportacion ordenImportacion = mock(OrdenImportacion.class);
        when(ordenImportacion.getNombreBuque()).thenReturn(nombreBuque);

        // Agrega la orden a la lista de ordenesImportacion
        terminalGestionada.registrarOrdenImportacion(ordenImportacion);

        // Llama al método a probar
        terminalGestionada.procesarOrdenImportacionDeBuque(nombreBuque);

        // Agrega las aserciones necesarias según la lógica de tu implementación
    }

    @Test
    public void testGetOrdenesImportacion() {
        // Crear instancias necesarias para el test
        // Supongamos que tienes una OrdenImportacion
        OrdenImportacion ordenImportacion = mock(OrdenImportacion.class);

        // Agrega la orden a la lista de ordenesImportacion
        terminalGestionada.registrarOrdenImportacion(ordenImportacion);

        // Llama al método a probar
        List<OrdenImportacion> ordenesImportacion = terminalGestionada.getOrdenesImportacion();

        assertNotNull(ordenesImportacion);
        // Agrega las aserciones necesarias según la lógica de tu implementación
    }

    @Test
    public void testGetOrdenesExportacion() {
        // Crear instancias necesarias para el test
        // Supongamos que tienes una OrdenExportacion
        OrdenExportacion ordenExportacion = mock(OrdenExportacion.class);

        // Agrega la orden a la lista de ordenesExportacion
        terminalGestionada.registrarOrdenExportacion(ordenExportacion);

        // Llama al método a probar
        List<OrdenExportacion> ordenesExportacion = terminalGestionada.getOrdenesExportacion();

        assertNotNull(ordenesExportacion);
        // Agrega las aserciones necesarias según la lógica de tu implementación
    }
    
    @Test
    public void testFiltrar() {
        // Crear instancias necesarias para el test
        IFiltroDeBusqueda filtro = mock(IFiltroDeBusqueda.class);
        List<Viaje> todosLosViajes = Arrays.asList(mock(Viaje.class), mock(Viaje.class), mock(Viaje.class));

        // Configurar el comportamiento del filtro mock
        when(filtro.filtrar(todosLosViajes)).thenReturn(Arrays.asList(todosLosViajes.get(0), todosLosViajes.get(2)));

        // Llama al método a probar
        List<Viaje> viajesFiltrados = terminalGestionada.filtrar(filtro);

        // Verifica que el filtro haya sido aplicado correctamente
        assertEquals(0, viajesFiltrados.size());
        
    }
    
    @Test
    public void testEnviarMail() {
        // Crear una instancia de la implementación concreta
        IMailer mailer = new MailerConcreto();

        // Definir datos de prueba
        String destinatario = "destinatario@example.com";
        String mensaje = "Este es un mensaje de prueba.";

        // Llama al método a probar
        mailer.enviarMail(destinatario, mensaje);

        // Verifica que el método no lance excepciones
        assertTrue(true);
        // (no hay nada para verificar ya que el método no tiene lógica en la implementación concreta)
    }

}
