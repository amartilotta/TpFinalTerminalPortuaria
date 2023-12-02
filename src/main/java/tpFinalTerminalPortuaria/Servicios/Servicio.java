package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.Container.ContainerReefer;

public abstract class Servicio {
	private Double precioFijo;
	private Container container;
	
	public Servicio(Double precio, Container container) {
		this.precioFijo = precio;
		this.container  = container;
	}
	
	//SETTER:
	public void setPrecioFijo(Double precio) {
		this.precioFijo = precio;
	}
	public void setContainer(ContainerReefer container) {
		this.container = container;
	}
	
	//GETTER:
	public Double getPrecioFijo() {
		return this.precioFijo;
	}	
	public Container getContainer() {
		return this.container;
	}
	
	public abstract Double precioFinal();
}
