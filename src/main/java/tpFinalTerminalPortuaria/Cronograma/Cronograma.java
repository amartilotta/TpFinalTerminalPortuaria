package tpFinalTerminalPortuaria.Cronograma;

import tpFinalTerminalPortuaria.terminal.Terminal;
import java.time.LocalDate;
import java.util.*;

public class Cronograma {
	private Map<Terminal, LocalDate> cronograma = new HashMap<>();

	public Cronograma(Map<Terminal, LocalDate> cronograma) {
		this.cronograma = cronograma;
	}
	
	public Map<Terminal, LocalDate> getCronogramaDeViaje(){
		return this.cronograma;
	}

	public boolean containsKey(Terminal terminal) {
	    return cronograma.containsKey(terminal);
	}

}
