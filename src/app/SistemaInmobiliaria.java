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
	
	public List<Propiedad> getPropiedades(){
		return propiedades.getPropiedades();
	}
}
