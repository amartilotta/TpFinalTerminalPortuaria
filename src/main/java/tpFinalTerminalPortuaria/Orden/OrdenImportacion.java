package tpFinalTerminalPortuaria.Orden;

import java.util.List;

import tpFinalTerminalPortuaria.Container.Container;
import tpFinalTerminalPortuaria.EmpresaTransportista.Camion;
import tpFinalTerminalPortuaria.EmpresaTransportista.Chofer;
import tpFinalTerminalPortuaria.Persona.Consignee;
import tpFinalTerminalPortuaria.Servicios.Servicio;
import tpFinalTerminalPortuaria.Viaje.Viaje;

public class OrdenImportacion extends Orden{

	public OrdenImportacion(Viaje viaje, Container container, Consignee cliente, Chofer chofer, Camion camion, List<Servicio> servicios) {
		super(viaje, container, cliente, chofer, camion, servicios);
	}

}
