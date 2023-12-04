package tpFinalTerminalPortuaria.Buque;
import java.util.ArrayList;
import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class Buque {
	private String nombre;
	private Fase fase;
	private Ubicacion ubicacion;
	private List<Container> containeres;
	
	public Buque(String nombre) {
		this.nombre = nombre;
		this.fase = new FaseOutbound(this);//FASE INICIAL
		this.ubicacion = new Ubicacion(0, 0);
		this.containeres = new ArrayList<Container>();
	}
	 
	//SETTER:
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public void actualizarUbicacionPorGps(Ubicacion ubicacionEnviadaPorGps) { 
		this.ubicacion = ubicacionEnviadaPorGps;//ubicacion.actualizarUbicacion();
		
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
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

	public List<Container> getContainer(){
		return this.containeres;
	}
	
	//METODOS:
	public void actualizarFase(TerminalGestionada terminal) {
		this.getFase().actualizar(terminal); 
	} 
	
	public void iniciarTrabajo(TerminalGestionada terminal) {//La terminal se comunica con el buque para pasar a fase WORKING
		this.getFase().iniciarTrabajo(terminal);
	}
	
	public void depart(TerminalGestionada terminal) {
		this.getFase().depart(terminal);
	}

	public Double distanciaA(Ubicacion ubicacionTerminal) {
		Ubicacion ubicacionActual = this.getUbicacion();
		Double distancia = ubicacionActual.calcularDistancia(ubicacionTerminal);
		return distancia;
	}
	 
}
