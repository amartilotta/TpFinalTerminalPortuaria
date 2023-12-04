package tpFinalTerminalPortuaria.ICriterio;

import static org.junit.Assert.*;
import org.junit.Test;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.*;

public class MenorPrecioTotalOrigenDestinoTestCase {

	@Test
    public void testCalcularMejorCircuito() {
        MenorPrecioTotalOrigenDestino criterio = new MenorPrecioTotalOrigenDestino();

        CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito3 = mock(CircuitoMaritimo.class);

        List<CircuitoMaritimo> circuitos = new ArrayList<>();
        circuitos.add(circuito1);
        circuitos.add(circuito2);
        circuitos.add(circuito3);

        when(circuito1.calcularPrecioTotal()).thenReturn((long) 1000.0);
        when(circuito2.calcularPrecioTotal()).thenReturn((long) 800.0);
        when(circuito3.calcularPrecioTotal()).thenReturn((long) 1200.0);

        assertEquals(circuito2, criterio.calcularMejorCircuito(circuitos));
    }

}
