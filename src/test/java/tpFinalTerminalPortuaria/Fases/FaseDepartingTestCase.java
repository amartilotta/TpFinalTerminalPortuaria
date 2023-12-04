package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseDeparting;
import tpFinalTerminalPortuaria.Buque.FaseOutbound;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
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
	
	
	//ACTUALIZAR
	@Test
	public void verificoQueSiBuqueEstaEnFaseDepartingYAUnaDistanciaMayorA1KMDeTerminal_Entonces_AlPedirQueSeActualicePasaAFaseOutbound() {
		 // Configurar el mock para que este a una distancia mayor  a 1km de terminal
		Ubicacion ubicacionMock = mock(Ubicacion.class);
		when(terminalMock.getUbicacion()).thenReturn(ubicacionMock);
        when(buqueMock.distanciaA(terminalMock.getUbicacion())).thenReturn(2d);
        // Llamó al método actualizar de faseWorking
        
        System.out.println(buqueMock.distanciaA(ubicacionMock));
        faseDeparting.actualizar(terminalMock); 

        // Verificó que se llamó a setFase con una instancia de FaseOutbound
        verify(buqueMock).setFase(any(FaseOutbound.class));
  

	}
	
	
	//INICIAR TRABAJO.
	@Test 
	public void verificoQueSiFaseDepartingLeEnvianOrdenDepart_NoHaceNada_BuqueMantieneSuEstado() {
		faseDeparting.depart(terminalMock);
		// Verificó que no hubo cambio de fase
        verify(buqueMock, never()).setFase(any(FaseOutbound.class));
	}
	
	
	//DEPART
	@Test 
	public void verificoQueSiFaseDepartingLeEnvianOrdenIniciarTrabajo_NoHaceNada_BuqueMantieneSuEstado() {
		faseDeparting.iniciarTrabajo(terminalMock);
		// Verificó que no hubo cambio de fase
        verify(buqueMock, never()).setFase(any(FaseOutbound.class));
	}

}

