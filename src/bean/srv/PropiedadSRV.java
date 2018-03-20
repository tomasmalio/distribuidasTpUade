package bean.srv;

import java.util.List;
import bean.Propiedad;
import bean.dao.HibernatePropiedadDAO;

public class PropiedadSRV {
	private static HibernatePropiedadDAO dao;
	static {
		dao = HibernatePropiedadDAO.getInstancia();
	}
	
	public void grabarPropiedad(List<Propiedad> propiedades){
		dao.grabarPropiedades(propiedades);
	}
}
