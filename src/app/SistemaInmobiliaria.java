package app;

import java.time.LocalDate;
import java.util.List;

import bean.Persona;
import bean.PersonaList;
import bean.Propiedad;
import bean.PropiedadList;

public class SistemaInmobiliaria {
	private PersonaList personas = new PersonaList();
	private PropiedadList propiedades = new PropiedadList();
	
	public float calcularComisiones(LocalDate fechaDesde, LocalDate fechaHasta ) {
		return 1;
	}

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
	
	public List<Propiedad> getPropiedades(){
		return propiedades.getPropiedades();
	}
	
	public void addPropiedad(String calle) {
		Propiedad propiedad = new Propiedad();
		propiedad.setCalle(calle);
		propiedades.addPropiedad(propiedad);
	}
	
	public void grabarPropiedades(List<Propiedad> propiedades){
		// new PropiedadSRV().grabarPropiedad(propiedades);
	}
}
