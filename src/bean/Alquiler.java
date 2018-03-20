package bean;

import java.util.Date;

public class Alquiler {
	Date fechaDesde;
	Date fechaHasta;
	float comisionGestion;
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
