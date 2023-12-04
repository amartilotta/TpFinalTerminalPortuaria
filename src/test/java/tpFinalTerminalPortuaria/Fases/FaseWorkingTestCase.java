package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
	
	//ACTUALIZAR
	@Test
	public void verificoQueSiFaseWorkingLePidenQueSeActualice_Entonces_BuquePasaADeparting() {
        // Llamó al método actualizar de faseWorking
        faseWorking.actualizar(terminalMock); 
        // Verificó que se llamó a setFase con una instancia de FaseDeparting
        verify(buqueMock).setFase(any(FaseDeparting.class)); 
	}
	
	//DEPART
	@Test
	public void verificoQueSiAFaseWorkingLeMandanOrdenDepart_Entonces_BuquePasaADeparting() {
		faseWorking.depart(terminalMock);
		// Verificó que se llamó a setFase con una instancia de FaseDeparting
        verify(buqueMock).setFase(any(FaseDeparting.class)); 
	}
	
	//INICIAR TRABAJO
	@Test
	public void verificoQueSiAFaseWorkingLeMandanOrdenIniciarTrabajo_NoHaceNada_BuqueMantieneFase() {
		faseWorking.iniciarTrabajo(terminalMock);
		verify(buqueMock, never()).setFase(any(FaseDeparting.class));;
	}
	

}

