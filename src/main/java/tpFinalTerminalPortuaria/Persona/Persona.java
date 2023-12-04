package tpFinalTerminalPortuaria.Persona;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	
	public Persona(String nombre, String apellido, String dni, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}
	
	//SETTER:
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//GETTER:
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public String getDNI() {
		return this.dni;
	}
	public String getEmail() {
		return this.email;
	}
}
