package bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	private Propiedad propiedad;
	private Persona interesado;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
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
