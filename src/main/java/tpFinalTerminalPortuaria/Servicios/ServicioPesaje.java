package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioPesaje extends Servicio{

	public ServicioPesaje(Double precio, Container container) {
		super(precio, container);
	}

	@Override
	public Double precioFinal() {
		return this.getPrecioFijo();
	}

}
