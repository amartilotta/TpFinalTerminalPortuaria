package tpFinalTerminalPortuaria.Servicios;

import tpFinalTerminalPortuaria.Container.Container;

public class ServicioAlmacenamiento extends Servicio{

	public ServicioAlmacenamiento(Double precio) {
		super(precio);
	}

	@Override
	public Double precioFinal(Container container) {
		return this.getPrecioFijo();
	}

}
