package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import tpFinalTerminalPortuaria.Buque.Buque;
import tpFinalTerminalPortuaria.Buque.FaseInbound;
import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;
import tpFinalTerminalPortuaria.Buque.FaseArrived;
import tpFinalTerminalPortuaria.terminal.TerminalGestionada;

public class FaseInboundTestCase {
	private Buque buqueMock;
	private FaseInbound faseInbound;
	private TerminalGestionada terminalMock;
	@Before
	public void setUp() throws Exception {
		buqueMock 	 = mock(Buque.class);
		terminalMock = mock(TerminalGestionada.class);
		faseInbound = new FaseInbound(buqueMock);
	}
	
	
	//ACTUALIZAR
	@Test
	public void verificoQueSiBuqueEstaEnLaMismaUbicacionATerminal_EntoncesPasaAFaseArrived() {
		 // Configurar el mock para que tenga trabajo en curso
		Ubicacion ubicacionMock = mock(Ubicacion.class);
		when(buqueMock.distanciaA(ubicacionMock)).thenReturn(0d);

        // Llamó al método actualizar de faseInbound
		faseInbound.actualizar(terminalMock);

        // Verificó que se llamó a setFase con una instancia de FaseArrived
        verify(buqueMock).setFase(any(FaseArrived.class));

  
	}
	
	//DEPART
	@Test 
	public void verificoQueSiFaseInboundLeEnvianOrdenDepart_NoHaceNada_BuqueMantieneSuEstado() {
		faseInbound.depart(terminalMock);
		// Verificó que no hubo cambio de fase
        verify(buqueMock, never()).setFase(any(FaseArrived.class));
	}
	
	//INICIAR TRABAJO
	@Test 
	public void verificoQueSiFaseInboundLeEnvianOrdenIniciarTrabajo_NoHaceNada_BuqueMantieneSuEstado() {
		faseInbound.iniciarTrabajo(terminalMock);
		// Verificó que no hubo cambio de fase
        verify(buqueMock, never()).setFase(any(FaseArrived.class));
	}

	
	
	
}

