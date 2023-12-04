package tpFinalTerminalPortuaria.Terminal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
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
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.LineaNaviera.LineaNaviera;

public class TerminalGestionadaTestCase {

	private TerminalGestionada terminalGestionada;
    private Ubicacion ubicacion;
    private ICriterio estrategiaMock;
    private Camion camion;
    private Chofer chofer;
    private Shipper shipper;
    private EmpresaTransportista empresaTransportista;
    private Viaje viaje;
    private Container container;
    private LineaNaviera naviera;
    private Consignee consignee;

    @Before
    public void setUp() {
        ubicacion = mock(Ubicacion.class);
        estrategiaMock = mock(ICriterio.class);
        terminalGestionada = new TerminalGestionada(ubicacion, estrategiaMock);
        camion = mock(Camion.class);
        chofer = mock(Chofer.class);
        shipper = mock(Shipper.class);
        consignee = mock(Consignee.class);
        empresaTransportista = mock(EmpresaTransportista.class);
        viaje = mock(Viaje.class);
        container = mock(Container.class);
        naviera = mock(LineaNaviera.class);
        terminalGestionada.agregarLineaNaviera(naviera);
        terminalGestionada.agregarEmpresaTrasnportista(empresaTransportista);
    }

    @Test
    public void testCalcularMejorCircuito() {
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

        String nombreBuque = "Buque123";


        OrdenExportacion ordenExportacion = mock(OrdenExportacion.class);
        when(ordenExportacion.getNombreBuque()).thenReturn(nombreBuque);


        terminalGestionada.registrarOrdenExportacion(ordenExportacion);


        terminalGestionada.procesarOrdenExportacionDeBuque(nombreBuque);

    }

    @Test
    public void testProcesarOrdenImportacionDeBuque() {

        String nombreBuque = "Buque456";

        OrdenImportacion ordenImportacion = mock(OrdenImportacion.class);
        when(ordenImportacion.getNombreBuque()).thenReturn(nombreBuque);

        terminalGestionada.registrarOrdenImportacion(ordenImportacion);


        terminalGestionada.procesarOrdenImportacionDeBuque(nombreBuque);


    }

    @Test
    public void testGetOrdenesImportacion() {

        OrdenImportacion ordenImportacion = mock(OrdenImportacion.class);


        terminalGestionada.registrarOrdenImportacion(ordenImportacion);

        List<OrdenImportacion> ordenesImportacion = terminalGestionada.getOrdenesImportacion();

        assertNotNull(ordenesImportacion);

    }

    @Test
    public void testGetOrdenesExportacion() {

        OrdenExportacion ordenExportacion = mock(OrdenExportacion.class);


        terminalGestionada.registrarOrdenExportacion(ordenExportacion);


        List<OrdenExportacion> ordenesExportacion = terminalGestionada.getOrdenesExportacion();

        assertNotNull(ordenesExportacion);

    }
    
    @Test
    public void testFiltrar() {

        IFiltroDeBusqueda filtro = mock(IFiltroDeBusqueda.class);
        List<Viaje> todosLosViajes = Arrays.asList(mock(Viaje.class), mock(Viaje.class), mock(Viaje.class));

  
        when(filtro.filtrar(todosLosViajes)).thenReturn(Arrays.asList(todosLosViajes.get(0), todosLosViajes.get(2)));

  
        List<Viaje> viajesFiltrados = terminalGestionada.filtrar(filtro);

   
        assertEquals(0, viajesFiltrados.size());
        
    }
    
    @Test
    public void testEnviarMail() {
   
        IMailer mailer = new MailerConcreto();

   
        String destinatario = "destinatario@example.com";
        String mensaje = "Este es un mensaje de prueba.";

 
        mailer.enviarMail(destinatario, mensaje);

 
        assertTrue(true);
    }
    
    @Test
    public void testGenerarOrdenImportacion() {
    	List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);
        terminalGestionada.registrarConsignee(consignee);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(true);

        terminalGestionada.generarOrdenImportacion(consignee, camion, chofer, servicios, viaje, container);
    }
    

    @Test
    public void testGenerarOrdenImportacionFallido() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(false);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(false);
        terminalGestionada.registrarConsignee(consignee);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenImportacion(consignee, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testGenerarOrdenImportacionFallido2() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(false);
        terminalGestionada.registrarConsignee(consignee);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenImportacion(consignee, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testGenerarOrdenImportacionFallido3() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);
        
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenImportacion(consignee, camion, chofer, servicios, viaje, container);
    }
    
    @Test
    public void testGenerarOrdenImportacionFallido4() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);
        terminalGestionada.registrarConsignee(consignee);
        // No existe Viaje de Lineas Navieras
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenImportacion(consignee, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testEsChoferAutorizado() {
        terminalGestionada.agregarEmpresaTrasnportista(empresaTransportista);

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);

        boolean autorizado = terminalGestionada.esChoferAutorizado(chofer);

        assertTrue(autorizado);
    }

    @Test
    public void testEsCamionAutorizado() {
        terminalGestionada.agregarEmpresaTrasnportista(empresaTransportista);

        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);

        boolean autorizado = terminalGestionada.esCamionAutorizado(camion);

        assertTrue(autorizado);
    }

    @Test
    public void testEsClienteConsignee() {
        Consignee consignee = mock(Consignee.class);

        terminalGestionada.registrarConsignee(consignee);

        boolean esCliente = terminalGestionada.esClienteConsignee(consignee);

        assertTrue(esCliente);
    }

    @Test
    public void testExisteViajeDeLineasNavieras() {
        terminalGestionada.registrarOrdenImportacion(mock(OrdenImportacion.class));

        when(naviera.existeViaje(viaje)).thenReturn(true);

        boolean existeViaje = terminalGestionada.existeViajeDeLineasNavieras(viaje);

        assertTrue(existeViaje);
    }

    @Test
    public void testEsClienteShipper() {
        terminalGestionada.registrarShipper(shipper);

        boolean esCliente = terminalGestionada.esClienteShipper(shipper);

        assertTrue(esCliente);
    }

    @Test
    public void testGenerarOrdenExportacion() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);
        terminalGestionada.registrarShipper(shipper);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(true);

        terminalGestionada.generarOrdenExportacion(shipper, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testGenerarOrdenExportacionFallido() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(false);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(false);
        terminalGestionada.registrarShipper(shipper);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenExportacion(shipper, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testGenerarOrdenExportacionFallido2() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(false);
        terminalGestionada.registrarShipper(shipper);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenExportacion(shipper, camion, chofer, servicios, viaje, container);
    }

    @Test
    public void testGenerarOrdenExportacionFallido3() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);

        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenExportacion(shipper, camion, chofer, servicios, viaje, container);
    }
    
    @Test
    public void testGenerarOrdenExportacionFallido4() {
        List<Servicio> servicios = Arrays.asList(mock(Servicio.class));

        when(empresaTransportista.esChoferAutorizado(chofer)).thenReturn(true);
        when(empresaTransportista.esCamionAutorizado(camion)).thenReturn(true);
        terminalGestionada.registrarShipper(shipper);
        when(terminalGestionada.existeViajeDeLineasNavieras(viaje)).thenReturn(false);

        terminalGestionada.generarOrdenExportacion(shipper, camion, chofer, servicios, viaje, container);
    }
    
    

}
