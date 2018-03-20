package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="servicios")
public class Servicio {
	
	@Column (name = "fecha", nullable = false, length = 50)
	Date fecha;
	@Column (name = "id_propiedad")
	Propiedad propiedad;
	@Column (name = "id_persona")
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
