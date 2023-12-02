package tpFinalTerminalPortuaria.Container;

public class ContainerReefer extends Container {
	private Double consumo;
	
	public ContainerReefer(Double ancho, Double largo, Double altura, Double peso, Double consumo) {
		super(ancho, largo, altura, peso);
		this.consumo = consumo;
	}
	
	//SETTER:
	public void setConsumo(Double consumo) {
		this.consumo	=	consumo;
	}
	//GETTER:
	public Double getConsumo() {
		return this.consumo;
	}
	
	
}
