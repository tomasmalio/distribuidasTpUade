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
	
	/**************************************************************
	 * 						PERSONAS
	 *************************************************************/
	/**
	 * get Personas
	 * 
	 * @return List<Persona>
	 */
	public List<Persona> getPersonas(){
		return personas.getPersonas();
	}
	
	/**
	 * Add Persona
	 * 
	 * @param cuil_cuit
	 * @param nombre_razon
	 * @param domicilio
	 * @param telefono
	 * @param mail
	 * 
	 * @return Persona
	 */
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
	
	/**
	 * Buscar Persona 
	 * 
	 * @param cuit
	 * @return Persona
	 */
	public Persona buscarPersona(String cuit){
	    return personas.getPersonaPorCuit(cuit);
	}
	
	/**
	 * Grabar Personas
	 * 
	 * @param void
	 */
	public void grabarPersonas(List<Persona> personas){
	    new PersonaSRV().grabarPersona(personas);
	}
	
	/**************************************************************
	 * 						PROPIEDADES
	 *************************************************************/
	/**
	 * get Propiedades
	 * 
	 * @return List<Propiedad>
	 */
	public List<Propiedad> getPropiedades(){
		return propiedades.getPropiedades();
	}
	
	/**
	 * add Propiedad
	 * 
	 * @param nroPartida
	 * @param calle
	 * @param numero
	 * @param piso
	 * @param departamento
	 * @param ciudad
	 * @param cantAmb
	 * @param metrosCubiertos
	 * @param valorAlquiler
	 * @param valorVenta
	 * @param impuestos
	 * @param servicios
	 * @param expensas
	 * @param propietario
	 */
	public void addPropiedad (String nroPartida, String calle, int numero, String piso, String departamento, String ciudad, String cantAmb,  float metrosCubiertos,  float valorAlquiler,  float valorVenta, float impuestos, float servicios, float expensas, Persona propietario) {
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
	
	/**
	 * grabar Propiedades
	 * 
	 * @param propiedades
	 */
	public void grabarPropiedades(List<Propiedad> propiedades){
		new PropiedadSRV().grabarPropiedad(propiedades);
	}
	
	/**
	 * buscar Propiedad
	 * 
	 * @param nroPartida
	 * @return Propiedad
	 */
	public Propiedad buscarPropiedad(String nroPartida) {
		return propiedades.getPropiedadPorNroPartida(nroPartida);
	}
	
	/**************************************************************
	 * 						SERVICIOS
	 * 					ALQUILERES | VENTA
	 *************************************************************/
	/**
	 * get Servicios
	 * 
	 * @return List<Servicio>
	 */
	public List<Servicio> getServicios(){
		return servicios.getServicios();
	}
	
	/**
	 * add Servicio
	 * 
	 * @param fecha
	 * @param propiedad
	 * @param interesado
	 */
	public void addServicio(Date fecha, Propiedad propiedad, Persona interesado) {
		Servicio servicio = new Servicio();
		servicio.setFecha(fecha);
		servicio.setPropiedad(propiedad);
		servicio.setInteresado(interesado);
		servicios.addServicio(servicio);
	}
	
	/**
	 * grabar Alquileres
	 * 
	 * @param servicios
	 */
	public void grabarAlquileres(List<Alquiler> servicios) {
		new ServicioSRV().grabarAlquileres(servicios);
	}
	
	/**
	 * grabar Alquiler
	 * 
	 * @param servicio
	 */
	public void grabarAlquiler(Alquiler servicio) {
		new ServicioSRV().grabarAlquiler(servicio);
	}
	
	/**
	 * borrar Servicio
	 * 
	 * @param alquiler
	 */
	public void borrarServicio (Alquiler alquiler) {
		new ServicioSRV().borrarServicio(alquiler);
	}
	
	/**
	 * grabar Ventas
	 * 
	 * @param servicios
	 */
	public void grabarVentas(List<Venta> servicios) {
		new ServicioSRV().grabarVentas(servicios);
	}
	
	/**
	 * grabar Venta
	 * 
	 * @param servicio
	 */
	public void grabarVenta(Venta servicio) {
		new ServicioSRV().grabarVenta(servicio);
	}
	
	/**
	 * Borrar Servicio
	 * 
	 * @param venta
	 */
	public void borrarServicio (Venta venta) {
		new ServicioSRV().borrarServicio(venta);
	}

	/**
	 * add Alquiler
	 * 
	 * @param fechaDesde
	 * @param fechaHasta
	 * @param comisionGestion
	 * @param gastosSellado
	 * @param fecha
	 * @param propiedad
	 * @param interesado
	 * 
	 * @return Alquiler
	 */
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

	/**
	 * add Venta
	 * 
	 * @param fechaEscritura
	 * @param valorEscritura
	 * @param comisionVenta
	 * @param gastosEscritura
	 * @param fecha
	 * @param propiedad
	 * @param interesado
	 * 
	 * @return Venta
	 */
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
	 * delete Service
	 * 
	 * @param alquiler
	 */
	public void deleteService(Alquiler alquiler) {
		alquileres.removeAlquiler(alquiler);
		borrarServicio(alquiler);
	}
	
	/**
	 * delete Service for Venta
	 * 
	 * @param venta
	 */
	public void deleteService(Venta venta) {
		ventas.removeVenta(venta);
		borrarServicio(venta);
	}

	/**
	 * get Alquileres
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
	 * get Ventas
	 * 
	 * Listado de propiedades que están en venta
	 * 
	 * @return List<Venta>
	 */
	public List<Venta> getVentas() {
		return ventas.getVentas();
	}
}
