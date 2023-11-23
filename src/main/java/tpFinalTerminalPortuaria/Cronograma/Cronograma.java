package tpFinalTerminalPortuaria.Cronograma;

import tpFinalTerminalPortuaria.terminal.Terminal;
import java.time.LocalDate;
import java.util.*;

public class Cronograma {
	private Map<Terminal, LocalDate> cronograma = new HashMap<>();

	public Cronograma(Map<Terminal, LocalDate> informacion) {
		this.cronograma = informacion;
	}
	
	public Map<Terminal, LocalDate> getCronogramaDeViaje(){
		return this.cronograma;
	}

}
