package bean.srv;

import java.util.List;

import bean.Alquiler;
import bean.Venta;
import bean.dao.HibernateServicioDAO;

public class ServicioSRV {
	private static HibernateServicioDAO dao;
	static {
		dao = HibernateServicioDAO.getInstancia();
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
	
	public void borrarServicio (Alquiler alquiler) {
		dao.borrarServicio(alquiler);
	}
	
	public void borrarServicio (Venta venta) {
		dao.borrarServicio(venta);
	}
}
