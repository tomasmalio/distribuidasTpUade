package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Alquiler;

public class AlquilerList {
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	
	public List<Alquiler> getAlquileres() {
		return alquileres;
	}
	
	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
	public boolean addAlquiler (Alquiler alquiler) {
		return alquileres.add(alquiler);
	}
	
	public boolean removeAlquiler (Alquiler alquiler) {
		return alquileres.remove(alquiler);
	}
	
}