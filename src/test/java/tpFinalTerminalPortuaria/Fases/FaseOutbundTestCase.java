package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseInbound;
import tpFinalTerminalPortuaria.Buque.FaseOutbound;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseOutbundTestCase {
		private Buque buqueMock;
		private FaseOutbound faseOutbound;
		private TerminalGestionada terminalMock;
		
		@Before
		public void setUp() throws Exception {
			buqueMock 	 = mock(Buque.class);
			terminalMock = mock(TerminalGestionada.class);
			faseOutbound = new FaseOutbound(buqueMock);
		}
		
		@Test
		public void verificoQueSiBuqueEstaCercanoATerminal_EntoncesPasaAFaseWorking() {
			 // Configurar el mock para este a una distancia cercana a terminal
	        when(buqueMock.distanciaA(terminalMock)).thenReturn(30d);

	        // Llamó al método actualizar de FaseArrived
	        faseOutbound.actualizar(terminalMock);

	        // Verificó que se llamó a setFase con una instancia de FaseInbound
	        verify(buqueMock).setFase(any(FaseInbound.class));

	  
	        // aseguro de que el método distanciaA se llamó
	        verify(buqueMock).distanciaA(terminalMock);
	 
		}

}
