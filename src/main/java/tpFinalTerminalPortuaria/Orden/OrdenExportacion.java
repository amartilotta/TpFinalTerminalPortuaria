package tpFinalTerminalPortuaria.Orden;

import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenExportacion extends Orden{
	private Shipper shipper;
	
	public OrdenExportacion(Viaje viaje, Container container, Chofer chofer, Camion camion, List<Servicio> servicios, Shipper cliente) {
		super(viaje, container, chofer, camion, servicios);
		this.shipper = cliente;
	}

	public Shipper getCliente() {
		return this.shipper;
	}
	public void setCliente(Shipper cliente) {
		this.shipper = cliente;
	}

}
