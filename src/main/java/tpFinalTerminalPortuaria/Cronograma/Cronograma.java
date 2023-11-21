package tpFinalTerminalPortuaria.Cronograma;
import tpFinalTerminalPortuaria.Buque.Buque;
import java.time.LocalDate;
import java.util.*;

public class Cronograma {
	private Map<Buque, List<LocalDate>> cronograma = new HashMap();
	
	public Cronograma(Buque buque, List<LocalDate> fechas) {
		this.cronograma.put(buque, fechas);
	}

}
