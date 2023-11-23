package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Cronograma.Cronograma;
import tpFinalTerminalPortuaria.terminal.Terminal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;

public class LineaNaviera {
	
	private String nombreEmpresa;
	private List<CircuitoMaritimo> circuitos = new ArrayList<CircuitoMaritimo>();
	private List<Buque> buques = new ArrayList<Buque>();
	private List<Viaje> viajes = new ArrayList<Viaje>();
	
	public LineaNaviera(String nombre, List<Buque> buques, List<CircuitoMaritimo> circuitos) {
		this.nombreEmpresa = nombre;
		this.buques = buques;
		this.circuitos = circuitos;
	}
	
	public double tiempoDesdeTerminalHastaTerminal(Terminal terminalGestionada, Terminal terminal){
		return 0;
	}
	
	public double fechaBuqueMasProximoASalir(Terminal terminalGestionada, Terminal terminal) {
		return 0;
	}
	
	public Cronograma generarCronogramaViaje(CircuitoMaritimo circuito) {
		Map<Terminal, LocalDate> informacion = circuito.getTerminalesYFechasSalida();
		return new Cronograma(informacion);
	}
	
	public void añadirViaje() {
		Viaje viaje = new Viaje()
	}
//	Devolver la próxima fecha de partida de un buque desde la terminal gestionada
//	hasta otra terminal de destino.

	public List<CircuitoMaritimo> getCircuitos(){
		return this.circuitos;
	}

}
