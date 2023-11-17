package tpFinalTerminalPortuaria.Container;

public class Container {
	private Double ancho;
	private Double largo;
	private Double altura;
	private Double peso;
	
	public Container(Double ancho, Double largo, Double altura, Double peso) {
		this.ancho  = ancho;
		this.largo  = largo;
		this.altura = altura;
		this.peso   = peso;
	}
	
	//SETTER:
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	//GETTER:
	public Double getAncho() {
		return this.ancho;
	}
	public Double getLargo() {
		return this.largo;
	}
	public Double getAltura() {
		return this.altura;
	}
	public Double getPeso() {
		return this.peso;
	}
}
