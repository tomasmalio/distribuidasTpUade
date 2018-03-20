package bean;

import javax.persistence.*;

@Entity
@Table(name="propiedades")
public class Propiedad {

	@Id
	private String nroPartida;
	private String calle;
	private int numero;
	private String piso;
	private String departamento;
	private String ciudad;
	private String cantidadAmbientes;
	private float metrosCubiertos;
	private float valorAlquiler;
	private float valorVenta;
	private float impuestos;
	private float servicios;
	private float expensas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_id")
	private Persona propietario;
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNroPartida(String nroPartida) {
		this.nroPartida = nroPartida;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCantidadAmbientes(String cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public void setMetrosCubiertos(float metrosCubiertos) {
		this.metrosCubiertos = metrosCubiertos;
	}

	public void setValorAlquiler(float valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public void setValorVenta(float valorVenta) {
		this.valorVenta = valorVenta;
	}

	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}

	public void setServicios(float servicios) {
		this.servicios = servicios;
	}

	public void setExpensas(float expensas) {
		this.expensas = expensas;
	}
	
	public int getNumero() {
		return numero;
	}

	public String getNroPartida() {
		return nroPartida;
	}

	public String getCalle() {
		return calle;
	}
	
	public String getPiso() {
		return piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public double getMetrosCubiertos() {
		return metrosCubiertos;
	}

	public double getValorAlquiler() {
		return valorAlquiler;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public double getServicios() {
		return servicios;
	}

	public double getExpensas() {
		return expensas;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
}