package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.Cronograma.Cronograma;
import tpFinalTerminalPortuaria.terminal.Terminal;

import java.util.*;

public class LineaNaviera {
	
	private String nombreEmpresa;
	private Cronograma cronograma;
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
	
	public double buqueMasProximoASalir(Terminal terminalGestionada, Terminal terminal) {
		return 0;
	}

}
