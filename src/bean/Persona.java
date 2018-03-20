package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	@Id
	String cuil_cuit;
	String nombre_razon;
	String domicilio;
	String telefono;
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
