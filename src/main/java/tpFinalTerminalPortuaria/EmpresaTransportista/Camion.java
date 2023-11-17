package tpFinalTerminalPortuaria.EmpresaTransportista;

public class Camion {
	private String patente;
	
	public Camion(String patente) {
		this.patente = patente;
	}
	
	//SETTER:
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	//GETTER:
	public String getPatente() {
		return this.patente;
	}
}
