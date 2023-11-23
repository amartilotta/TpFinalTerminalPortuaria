package tpFinalTerminalPortuaria.terminal;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;

import java.util.*;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;
import tpFinalTerminalPortuaria.ICriterio.ICriterio;
import tpFinalTerminalPortuaria.ICriterio.MenorCantidadTerminalesOrigenDestino;
import tpFinalTerminalPortuaria.Orden.Orden;



public class TerminalGestionada extends Terminal {
	
    private ICriterio estrategiaCircuito;
    private List<EmpresaTransportista> empresasTransportistas =  new ArrayList<EmpresaTransportista>();
    private List<Orden> ordenes = new ArrayList<Orden>();
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
        return estrategiaCircuito.calcularMejorCircuito(this, terminalDestino);
    }
	
	public void agregarEmpresaTrasnportista(EmpresaTransportista empresa) {
		this.empresasTransportistas.add(empresa);
	}
	
	public void registrarOrden(Orden orden) {
		this.ordenes.add(orden);
	}
	public void procesarOrdenSegunBuque(Buque buque) {
		
	}
	
	


}
