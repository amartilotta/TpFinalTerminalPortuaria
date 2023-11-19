package tpFinalTerminalPortuaria.EmpresaTransportista;

import java.util.List;

public class EmpresaTransportista {
	private String nombre;
	private List<Camion> camiones;
	private List<Chofer> choferes;
	
	public EmpresaTransportista(String nombre, List<Camion> camiones, List<Chofer> choferes) {
		this.nombre = nombre;
		this.camiones = camiones;
		this.choferes = choferes;
	}
	
	//SETTER:
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void agregarCamion(Camion camionNuevo) {
		this.camiones.add(camionNuevo);
	}
	
	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
	}
	
	//GETTER:
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Camion> getCamiones(){
		return this.camiones;
	}
	
	public List<Chofer> getChoferes(){
		return this.choferes;
	}
	

}




