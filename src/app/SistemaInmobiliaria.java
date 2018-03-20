package app;

import java.time.LocalDate;
import java.util.List;

import bean.Persona;
import bean.PersonaList;
import bean.Propiedad;
import bean.PropiedadList;
import bean.Servicio;
import bean.ServicioList;

public class SistemaInmobiliaria {
	private PersonaList personas = new PersonaList();
	private PropiedadList propiedades = new PropiedadList();
	private ServicioList servicios = new ServicioList();
	
	public float calcularComisiones(LocalDate fechaDesde, LocalDate fechaHasta ) {
		return 1;
	}
	//////////////
	// PERSONAS //
	//////////////
	public List<Persona> getPersonas(){
		return personas.getPersonas();
	}
	
	public void addPersona(String nombre_razon) {
		Persona persona = new Persona();
		persona.setNombre_razon(nombre_razon);
		personas.addPersona(persona);
	}
	
	public void grabarUsuarios(List<Persona> personas){
		// new PersonaSRV().grabarPersona(personas);
	}
	
	/////////////////
	// PROPIEDADES //
	/////////////////
	public List<Propiedad> getPropiedades(){
		return propiedades.getPropiedades();
	}
	
	public void addPropiedad(String calle, String ciudad, String cantAmb, String departamento, 
	  Double expensas, Double impuestos, Double metrosCubiertos, String nroPartida, int numero,
	  Persona propietario, double servicios, double valorAlquiler, double valorVenta) {
		Propiedad propiedad = new Propiedad();
		propiedad.setCalle(calle);
		propiedad.setCiudad(ciudad);
		propiedad.setCantidadAmbientes(cantAmb);
		propiedad.setDepartamento(departamento);
		propiedad.setExpensas(expensas);
		propiedad.setImpuestos(impuestos);
		propiedad.setMetrosCubiertos(metrosCubiertos);
		propiedad.setNroPartida(nroPartida);
		propiedad.setNumero(numero);
		propiedad.setPropietario(propietario);
		propiedad.setServicios(servicios);
		propiedad.setValorAlquiler(valorAlquiler);
		propiedad.setValorVenta(valorVenta);
		propiedades.addPropiedad(propiedad);
	}
	
	public void grabarPropiedades(List<Propiedad> propiedades){
		// new PropiedadSRV().grabarPropiedad(propiedades);
	}
	
	///////////////
	// SERVICIOS //
	///////////////
	public List<Servicio> getServicios(){
		return servicios.getServicios();
	}
	
	public void addServicio(Propiedad propiedad) {
		Servicio servicio = new Servicio();
		servicio.setPropiedad(propiedad);
		servicios.addServicio(servicio);
	}
	
	public void grabarServicio(List<Servicio> servicios){
		// new ServicioSRV().grabarServicio(servicios);
	}
}
