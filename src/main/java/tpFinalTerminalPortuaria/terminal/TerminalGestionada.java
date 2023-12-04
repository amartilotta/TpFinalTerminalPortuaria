package tpFinalTerminalPortuaria.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;
import tpFinalTerminalPortuaria.Filtros.IFiltroDeBusqueda;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.ICriterio.MenorCantidadTerminalesOrigenDestino;
import tpFinalTerminalPortuaria.Orden.OrdenExportacion;
import tpFinalTerminalPortuaria.Orden.OrdenImportacion;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.Viaje.Viaje;



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
		List<OrdenExportacion> ordenesFiltradas = this.getOrdenesExportacion()
                .stream()
                .filter(orden -> orden.getNombreBuque().equals(nombreBuque))
                .collect(Collectors.toList());
		for (OrdenExportacion orden : ordenesFiltradas) {
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
	
	public void generarOrdenImportacion(Consignee consignee, Camion camion, Chofer chofer, List<Servicio> servicios, Viaje viaje, Container container ){
        if(this.esChoferAutorizado(chofer) && this.esCamionAutorizado(camion) &&
            this.esClienteConsignee(consignee) && this.existeViajeDeLineasNavieras(viaje)){

            OrdenImportacion orden = new OrdenImportacion(viaje, container, chofer, camion, servicios, consignee);
            this.registrarOrdenImportacion(orden);

        }
    }

    public Boolean esChoferAutorizado(Chofer chofer) {
        return this.getEmpresasTransportistas().stream().anyMatch(
                empresa -> empresa.esChoferAutorizado(chofer));
    }

    public Boolean esCamionAutorizado(Camion camion) {
        return this.getEmpresasTransportistas().stream().anyMatch(
                empresa -> empresa.esCamionAutorizado(camion));
    }

    public Boolean esClienteConsignee(Consignee consignee) {
        return this.getConsignees().contains(consignee);
    }

    public Boolean existeViajeDeLineasNavieras(Viaje viaje) {
        return this.getLineasNavieras().stream().anyMatch(
                lineaNaviera -> lineaNaviera.existeViaje(viaje));
    } 
    public Boolean esClienteShipper(Shipper shipper) {
        return this.getShippers().contains(shipper);
    }
    
    public void generarOrdenExportacion(Shipper shipper, Camion camion, Chofer chofer, List<Servicio> servicios, Viaje viaje, Container container ){
        if(this.esChoferAutorizado(chofer) && this.esCamionAutorizado(camion) &&
            this.esClienteShipper(shipper) && this.existeViajeDeLineasNavieras(viaje)){

            OrdenExportacion orden = new OrdenExportacion(viaje, container, chofer, camion, servicios, shipper);
            this.registrarOrdenExportacion(orden);

        }
    }
	


}
