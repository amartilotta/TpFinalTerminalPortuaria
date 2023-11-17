package tpFinalTerminalPortuaria.EmpresaTransportistaTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.EmpresaTransportista.EmpresaTransportista;

public class EmpresaTransportistaTestCase {
	private Camion camion;
	private Chofer chofer;
	private EmpresaTransportista empresa;
	private List<Chofer> choferes;
	private List<Camion> camiones;
	
	@BeforeEach
	public void setUp() {
		choferes = new ArrayList<Chofer>();
		camiones = new ArrayList<Camion>();
		camion	 = mock(Camion.class);
		chofer	 = mock(Chofer.class);
		empresa  = new EmpresaTransportista("Morena", camiones, choferes);
	}

	@Test
	public void verificoQueLaEmpresaTieneNombreMorena() {
		assertEquals(empresa.getNombre(),"Morena");
	}
	
	@Test
	public void verificoQueLaEmpresaNoTieneCamionesRegistrados() {
		assertEquals(empresa.getCamiones().size(), 0);
	}
	
	@Test
	public void verificoQueLaEmpresaNoTieneChoferesRegistrados() {
		assertEquals(empresa.getChoferes().size(), 0);
	}
	
	@Test
	public void agregoUnCamionYVerificoQueLaEmpresaTieneRegistradoSoloUnCamion() {
		empresa.agregarCamion(camion);
		assertEquals(empresa.getCamiones().size(), 1);
	}
	
	@Test
	public void agregoUnChoferYVerificoQueLaEmpresaTieneRegistradoSoloUnChofer() {
		empresa.agregarChofer(chofer);
		assertEquals(empresa.getChoferes().size(), 1);
	}
	
	
}
