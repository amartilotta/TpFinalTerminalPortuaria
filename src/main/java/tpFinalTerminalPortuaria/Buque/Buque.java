package tpFinalTerminalPortuaria.Buque;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Buque {
	private String nombre;
	private Fase fase;
	private Ubicacion ubicacion;
	
	public Buque(String nombre) {
		this.nombre = nombre;
		this.fase = new FaseOutbound();//FASE INICIAL
		this.ubicacion = new Ubicacion();
	}
	
	//SETTER:
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public Ubicacion ubicacionActual() {
		return null;//ubicacion.actualizarUbicacion();
	}
	
	
	//GETTER:
	public String getNombre() {
		return this.nombre;
	}
	public Fase getFase() {
		return this.fase;
	}
	
	//METODOS:
	public void actualizarFase(Terminal terminal) {
		this.getFase().actualizar(this, terminal);
	}
	 
}
