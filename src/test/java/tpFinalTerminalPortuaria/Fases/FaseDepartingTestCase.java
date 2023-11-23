package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseDeparting;
import tpFinalTerminalPortuaria.Buque.FaseOutbound;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseDepartingTestCase {
	private Buque buqueMock;
	private FaseDeparting faseDeparting;
	private TerminalGestionada terminalMock;
	
	@Before
	public void setUp() throws Exception {
		buqueMock 	 = mock(Buque.class);
		terminalMock = mock(TerminalGestionada.class);
		faseDeparting = new FaseDeparting(buqueMock);
	}
	
	@Test
	public void verificoQueSiBuqueEstaEnFaseDepartingYAUnaDistanciaMayorA1KMDeTerminal_Entonces_AlPedirQueSeActualicePasaAFaseOutbound() {
		 // Configurar el mock para que este a una distancia mayor  a 1km de terminal
        when(buqueMock.distanciaA(terminalMock)).thenReturn(2d);
        // Llamó al método actualizar de faseWorking
        faseDeparting.actualizar(terminalMock); 

        // Verificó que se llamó a setFase con una instancia de FaseDeparting
        verify(buqueMock).setFase(any(FaseOutbound.class));
  
        // aseguro de que el método distanciaA() se llamó
        verify(buqueMock).distanciaA(terminalMock);
 
	}

}