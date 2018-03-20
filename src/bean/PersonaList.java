package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Persona;

public class PersonaList {
	private List<Persona> personas = new ArrayList<Persona>();

	public List<Persona> getPersonas() {
		return personas;
	}
	
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public void addPersona(Persona persona){
		personas.add(persona);
	}
	
	public boolean removePersona(Persona persona) {
		return personas.remove(persona);
	}
	
	public Persona getPersonaPorId(String id){
		for(Persona persona : personas){
			if(persona.getCuil_cuit().equals(id)) return persona;
		}
		return null;
	}
	
	public Persona getPersonaPorNombre(String nombre){
		for(Persona u : personas){
			if(u.getNombre().equals(nombre)) return u;
		}
		return null;
	}
	
	public int cantidadPersonas(){
		return personas.size();
	}
}
