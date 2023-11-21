package tpFinalTerminalPortuaria.Orden;

import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenImportacion extends Orden{
	private Consignee  cliente;
	
	public OrdenImportacion(Viaje viaje, Container container, Chofer chofer, Camion camion, List<Servicio> servicios, Consignee cliente) {
		super(viaje, container, chofer, camion, servicios);
		this.cliente = cliente;
	}
	
	public Consignee getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Consignee cliente) {
		this.cliente = cliente;
	}
	
}
