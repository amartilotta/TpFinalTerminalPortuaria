package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioHigiene extends Servicio{

	private Double precioPorMinimoVol ;
	
	public ServicioHigiene(Double precio, Double precioPorMinimoVolumen) {
		super(precio);
		this.precioPorMinimoVol = precioPorMinimoVolumen;
	}

	//SETTER:
	public void setPrecioPorMinimoVol(Double precio) {
		this.precioPorMinimoVol = precio;
	}
	
	//GETTER:
	public Double getPrecioPorMinimoVol() {
		return this.precioPorMinimoVol;
	}
	
	@Override
	public Double precioFinal(Container container) {
		Double volumen = container.getAncho() * container.getAltura() * container.getLargo();
		Double precioFinal = this.getPrecioFijo();//PRECIO POR VOLUMEN > 70 METROS CUBICOS
		if(volumen < 70) {
			precioFinal = this.getPrecioPorMinimoVol();
		}
		
		return precioFinal;
	}
	
}
