package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Alquiler;
import bean.Servicio;
import bean.Venta;

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
	
	public void borrarServicio (Servicio servicio){
		Session session = sf.openSession();
		session.beginTransaction();
		session.remove(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void grabarAlquileres(List<Alquiler> servicios) {
		Session session = sf.openSession();
		session.beginTransaction();
		for(Alquiler servicio:servicios)
			session.saveOrUpdate(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void grabarAlquiler(Alquiler servicio) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void grabarVentas(List<Venta> servicios) {
		Session session = sf.openSession();
		session.beginTransaction();
		for(Venta servicio:servicios)
			session.saveOrUpdate(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void grabarVenta(Venta servicio) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(servicio);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
