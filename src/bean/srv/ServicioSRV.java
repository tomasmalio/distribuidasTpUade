package bean.srv;

import java.util.List;

import bean.Alquiler;
import bean.Servicio;
import bean.Venta;
import bean.dao.HibernateServicioDAO;

public class ServicioSRV {
	private static HibernateServicioDAO dao;
	static {
		dao = HibernateServicioDAO.getInstancia();
	}
	
	/*
	public void grabarServicio(List<Servicio> servicios){
		dao.grabarServicio(servicios);
	}
	
	public List<Servicio> listarServicios() {
		return dao.listarServicios();
	}
	
	public void actualizarServicio(Servicio servicio) {
		dao.actualizarServicio(servicio);
	}*/
	
	public void borrarServicio(Servicio servicio) {
		dao.borrarServicio(servicio);
	}

	public void grabarAlquileres(List<Alquiler> servicios) {
		dao.grabarAlquileres(servicios);
	}
	
	public void grabarAlquiler(Alquiler servicios) {
		dao.grabarAlquiler(servicios);
	}

	public void grabarVentas(List<Venta> servicios) {
		dao.grabarVentas(servicios);	
	}
	
	public void grabarVenta(Venta servicios) {
		dao.grabarVenta(servicios);	
	}
}
