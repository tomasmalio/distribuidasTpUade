package bean;

import javax.persistence.*;

@Entity
@Table(name="propiedad")
public class Propiedad {

	@Id
	private int numero;
	private String nroPartida;
	private String calle;
	private String departamento;
	private String ciudad;
	private String cantidadAmbientes;
	private double metrosCubiertos;
	private double valorAlquiler;
	private double valorVenta;
	private double impuestos;
	private double servicios;
	private double expensas;
	
//	@Column (name = "id_persona", nullable = false, length = 13)
//	private Persona propietario;
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNroPartida(String nroPartida) {
		this.nroPartida = nroPartida;
	}

	public void setCalle(String calle) {
		this.calle = calle;
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

	public void setMetrosCubiertos(double metrosCubiertos) {
		this.metrosCubiertos = metrosCubiertos;
	}

	public void setValorAlquiler(double valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public void setServicios(double servicios) {
		this.servicios = servicios;
	}

	public void setExpensas(double expensas) {
		this.expensas = expensas;
	}

//	public void setPropietario(Persona propietario) {
//		this.propietario = propietario;
//	}

	public int getNumero() {
		return numero;
	}

	public String getNroPartida() {
		return nroPartida;
	}

	public String getCalle() {
		return calle;
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
	
//	@ManyToOne
//	@JoinColumn(name="persona")
//	public Persona getPropietario() {
//		return propietario;
//	}
	
}