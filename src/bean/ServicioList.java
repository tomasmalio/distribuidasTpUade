package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Servicio;

public class ServicioList {
	private List<Servicio> servicioes = new ArrayList<Servicio>();

	public List<Servicio> getServicios() {
		return servicioes;
	}
	
	public void setServicios(List<Servicio> servicioes) {
		this.servicioes = servicioes;
	}
	
	public void addServicio(Servicio servicio){
		servicioes.add(servicio);
	}
	
	public boolean removeServicio(Servicio servicio) {
		return servicioes.remove(servicio);
	}
	
//	public Servicio getServicioPorId(int id){
//		for(Servicio u : servicioes){
//			if(u.getId()==id) return u;
//		}
//		return null;
//	}
	
	public int cantidadServicios(){
		return servicioes.size();
	}
}
