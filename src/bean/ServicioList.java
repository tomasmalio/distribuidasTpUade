package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Servicio;

public class ServicioList {
	private List<Servicio> servicios = new ArrayList<Servicio>();

	public List<Servicio> getServicios() {
		return servicios;
	}
	
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void addServicio(Servicio servicio){
		servicios.add(servicio);
	}
	
	public boolean removeServicio(Servicio servicio) {
		return servicios.remove(servicio);
	}
	
//	public Servicio getServicioPorId(int id){
//		for(Servicio u : servicioes){
//			if(u.getId()==id) return u;
//		}
//		return null;
//	}
	
	public int cantidadServicios(){
		return servicios.size();
	}
}
