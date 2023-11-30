package tpFinalTerminalPortuaria.Servicios;

import tpFinalTerminalPortuaria.Container.Container;

public class ServicioAlmacenamiento extends Servicio{

	public ServicioAlmacenamiento(Double precio, Container container) {
		super(precio, container);
	}

	@Override
	public Double precioFinal() {
		return this.getPrecioFijo();
	}

}
