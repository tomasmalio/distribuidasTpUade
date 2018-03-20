package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Servicio;

public class HibernateServicioDAO {
	private static HibernateServicioDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateServicioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateServicioDAO();
		} 
		return instancia;
	}
	
	public void grabarServicio(List<Servicio> servicios){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Servicio servicio:servicios)
			session.persist(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
