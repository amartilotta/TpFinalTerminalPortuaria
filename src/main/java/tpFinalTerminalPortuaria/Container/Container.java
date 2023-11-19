package tpFinalTerminalPortuaria.Container;

public class Container {
	private Double ancho;
	private Double largo;
	private Double altura;
	private Double peso;
	private Tipo tipo;
	
	public Container(Double ancho, Double largo, Double altura, Double peso, Tipo tipo) {
		this.ancho  = ancho;
		this.largo  = largo;
		this.altura = altura;
		this.peso   = peso;
		this.tipo   = tipo;
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
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
	public Tipo getTipo() {
		return this.tipo;
	}
	
	//METODOS AUX.
	public Double volumen() {
		return this.getAncho() * this.getAltura() * this.getLargo();
	}
	
	public Double getConsumoKwHr() {//TIPO REFEER TIENE CONSUMO
		return this.getTipo().getConsumo();
	}
}
