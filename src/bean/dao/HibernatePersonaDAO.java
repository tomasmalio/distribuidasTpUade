package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Persona;

public class HibernatePersonaDAO {
	private static HibernatePersonaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernatePersonaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernatePersonaDAO();
		} 
		return instancia;
	}
	
	public void grabarPersonas(List<Persona> personas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Persona persona:personas)
			session.saveOrUpdate(persona);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
