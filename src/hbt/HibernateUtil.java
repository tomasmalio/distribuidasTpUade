package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Alquiler;
import bean.Persona;
import bean.Propiedad;
import bean.Servicio;
import bean.Venta;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 	Configuration config = new Configuration();
        	 	config.addAnnotatedClass(Propiedad.class);
    	 		config.addAnnotatedClass(Persona.class);
    	 		config.addAnnotatedClass(Servicio.class);
    	 		config.addAnnotatedClass(Alquiler.class);
    	 		config.addAnnotatedClass(Venta.class);
            sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
