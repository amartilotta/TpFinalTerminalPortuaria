package tpFinalTerminalPortuaria.Buque;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Buque {
	private String nombre;
	private Fase fase;
	private Ubicacion ubicacion;
	private Boolean estaConTrabajoEnCurso;
	
	public Buque(String nombre) {
		this.nombre = nombre;
		this.fase = new FaseOutbound(this);//FASE INICIAL
		this.ubicacion = new Ubicacion();
		this.estaConTrabajoEnCurso = false;
	}
	
	//SETTER:
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	public void setEstaConTrabajoEnCurso(Boolean esta) {
		this.estaConTrabajoEnCurso = esta;
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
	public Boolean estaConTrabajoEnCurso() {
		return this.estaConTrabajoEnCurso;
	}
	
	//METODOS:
	public void actualizarFase(Terminal terminal) {
		this.getFase().actualizar(terminal);
	}
	
	public void iniciarTrabajo(Terminal terminal) {//La terminal se comunica con el buque para pasar a fase WORKING
		this.setEstaConTrabajoEnCurso(true);
		this.actualizarFase(terminal);
	}
	
	public void depart(Terminal terminal) {
		this.setEstaConTrabajoEnCurso(false);
		this.actualizarFase(terminal);
	}
	 
}
