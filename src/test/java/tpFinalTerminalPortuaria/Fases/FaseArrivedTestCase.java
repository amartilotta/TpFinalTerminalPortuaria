package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseArrived;
import tpFinalTerminalPortuaria.Buque.FaseWorking;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseArrivedTestCase {
	private Buque buqueMock;
	private FaseArrived faseArrived;
	private TerminalGestionada terminalMock;
	
	@Before
	public void setUp() throws Exception {
		buqueMock 	 = mock(Buque.class);
		terminalMock = mock(TerminalGestionada.class);
		faseArrived = new FaseArrived(buqueMock);
	}
	
	@Test
	public void verificoQueSiBuqueTieneTrabajoEnCurso_EntoncesPasaAFaseWorking() {
		 // Configurar el mock para que tenga trabajo en curso
        when(buqueMock.estaConTrabajoEnCurso()).thenReturn(true);

        // Llamó al método actualizar de FaseArrived
        faseArrived.actualizar(terminalMock);

        // Verificó que se llamó a setFase con una instancia de FaseWorking
        verify(buqueMock).setFase(any(FaseWorking.class));

  
        // aseguro de que el método estaConTrabajoEnCurso se llamó
        verify(buqueMock).estaConTrabajoEnCurso();
 
	}
	
}







