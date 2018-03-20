package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="ventas")
public class Venta extends Servicio {
	@Column (name = "fechaEscritura", nullable = false, length = 50)
	Date fechaEscritura;
	@Column (name = "valorEscritura", nullable = false, length = 50)
	float valorEscritura;
	@Column (name = "comisionVenta", nullable = false, length = 50)
	float comisionVenta;
	@Column (name = "gastosEscritura", nullable = false, length = 50)
	float gastosEscritura;
	
	public Date getFechaEscritura() {
		return fechaEscritura;
	}
	public void setFechaEscritura(Date fechaEscritura) {
		this.fechaEscritura = fechaEscritura;
	}
	public float getValorEscritura() {
		return valorEscritura;
	}
	public void setValorEscritura(float valorEscritura) {
		this.valorEscritura = valorEscritura;
	}
	public float getComisionVenta() {
		return comisionVenta;
	}
	public void setComisionVenta(float comisionVenta) {
		this.comisionVenta = comisionVenta;
	}
	public float getGastosEscritura() {
		return gastosEscritura;
	}
	public void setGastosEscritura(float gastosEscritura) {
		this.gastosEscritura = gastosEscritura;
	}
	public float CalcularComision() {
		float comision = 0;
		return comision;
	}
}
