package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Propiedad;

public class PropiedadList {
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	
	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
	
	public void addPropiedad(Propiedad propiedad){
		propiedades.add(propiedad);
	}
	
	public boolean removePropiedad(Propiedad propiedad) {
		return propiedades.remove(propiedad);
	}
	
	public Propiedad getPropiedadPorNroPartida(String nroPartida) {
		for(Propiedad p : propiedades){
			if (p.getNroPartida().equals(nroPartida)) return p;
		}
		return null;
	}
	
	public int cantidadPropiedades(){
		return propiedades.size();
	}
}
