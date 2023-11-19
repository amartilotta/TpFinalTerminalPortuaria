package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioPesaje extends Servicio{

	public ServicioPesaje(Double precio) {
		super(precio);
	}

	@Override
	public Double precioFinal(Container container) {
		return this.getPrecioFijo();
	}

}
