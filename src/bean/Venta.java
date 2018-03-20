package bean;

import java.util.Date;

public class Venta {
	Date fechaEscritura;
	float valorEscritura;
	float comisionVenta;
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
