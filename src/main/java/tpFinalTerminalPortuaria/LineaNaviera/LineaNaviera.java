package tpFinalTerminalPortuaria.LineaNaviera;
import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Viaje.Viaje;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

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

	public void crearViaje(Buque buque, CircuitoMaritimo circuito, LocalDate fechaDeSalida) {
		Viaje nuevoNiaje = new Viaje(fechaDeSalida,circuito,buque);
		viajes.add(nuevoNiaje);
	}
//	Devolver la próxima fecha de partida de un buque desde la terminal gestionada
//	hasta otra terminal de destino.
	public LocalDate proximaFechaPartidaDeBuqueEnTerminal(Buque buque, TerminalGestionada terminal) {
        List<Viaje> viajesFiltrados = filtrarViajesPorBuque(buque.getNombre())
                .stream()
                .filter(viaje -> viaje.tieneTerminal(terminal))
                .collect(Collectors.toList());

        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaProxima = viajesFiltrados.stream()
                .map(viaje -> viaje.obtenerEntradaCronograma(terminal))
                .filter(Objects::nonNull)
                .filter(entry -> entry.getValue().isAfter(fechaActual))
                .map(Map.Entry::getValue)
                .min(Comparator.naturalOrder())
                .orElse(null);

        return fechaProxima;
    }
	
	public List<Viaje> filtrarViajesPorBuque(String nombreBuque) {
        return viajes.stream()
                .filter(viaje -> viaje.getBuque().getNombre().equals(nombreBuque))
                .collect(Collectors.toList());
    }

	public List<CircuitoMaritimo> getCircuitos(){
		return this.circuitos;
	}

}