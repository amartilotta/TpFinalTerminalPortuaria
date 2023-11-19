package tpFinalTerminalPortuaria.Orden;

import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Cliente;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public abstract class Orden {
	private Cliente cliente;
	private Camion camion;
	private Chofer chofer;
	private Viaje viaje;
	private Container container;
	private List<Servicio> servicios;
	private Boolean estaPendiente;
	
	public Orden(Viaje viaje, Container container, Cliente cliente, Chofer chofer, Camion camion, List<Servicio> servicios) {
		this.viaje     = viaje;
		this.container = container;
		this.cliente   = cliente;
		this.chofer    = chofer;
		this.camion    = camion;
		this.servicios = servicios;
		this.estaPendiente = true;
	}
	
	//SETTER:
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	public void setEstaPendiente(Boolean pendiente) {
		this.estaPendiente = pendiente;
	}
	
	//GETTER:
	public Viaje getViaje() {
		return this.viaje;
	}
	public Container getContainer() {
		return this.container;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public Chofer getChofer() {
		return this.chofer;
	}
	public Camion getCamion() {
		return this.camion;
	}
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	public Boolean estaPendiente() {//CUANDO LA ORDEN FUE PROCESADA POR LA TERMINAL, SE SETEA A PENDIENTE:FALSE.
		return this.estaPendiente;
	}
	
	//METODOS:
	public void eliminarServicio(Servicio servicio) {
		if(this.servicios.contains(servicio)) {
			int index = this.servicios.indexOf(servicio);
			this.servicios.remove(index);
		}
	}
	
	public Double precioTotalServicios() {
		return this.servicios.stream().mapToDouble(s -> s.precioFinal(this.getContainer())).sum();
	}
}

















