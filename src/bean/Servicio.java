package bean;

import java.util.Date;

public class Servicio {
	Date fecha;
	Propiedad propiedad;
	Persona interesado;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	public Persona getInteresado() {
		return interesado;
	}
	public void setInteresado(Persona interesado) {
		this.interesado = interesado;
	}
	public float CalcularComision() {
		float comision = 0;
		return comision;
	}
	
}
