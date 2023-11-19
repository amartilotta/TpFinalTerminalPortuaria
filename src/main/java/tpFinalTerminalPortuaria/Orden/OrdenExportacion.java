package tpFinalTerminalPortuaria.Orden;

import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Shipper;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenExportacion extends Orden{

	public OrdenExportacion(Viaje viaje, Container container, Shipper cliente, Chofer chofer, Camion camion, List<Servicio> servicios) {
		super(viaje, container, cliente, chofer, camion, servicios);
	}

}
