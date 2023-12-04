package tpFinalTerminalPortuaria.terminal;

import java.util.*;
import java.util.stream.Collectors;

import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.LineaNaviera.LineaNaviera;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;

public abstract class Terminal {
    private Ubicacion ubicacion;
    private List<LineaNaviera> lineasNavieras = new ArrayList<LineaNaviera>();
    

    public Terminal(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

	public List<CircuitoMaritimo> obtenerCircuitosHaciaDestino(Terminal terminalDestino) {
        return this.obtenerCircuitos().stream()
                .filter(circuito -> circuito.contieneTerminal(terminalDestino))
                .collect(Collectors.toList());
    }
	
	public void agregarLineaNaviera(LineaNaviera lineaNaviera) {
        
		if (!lineasNavieras.contains(lineaNaviera)) {
            lineasNavieras.add(lineaNaviera);
        }
    }
	
	public List<LineaNaviera> getLineasNavieras(){
		return  this.lineasNavieras;
	}
	
	public List<CircuitoMaritimo> obtenerCircuitos() {
	    List<CircuitoMaritimo> circuitos = new ArrayList<>();
	    for (LineaNaviera lineaNaviera : this.obtenerLineasNavieras()) {
	        for (CircuitoMaritimo circuito : lineaNaviera.getCircuitos()) {
	            if (circuito.contieneTerminal(this)) {
	                circuitos.add(circuito);
	            }
	        }
	    }// hacerlo en naviera, dejarle la responsabilidad a ella
	    return circuitos;
	}

	public List<LineaNaviera> obtenerLineasNavieras() {
        return this.lineasNavieras;
    }
	
	
}