package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="alquileres")
public class Alquiler extends Servicio {
	
	@Column (name = "fechaDesde", nullable = false, length = 50)
	Date fechaDesde;
	
	@Column (name = "fechaHasta", nullable = false, length = 50)
	Date fechaHasta;
	
	@Column (name = "comisionGestion", nullable = false, length = 50)
	float comisionGestion;
	
	@Column (name = "gastosSellado", nullable = false, length = 50)
	float gastosSellado;
	
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public float getComisionGestion() {
		return comisionGestion;
	}
	public void setComisionGestion(float comisionGestion) {
		this.comisionGestion = comisionGestion;
	}
	public float getGastosSellado() {
		return gastosSellado;
	}
	public void setGastosSellado(float gastosSellado) {
		this.gastosSellado = gastosSellado;
	}
	public float CalcularComision() {
		float comision = 0;
		return comision;
	}
	
}
