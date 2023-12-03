package tpFinalTerminalPortuaria.terminal;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;

import java.util.*;

import org.mockito.ArgumentMatchers;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.ICriterio.MenorCantidadTerminalesOrigenDestino;
import tpFinalTerminalPortuaria.Orden.Orden;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Persona.Consignee;



public class TerminalGestionada extends Terminal {
	
    private ICriterio estrategiaCircuito;
    private List<EmpresaTransportista> empresasTransportistas =  new ArrayList<EmpresaTransportista>();
    private List<Orden> ordenes = new ArrayList<Orden>();
    private List<Shipper> shippers = new ArrayList<Shipper>();
    private List<Consignee> consignees = new ArrayList<Consignee>();
    
	//Constructor principal
	public TerminalGestionada(Ubicacion ubicacion) {
	    super(ubicacion);
	    this.estrategiaCircuito = new MenorCantidadTerminalesOrigenDestino();
	}

	public TerminalGestionada(Ubicacion ubicacion, ICriterio estrategia) {
	    this(ubicacion);
	    this.estrategiaCircuito = estrategia;
	}

	public void setEstrategiaCircuito(ICriterio estrategia) {
        this.estrategiaCircuito = estrategia;
    }
	
	public CircuitoMaritimo calcularMejorCircuito(Terminal terminalDestino) {
		List<CircuitoMaritimo> circuitosDisponibles = this.obtenerCircuitosHaciaDestino(terminalDestino); //Metodo de la clase abstracta
        return estrategiaCircuito.calcularMejorCircuito(circuitosDisponibles);
    }
	
	public void agregarEmpresaTrasnportista(EmpresaTransportista empresa) {
		this.empresasTransportistas.add(empresa);
	}
	
	public void registrarOrden(Orden orden) {
		this.ordenes.add(orden);
	}
	
	public void registrarShipper(Shipper shipper){
		this.shippers.add(shipper);
	}
	public void registrarConsignee(Consignee consignee){
		this.consignees.add(consignee);
	}
//	public void registrarCamiones(){
//		
//	}
//	
//	public void procesarOrdenSegunBuque(Buque buque) {
//		
//	}

	public List<EmpresaTransportista> getEmpresasTransportistas() {
		return this.empresasTransportistas;
	}

	public List<Orden> getOrdenes() {
		return this.ordenes;
	}

	public List<Shipper> getShippers() {
		return this.shippers;
	}

	public List<Consignee> getConsignees() {
		return this.consignees;
	}

	public void procesarOrdenSegunBuque(Buque buque) {
		
	}
	
	


}
