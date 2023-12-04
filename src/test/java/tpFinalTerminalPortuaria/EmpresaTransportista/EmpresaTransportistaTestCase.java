package tpFinalTerminalPortuaria.EmpresaTransportista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class EmpresaTransportistaTestCase {
	private Camion camion;
	private Chofer chofer;
	private EmpresaTransportista empresa;
	private List<Chofer> choferes;
	private List<Camion> camiones;
	
	@Before
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
	public void verificoElCambioDeNombre() {
		empresa.setNombre("Maloso");
		assertEquals(empresa.getNombre(),"Maloso");
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
	
	@Test
	public void testEsChoferAutorizado() {
		empresa.agregarChofer(chofer);
		assertTrue(empresa.esChoferAutorizado(chofer));
	}
	
	@Test
	public void testEsCamionAutorizado() {
		empresa.agregarCamion(camion);
		assertTrue(empresa.esCamionAutorizado(camion));
	}
	
	
}
