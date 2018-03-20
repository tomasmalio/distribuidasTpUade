package bean.srv;

import java.util.List;
import bean.Persona;
import bean.dao.HibernatePersonaDAO;

public class PersonaSRV {
	private static HibernatePersonaDAO dao;
	static {
		dao = HibernatePersonaDAO.getInstancia();
	}
	
	public void grabarPersona(List<Persona> Usuarios){
		dao.grabarPersonas(Usuarios);
	}
}
