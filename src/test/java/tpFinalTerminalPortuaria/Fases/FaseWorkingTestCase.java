package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseWorking;
import tpFinalTerminalPortuaria.Buque.FaseDeparting;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseWorkingTestCase {
	private Buque buqueMock;
	private FaseWorking faseWorking;
	private TerminalGestionada terminalMock;
	
	@Before
	public void setUp() throws Exception {
		buqueMock 	 = mock(Buque.class);
		terminalMock = mock(TerminalGestionada.class);
		faseWorking = new FaseWorking(buqueMock);
	}
	
	@Test
	public void verificoQueSiBuqueNoEstaConTrabajoEnCursoYLePidenQueSeActualiceFase_Entonces_PasaAFaseDeparting() {
		 // Configurar el mock para que termine trabajo
        when(buqueMock.estaConTrabajoEnCurso()).thenReturn(false);
        // Llamó al método actualizar de faseWorking
        faseWorking.actualizar(terminalMock); 

        // Verificó que se llamó a setFase con una instancia de FaseDeparting
        verify(buqueMock).setFase(any(FaseDeparting.class));
  
        // aseguro de que el método estaConTrabajoEnCurso se llamó
        verify(buqueMock).estaConTrabajoEnCurso();
 
	}

}