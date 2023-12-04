package tpFinalTerminalPortuaria.ICriterio;

import static org.junit.Assert.*;
import org.junit.Test;
import tpFinalTerminalPortuaria.CircuitoMaritimo.CircuitoMaritimo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.*;

public class MenorTiempoOrigenDestinoTestCase {

	@Test
    public void testCalcularMejorCircuito() {
        MenorTiempoOrigenDestino criterio = new MenorTiempoOrigenDestino();

        CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
        CircuitoMaritimo circuito3 = mock(CircuitoMaritimo.class);

        List<CircuitoMaritimo> circuitos = new ArrayList<>();
        circuitos.add(circuito1);
        circuitos.add(circuito2);
        circuitos.add(circuito3);

        when(circuito1.calcularTiempoTotal()).thenReturn(5L);
        when(circuito2.calcularTiempoTotal()).thenReturn(3L);
        when(circuito3.calcularTiempoTotal()).thenReturn(7L);

        assertEquals(circuito2, criterio.calcularMejorCircuito(circuitos));
    }

}
