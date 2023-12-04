package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
	public void verificoQueSiSeActualizaLaFaseArrived_Entonces_BuquePasaAWorking() {
        // Llamó al método actualizar de FaseArrived
        faseArrived.actualizar(terminalMock);
        // Verificó que se llamó a setFase con una instancia de FaseWorking
        verify(buqueMock).setFase(any(FaseWorking.class));
	}
	
	@Test
	public void verificoQueSiAFaseArrivedLeEnvianOrdenDeIniciarTrabajo_Entonces_BuquePasaAWorking() {
        // Llamó al método actualizar de FaseArrived
        faseArrived.iniciarTrabajo(terminalMock);
        // Verificó que se llamó a setFase con una instancia de FaseWorking
        verify(buqueMock).setFase(any(FaseWorking.class));
	}
	
	@Test
	public void verificoQueSiAFaseLeEnvianOrdenDepart_NoHaceNada_BuqueMantieneSuEstado() {		
		faseArrived.depart(terminalMock);
		// Verificó que no hubo cambio de fase
        verify(buqueMock, never()).setFase(any(FaseWorking.class));
	}
	
}







