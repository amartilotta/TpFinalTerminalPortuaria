package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;

public abstract class Servicio {
	private Double precioFijo;
	
	public Servicio(Double precio) {
		this.precioFijo = precio;
	}
	
	//SETTER:
	public void setPrecioFijo(Double precio) {
		this.precioFijo = precio;
	}
	
	//GETTER:
	public Double getPrecioFijo() {
		return this.precioFijo;
	}
	
	public abstract Double precioFinal(Container container);
}
