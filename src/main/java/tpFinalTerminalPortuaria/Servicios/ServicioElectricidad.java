package tpFinalTerminalPortuaria.Servicios;
import java.time.Duration;
import java.time.LocalDateTime;
import tpFinalTerminalPortuaria.Container.Container;

public class ServicioElectricidad extends Servicio{
	private LocalDateTime fechaYHoraInicio;
	private LocalDateTime fechaYHoraFin;
	private Float consumoDelReefer;
	
	public ServicioElectricidad(Double precio, LocalDateTime fechaYHoraInicio, LocalDateTime fechaYHoraFin, Float consumo) {
		super(precio);//PRECIO FIJO POR KW/HORA CONSUMIDO
		this.fechaYHoraInicio = fechaYHoraInicio;
		this.fechaYHoraFin    = fechaYHoraFin;
		this.consumoDelReefer = consumo;
	}

	//SETTER:
	public void setFechaYHoraInicio(LocalDateTime fyH) {
		this.fechaYHoraInicio = fyH;
	}
	public void setFechaYHoraFin(LocalDateTime fyHFin) {
		this.fechaYHoraFin = fyHFin;
	}
	public void setConsumoDeReefer(Float consumo) {
		this.consumoDelReefer = consumo;
	}
	
	//GETTER:
	public LocalDateTime getFechaYHoraInicio() {
		return this.fechaYHoraInicio;
	}
	public LocalDateTime getFechaYHoraFin() {
		return this.fechaYHoraFin;
	}
	public Float getConsumoDelReefer() {
		return this.consumoDelReefer;
	}
	
	@Override
	public Double precioFinal(Container container) {
		Duration diferenciaEnHoras = Duration.between(this.getFechaYHoraInicio(), this.getFechaYHoraFin());
		Double cantHorasConsumidas = diferenciaEnHoras.toMillis() / 3600000d;
		Double kwConsumidos = cantHorasConsumidas * this.getConsumoDelReefer(); //indica los kw consumidos por hora
		return kwConsumidos * this.getPrecioFijo();
	}
	

}
