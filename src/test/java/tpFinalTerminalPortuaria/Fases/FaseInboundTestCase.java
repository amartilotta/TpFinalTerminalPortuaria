package tpFinalTerminalPortuaria.Fases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
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
	private Ubicacion ubicacion;
	@Before
	public void setUp() throws Exception {
		buqueMock 	 = mock(Buque.class);
		terminalMock = mock(TerminalGestionada.class);
		faseInbound = new FaseInbound(buqueMock);
		ubicacion = mock(Ubicacion.class);
	}
	
	@Test
	public void verificoQueSiBuqueEstaEnLaMismaUbicacionATerminal_EntoncesPasaAFaseArrived() {
		 // Configurar el mock para que tenga trabajo en curso
        when(terminalMock).getUbicacion().thenReturn(ubicacion);
		when(buqueMock.ubicacionActual()).thenReturn(ubicacion);

        // Llamó al método actualizar de faseInbound
		faseInbound.actualizar(terminalMock);

        // Verificó que se llamó a setFase con una instancia de FaseArrived
        verify(buqueMock).setFase(any(FaseArrived.class));

  
        // aseguro de que el método ubicacionActual() se llamó
        verify(buqueMock).ubicacionActual();
 
	}
	
}

