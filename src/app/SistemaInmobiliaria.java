package app;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import bean.Persona;
import bean.PersonaList;
import bean.Propiedad;
import bean.PropiedadList;
import bean.Servicio;
import bean.ServicioList;
import bean.srv.PersonaSRV;
import bean.srv.PropiedadSRV;
import bean.srv.ServicioSRV;

public class SistemaInmobiliaria {
	private static SistemaInmobiliaria instance = null;
	private PersonaList personas = new PersonaList();
	private PropiedadList propiedades = new PropiedadList();
	private ServicioList servicios = new ServicioList();
	
	public static SistemaInmobiliaria getInstance() {
        if (instance == null) {
            instance = new SistemaInmobiliaria();
        }
        return instance;
    }
	
	public float calcularComisiones(LocalDate fechaDesde, LocalDate fechaHasta ) {
		return 1;
	}
	//////////////
	// PERSONAS //
	//////////////
	public List<Persona> getPersonas(){
		return personas.getPersonas();
	}
	
	public void addPersona(String cuil_cuit, String nombre_razon) {
		Persona persona = new Persona();
		persona.setCuil_cuit(cuil_cuit);
		persona.setNombre_razon(nombre_razon);
		personas.addPersona(persona);
	}
	
	public void grabarPersonas(List<Persona> personas){
	    new PersonaSRV().grabarPersona(personas);
	}
	
	/////////////////
	// PROPIEDADES //
	/////////////////
	public List<Propiedad> getPropiedades(){
		return propiedades.getPropiedades();
	}
	
	public void addPropiedad(String calle) {
		Propiedad propiedad = new Propiedad();
		propiedad.setCalle(calle);
		propiedad.setCiudad("asd");
		propiedad.setCantidadAmbientes("2");
		propiedad.setDepartamento("asd");
		propiedad.setExpensas(1);
		propiedad.setImpuestos(1);
		propiedad.setMetrosCubiertos(1);
		propiedad.setNroPartida("asd");
		propiedad.setNumero(1);
		// propiedad.setPropietario(null);
		propiedad.setServicios(1);
		propiedad.setValorAlquiler(1);
		propiedad.setValorVenta(10);
		propiedades.addPropiedad(propiedad);
	}
	
	public void addPropiedad(String calle, String ciudad, String cantAmb, String departamento, 
	  float expensas, float impuestos, float metrosCubiertos, String nroPartida, int numero,
	  Persona propietario, float servicios, float valorAlquiler, float valorVenta) {
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
		// propiedad.setPropietario(propietario);
		propiedad.setServicios(servicios);
		propiedad.setValorAlquiler(valorAlquiler);
		propiedad.setValorVenta(valorVenta);
		propiedades.addPropiedad(propiedad);
	}
	
	public void grabarPropiedades(List<Propiedad> propiedades){
		new PropiedadSRV().grabarPropiedad(propiedades);
	}
	
	///////////////
	// SERVICIOS //
	///////////////
	public List<Servicio> getServicios(){
		return servicios.getServicios();
	}
	
	public void addServicio(Date fecha, Propiedad propiedad, Persona interesado) {
		Servicio servicio = new Servicio();
		servicio.setFecha(fecha);
		servicio.setPropiedad(propiedad);
		servicio.setInteresado(interesado);
		servicios.addServicio(servicio);
	}
	
	public void grabarServicio(List<Servicio> servicios){
		new ServicioSRV().grabarServicio(servicios);
	}
}
