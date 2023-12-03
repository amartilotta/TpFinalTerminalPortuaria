package tpFinalTerminalPortuaria.Servicios;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioHigiene extends Servicio{

	private Double precioPorMinimoVol ;
	
	public ServicioHigiene(Double precio, Double precioPorMinimoVolumen, Container container) {
		super(precio, container);
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
	public Double precioFinal() {
		Double precioFinal = 0d;
		
		if(this.getContainer().volumen() < 70) {
			precioFinal = this.getPrecioPorMinimoVol();
		}else {
			precioFinal = this.getPrecioFijo();//PRECIO POR VOLUMEN > 70 METROS CUBICOS
		}
		
		return precioFinal;
	}
	
}
