package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Propiedad;

public class HibernatePropiedadDAO {
	private static HibernatePropiedadDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernatePropiedadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernatePropiedadDAO();
		} 
		return instancia;
	}
	
	public void grabarPropiedades(List<Propiedad> propiedades){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Propiedad propiedad:propiedades)
			session.saveOrUpdate(propiedad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
