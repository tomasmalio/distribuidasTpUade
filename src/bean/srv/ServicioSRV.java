package bean.srv;

import java.util.List;
import bean.Servicio;
import bean.dao.HibernateServicioDAO;

public class ServicioSRV {
	private static HibernateServicioDAO dao;
	static {
		dao = HibernateServicioDAO.getInstancia();
	}
	
	public void grabarServicio(List<Servicio> servicios){
		dao.grabarServicio(servicios);
	}
}
