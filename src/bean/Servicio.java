package bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Propiedad propiedad;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Persona interesado;
	
	public int getId() {
		return id;
	}
	
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
