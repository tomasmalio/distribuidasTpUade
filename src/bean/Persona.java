package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")

public class Persona {
	@Id 
	@Column (name = "cuil_cuit")
	String cuil_cuit;
	@Column (name = "nombre_razon", nullable = false, length = 50)
	String nombre_razon;
	@Column (name = "domicilio", nullable = false, length = 50)
	String domicilio;
	@Column (name = "telefono", nullable = false, length = 10)
	String telefono;
	@Column (name = "mail", nullable = false, length = 120)
	String mail;

	public String getCuil_cuit() {
		return cuil_cuit;
	}
	public void setCuil_cuit(String cuil_cuit) {
		this.cuil_cuit = cuil_cuit;
	}
	public String getNombre_razon() {
		return nombre_razon;
	}
	public void setNombre_razon(String nombre_razon) {
		this.nombre_razon = nombre_razon;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
