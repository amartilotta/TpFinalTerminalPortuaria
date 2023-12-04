package tpFinalTerminalPortuaria.Servicios;
import java.time.Duration;
import java.time.LocalDateTime;
import tpFinalTerminalPortuaria.Container.ContainerReefer;

public class ServicioElectricidad extends Servicio{
	private LocalDateTime fechaYHoraInicio;
	private LocalDateTime fechaYHoraFin;
	private ContainerReefer container;
	
	public ServicioElectricidad(Double precio, LocalDateTime fechaYHoraInicio, LocalDateTime fechaYHoraFin, ContainerReefer container) {
		super(precio, container);//PRECIO FIJO POR KW/HORA CONSUMIDO
		this.fechaYHoraInicio = fechaYHoraInicio;
		this.fechaYHoraFin    = fechaYHoraFin;
		this.container 		  = container;
	}

	//SETTER:
	public void setFechaYHoraInicio(LocalDateTime fyH) {
		this.fechaYHoraInicio = fyH;
	}
	public void setFechaYHoraFin(LocalDateTime fyHFin) {
		this.fechaYHoraFin = fyHFin;
	}

	
	//GETTER:
	public LocalDateTime getFechaYHoraInicio() {
		return this.fechaYHoraInicio;
	}
	public LocalDateTime getFechaYHoraFin() {
		return this.fechaYHoraFin;
	}


	@Override
	public Double precioFinal() {
		return this.totalKWConsumidos() * this.getPrecioFijo();
	}
	
	
	//METODOS AUX. 
	public Double totalKWConsumidos() {
		Duration diferenciaDeTiempo = Duration.between(this.getFechaYHoraInicio(), this.getFechaYHoraFin());
		Double diferenciaEnHoras = diferenciaDeTiempo.toMillis() / 3600000d;
		return diferenciaEnHoras * this.container.getConsumo(); //indica los kw consumidos por hora
	}

 
}
