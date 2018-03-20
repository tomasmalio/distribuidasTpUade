package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="propiedad")
public class Propiedad {

	@Id 
	@Column (name = "numero")
	private int numero;
	
	@Column (name = "nroPartida", nullable = false, length = 20)
	private String nroPartida;
	
	@Column (name = "calle", nullable = false, length = 80)
	private String calle;
	
	@Column (name = "departamento", nullable = false, length = 50)
	private String departamento;
	
	@Column (name = "ciudad", nullable = false, length = 50)
	private String ciudad;
	
	@Column (name = "cantidadAmbientes", nullable = false, length = 2)
	private String cantidadAmbientes;
	
	@Column (name = "metrosCubiertos", nullable = false, length = 5)
	private double metrosCubiertos;
	
	@Column (name = "valorAlquiler", nullable = false, length = 15)
	private double valorAlquiler;
	
	@Column (name = "valorVenta", nullable = false, length = 15)
	private double valorVenta;
	
	@Column (name = "impuestos", nullable = false, length = 4)
	private double impuestos;
	
	@Column (name = "servicios", nullable = false, length = 4)
	private double servicios;
	
	@Column (name = "expensas", nullable = false, length = 4)
	private double expensas;
	
	@Column (name = "propietario", nullable = false, length = 13)
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

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
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
	
	@ManyToOne
	@JoinColumn(name="persona")
	public Persona getPropietario() {
		return propietario;
	}
	
}