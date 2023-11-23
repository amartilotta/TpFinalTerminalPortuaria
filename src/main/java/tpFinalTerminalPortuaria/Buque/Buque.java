package tpFinalTerminalPortuaria.Buque;
import java.util.ArrayList;
import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.Terminal;

public class Buque {
	private String nombre;
	private Fase fase;
	private Ubicacion ubicacion;
	private Boolean estaConTrabajoEnCurso;
	private List<Container> containeres;
	
	public Buque(String nombre) {
		this.nombre = nombre;
		this.fase = new FaseOutbound(this);//FASE INICIAL
		this.ubicacion = new Ubicacion(0, 0);
		this.estaConTrabajoEnCurso = false;
		this.containeres = new ArrayList<Container>();
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
		
		return this.ubicacion;//ubicacion.actualizarUbicacion();
	}
	
	public void agregarContainer(Container container) {
		this.containeres.add(container);
	}
	
	public void eliminarContainer(Container container) {
		if(this.containeres.contains(container)) {
			int index = this.containeres.indexOf(container);
			this.containeres.remove(index);
		}
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
	public List<Container> getContainer(){
		return this.containeres;
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

	public int distanciaA(Terminal terminal) {
		Ubicacion ubicacionActual = this.ubicacionActual();
		int distancia = ubicacionActual.distanciaA(terminal.getUbicacion());
		return distancia;
	}
	 
}
