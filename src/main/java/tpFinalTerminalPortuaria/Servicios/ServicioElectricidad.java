package tpFinalTerminalPortuaria.Servicios;
import java.time.Duration;
import java.time.LocalDateTime;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioElectricidad extends Servicio{
	private LocalDateTime fechaYHoraInicio;
	private LocalDateTime fechaYHoraFin;
	
	public ServicioElectricidad(Double precio, LocalDateTime fechaYHoraInicio, LocalDateTime fechaYHoraFin) {
		super(precio);//PRECIO FIJO POR KW/HORA CONSUMIDO
		this.fechaYHoraInicio = fechaYHoraInicio;
		this.fechaYHoraFin    = fechaYHoraFin;
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
	public Double precioFinal(Container container) {
		return this.totalKWConsumidos(container) * this.getPrecioFijo();
	}
	
	
	//METODOS AUX. --consultar con agus. consumo del refeer lo ponemos en el tipo?
	public Double totalKWConsumidos(Container container) {
		Duration diferenciaDeTiempo = Duration.between(this.getFechaYHoraInicio(), this.getFechaYHoraFin());
		Double diferenciaEnHoras = diferenciaDeTiempo.toMillis() / 3600000d;
		return diferenciaEnHoras * container.getConsumoKwHr(); //indica los kw consumidos por hora
	}

}
