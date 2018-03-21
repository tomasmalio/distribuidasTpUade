package app;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import bean.Alquiler;
import bean.AlquilerList;
import bean.Persona;
import bean.PersonaList;
import bean.Propiedad;
import bean.PropiedadList;
import bean.Servicio;
import bean.ServicioList;
import bean.Venta;
import bean.VentaList;
import bean.srv.PersonaSRV;
import bean.srv.PropiedadSRV;
import bean.srv.ServicioSRV;

public class SistemaInmobiliaria {
	
	private static SistemaInmobiliaria instance = null;
	private PersonaList personas 				= new PersonaList();
	private PropiedadList propiedades 			= new PropiedadList();
	private ServicioList servicios 				= new ServicioList();
	private AlquilerList alquileres				= new AlquilerList();
	private VentaList ventas					= new VentaList();
	
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
	
	public Persona addPersona(String cuil_cuit, String nombre_razon, String domicilio, String telefono, String mail) {
		Persona persona = new Persona();
		persona.setCuil_cuit(cuil_cuit);
		persona.setNombre_razon(nombre_razon);
		persona.setDomicilio(domicilio);
		persona.setTelefono(telefono);
		persona.setMail(mail);
		personas.addPersona(persona);
		return persona;
	}
	
	public Persona buscarPersona(String cuit){
	    return personas.getPersonaPorCuit(cuit);
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
	
	public void addPropiedad(String calle, Persona propietario) {
		Propiedad propiedad = new Propiedad();
		propiedad.setCalle(calle);
		propiedad.setCiudad("asd");
		propiedad.setCantidadAmbientes("2");
		propiedad.setDepartamento("asd");
		propiedad.setExpensas(1);
		propiedad.setImpuestos(1);
		propiedad.setPiso("a");
		propiedad.setMetrosCubiertos(1);
		propiedad.setNroPartida("asd");
		propiedad.setNumero(1);
		propiedad.setPropietario(propietario);
		propiedad.setServicios(1);
		propiedad.setValorAlquiler(1);
		propiedad.setValorVenta(10);
		propiedades.addPropiedad(propiedad);
	}
	
	public void addPropiedad (String nroPartida, 
							String calle, 
							int numero, 
							String piso,
							String departamento,
							String ciudad, 
							String cantAmb, 
							float metrosCubiertos, 
							float valorAlquiler, 
							float valorVenta,
							float impuestos,
							float servicios,
							float expensas, 
							Persona propietario
							) {
		Propiedad propiedad = new Propiedad();
		propiedad.setNroPartida(nroPartida);
		propiedad.setCalle(calle);
		propiedad.setNumero(numero);
		propiedad.setPiso(piso);
		propiedad.setDepartamento(departamento);
		propiedad.setCiudad(ciudad);
		propiedad.setCantidadAmbientes(cantAmb);
		propiedad.setMetrosCubiertos(metrosCubiertos);
		propiedad.setValorAlquiler(valorAlquiler);
		propiedad.setValorVenta(valorVenta);
		propiedad.setImpuestos(impuestos);
		propiedad.setServicios(servicios);
		propiedad.setExpensas(expensas);
		propiedad.setPropietario(propietario);
		propiedades.addPropiedad(propiedad);
	}
	
	public void grabarPropiedades(List<Propiedad> propiedades){
		new PropiedadSRV().grabarPropiedad(propiedades);
	}
	
	public Propiedad buscarPropiedad(String nroPartida) {
		return propiedades.getPropiedadPorNroPartida(nroPartida);
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
	
	public void grabarAlquileres(List<Alquiler> servicios) {
		new ServicioSRV().grabarAlquileres(servicios);
	}
	
	public void grabarAlquiler(Alquiler servicio) {
		new ServicioSRV().grabarAlquiler(servicio);
	}
	
	public void borrarServicio (Alquiler alquiler) {
		new ServicioSRV().borrarServicio(alquiler);
	}
	
	public void grabarVentas(List<Venta> servicios) {
		new ServicioSRV().grabarVentas(servicios);
	}
	
	public void grabarVenta(Venta servicio) {
		new ServicioSRV().grabarVenta(servicio);
	}
	
	public void borrarServicio (Venta venta) {
		new ServicioSRV().borrarServicio(venta);
	}

	public Alquiler addAlquiler(Date fechaDesde, Date fechaHasta, float comisionGestion, float gastosSellado, Date fecha, Propiedad propiedad,
			Persona interesado) {
		Alquiler alquiler = new Alquiler();
		alquiler.setFechaDesde(fechaDesde);
		alquiler.setFechaHasta(fechaHasta);
		alquiler.setComisionGestion(comisionGestion);
		alquiler.setGastosSellado(gastosSellado);
		alquiler.setFecha(fecha);
		alquiler.setPropiedad(propiedad);
		alquiler.setInteresado(interesado);
		alquileres.addAlquiler(alquiler);
		return alquiler;
	}

	public Venta addVenta(Date fechaEscritura, float valorEscritura, float comisionVenta, float gastosEscritura, Date fecha,
			Propiedad propiedad, Persona interesado) {
		Venta servicio = new Venta();
		servicio.setFechaEscritura(fechaEscritura);
		servicio.setValorEscritura(valorEscritura);
		servicio.setComisionVenta(comisionVenta);
		servicio.setGastosEscritura(gastosEscritura);
		servicio.setFecha(fecha);
		servicio.setPropiedad(propiedad);
		servicio.setInteresado(interesado);
		ventas.addVenta(servicio);
		return servicio;
	}

	/**
	 * Delete Service for Alquiler
	 * 
	 * @param alquiler
	 */
	public void deleteService(Alquiler alquiler) {
		alquileres.removeAlquiler(alquiler);
		borrarServicio(alquiler);
	}
	
	/**
	 * Delete Service for Venta
	 * 
	 * @param venta
	 */
	public void deleteService(Venta venta) {
		ventas.removeVenta(venta);
		borrarServicio(venta);
	}

	/**
	 * getAlquileres
	 * 
	 * Listado de propiedades
	 * que están alquiladas
	 * 
	 * @return List<Alquiler>
	 */
	public List<Alquiler> getAlquileres() {
		return alquileres.getAlquileres();
	}

	/**
	 * getVentas
	 * 
	 * Listado de propiedades que están en venta
	 * 
	 * @return List<Venta>
	 */
	public List<Venta> getVentas() {
		return ventas.getVentas();
	}
	
	/**
	 * Modifiy Service for Venta
	 * @param venta
	 */
	public void editService(Venta venta) {
		
	}
}
