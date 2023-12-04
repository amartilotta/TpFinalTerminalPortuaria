package tpFinalTerminalPortuaria.ICriterio;

import static org.junit.Assert.*;
import org.junit.Test;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import tpFinalTerminalPortuaria.terminal.Terminal;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.*;

public class MenorCantidadTerminalesOrigenDestinoTestCase {

	@Test
    public void testCalcularMejorCircuito() {

        MenorCantidadTerminalesOrigenDestino criterio = new MenorCantidadTerminalesOrigenDestino();

        CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito3 = mock(CircuitoMaritimo.class);

        List<CircuitoMaritimo> circuitos = new ArrayList<>();
        circuitos.add(circuito1);
        circuitos.add(circuito2);
        circuitos.add(circuito3);

        when(circuito1.getTerminales()).thenReturn(Arrays.asList(mock(Terminal.class), mock(Terminal.class)));
        when(circuito2.getTerminales()).thenReturn(Collections.singletonList(mock(Terminal.class)));
        when(circuito3.getTerminales()).thenReturn(Arrays.asList(mock(Terminal.class), mock(Terminal.class), mock(Terminal.class)));


        assertEquals(circuito2, criterio.calcularMejorCircuito(circuitos));
    }

}
