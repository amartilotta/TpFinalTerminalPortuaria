package tpFinalTerminalPortuaria.terminal;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.Viaje.Viaje;

import java.util.*;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;
import tpFinalTerminalPortuaria.Filtros.IFiltroDeBusqueda;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.ICriterio.MenorCantidadTerminalesOrigenDestino;
import tpFinalTerminalPortuaria.Orden.OrdenExportacion;
import tpFinalTerminalPortuaria.Orden.OrdenImportacion;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Persona.Consignee;



public class TerminalGestionada extends Terminal {
	
    private ICriterio estrategiaCircuito;
    private List<EmpresaTransportista> empresasTransportistas =  new ArrayList<EmpresaTransportista>();
    private List<OrdenImportacion> ordenesImportacion = new ArrayList<OrdenImportacion>();
    private List<OrdenExportacion> ordenesExportacion = new ArrayList<OrdenExportacion>();
    private List<Shipper> shippers = new ArrayList<Shipper>();
    private List<Consignee> consignees = new ArrayList<Consignee>();
    private IMailer mailer;
    
	//Constructor principal
	public TerminalGestionada(Ubicacion ubicacion) {
	    super(ubicacion);
	    this.estrategiaCircuito = new MenorCantidadTerminalesOrigenDestino();
	    this.mailer = new MailerConcreto();
	}

	public TerminalGestionada(Ubicacion ubicacion, ICriterio estrategia) {
	    this(ubicacion);
	    this.estrategiaCircuito = estrategia;
	}

	public void setEstrategiaCircuito(ICriterio estrategia) {
        this.estrategiaCircuito = estrategia;
    }
	
	public ICriterio getEstrategiaCircuito() {
        return this.estrategiaCircuito;
    }
	
	public CircuitoMaritimo calcularMejorCircuito(Terminal terminalDestino) {
		List<CircuitoMaritimo> circuitosDisponibles = this.obtenerCircuitosHaciaDestino(terminalDestino); //Metodo de la clase abstracta
        return estrategiaCircuito.calcularMejorCircuito(circuitosDisponibles);
    }
	
	public void agregarEmpresaTrasnportista(EmpresaTransportista empresa) {
		this.empresasTransportistas.add(empresa);
	}
	
	public void registrarOrdenExportacion(OrdenExportacion orden) {
		this.ordenesExportacion.add(orden);
	}
	
	public void registrarOrdenImportacion(OrdenImportacion orden) {
		this.ordenesImportacion.add(orden);
	}
	
	public void registrarShipper(Shipper shipper){
		this.shippers.add(shipper);
	}
	public void registrarConsignee(Consignee consignee){
		this.consignees.add(consignee);
	}

	public List<EmpresaTransportista> getEmpresasTransportistas() {
		return this.empresasTransportistas;
	}

	public List<OrdenExportacion> getOrdenesExportacion() {
		return this.ordenesExportacion;
	}
	
	public List<OrdenImportacion> getOrdenesImportacion() {
		return this.ordenesImportacion;
	}

	public List<Shipper> getShippers() {
		return this.shippers;
	}

	public List<Consignee> getConsignees() {
		return this.consignees;
	}

	public void procesarOrdenImportacionDeBuque(String nombreBuque) {
		List<OrdenImportacion> ordenesFiltradas = this.getOrdenesImportacion()
                .stream()
                .filter(orden -> orden.getNombreBuque().equals(nombreBuque))
                .collect(Collectors.toList());
		for (OrdenImportacion orden : ordenesFiltradas) {
			String emailConsignee = orden.getEmailCliente();
			this.mailer.enviarMail(emailConsignee, "Buque ingresando");
		}
		
	}
	
	public void procesarOrdenExportacionDeBuque(String nombreBuque) {
		List<OrdenImportacion> ordenesFiltradas = this.getOrdenesImportacion()
                .stream()
                .filter(orden -> orden.getNombreBuque().equals(nombreBuque))
                .collect(Collectors.toList());
		for (OrdenImportacion orden : ordenesFiltradas) {
			String emailConsignee = orden.getEmailCliente();
			this.mailer.enviarMail(emailConsignee, "Buque partiendo");
		}
	}
	
	public List<Viaje> obtenerTodosLosViajes(){
		List<Viaje> todosLosViajes = getLineasNavieras()
                .stream()
                .flatMap(lineaNaviera -> lineaNaviera.getViajes().stream())
                .collect(Collectors.toList());

        return todosLosViajes;
	}
	
	public List<Viaje> filtrar(IFiltroDeBusqueda filtro){
		return filtro.filtrar(this.obtenerTodosLosViajes());
	}
	


}
