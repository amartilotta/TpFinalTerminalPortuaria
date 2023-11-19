package tpFinalTerminalPortuaria.Container;

public enum Tipo {
	DRY(0d),
	TANQUE(0d),
	REFEER(0d);
	
	private Double consumo;
	
	Tipo(Double consumo) { //EL CONSUMO ES SOLO PARA TIPO REFEER
		this.consumo = consumo;
	}
	
	public void setConsumo(Double consumo) {
		this.consumo	=	consumo;
	}
	
	public Double getConsumo() {
		return this.consumo;
	}
}
