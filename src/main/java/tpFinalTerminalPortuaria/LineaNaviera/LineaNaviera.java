package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;
import tpFinalTerminalPortuaria.terminal.Terminal;

import java.util.*;
import java.util.stream.Collectors;
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
	
	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public List<Buque> getBuques() {
		return this.buques;
	}

	public List<Viaje> getViajes() {
		return this.viajes;
	}

	public List<CircuitoMaritimo> getCircuitos(){
		return this.circuitos;
	}
	
	public void crearViaje(Buque buque, CircuitoMaritimo circuito, LocalDate fechaDeSalida) {
		Viaje nuevoNiaje = new Viaje(fechaDeSalida,circuito,buque);
		viajes.add(nuevoNiaje);
	}

//	5. Devolver la próxima fecha de partida de un buque desde la terminal gestionada
//	hasta otra terminal de destino.
	public LocalDate proximaFechaPartidaDeBuqueDesdeTerminalHastaTerminal(Buque buque, TerminalGestionada terminalGestionada, Terminal puertoDestino) {
        List<Viaje> viajesFiltrados = this.filtrarViajesPorBuque(buque.getNombre())
                .stream()
                .filter(viaje -> viaje.getCircuito().contieneTerminales(terminalGestionada, puertoDestino))
                .collect(Collectors.toList());

        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaProxima = viajesFiltrados.stream()
                .map(viaje -> viaje.calcularFechaProxima(terminalGestionada, puertoDestino, fechaActual))
                .filter(Objects::nonNull)
                .min(Comparator.naturalOrder())
                .orElse(null);

        return fechaProxima;
    }
	
	public LocalDate proximaFechaPartidaDeBuqueEnTerminal(Buque buque, TerminalGestionada terminal) {
	    List<Viaje> viajesFiltrados = this.filtrarViajesPorBuque(buque.getNombre())
	            .stream()
	            .filter(viaje -> viaje.tieneTerminal(terminal))
	            .collect(Collectors.toList());

	    LocalDate fechaActual = LocalDate.now();

	    LocalDate fechaProxima = viajesFiltrados.stream()
	            .map(viaje -> viaje.obtenerFechaSalidaDeTerminal(terminal))
	            .filter(Objects::nonNull)
	            .filter(fecha -> fecha.isAfter(fechaActual))
	            .min(Comparator.naturalOrder())
	            .orElse(null);

	    return fechaProxima;
	}
	
	public List<Viaje> filtrarViajesPorBuque(String nombreBuque) {
        return viajes.stream()
                .filter(viaje -> viaje.getBuque().getNombre().equals(nombreBuque))
                .collect(Collectors.toList());
    }


}
