package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Propiedad;

public class PropiedadList {
	private List<Propiedad> propiedads = new ArrayList<Propiedad>();

	public List<Propiedad> getPropiedads() {
		return propiedads;
	}
	
	public void setPropiedads(List<Propiedad> propiedads) {
		this.propiedads = propiedads;
	}
	
	public void addPropiedad(Propiedad propiedad){
		propiedads.add(propiedad);
	}
	
	public boolean removePropiedad(Propiedad propiedad) {
		return propiedads.remove(propiedad);
	}
	
//	public Propiedad getPropiedadPorId(int id){
//		for(Propiedad u : propiedads){
//			if(u.getId()==id) return u;
//		}
//		return null;
//	}
	
	public int cantidadPropiedads(){
		return propiedads.size();
	}
}
