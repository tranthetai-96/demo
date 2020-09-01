package util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				
			  //Create sessionfactory from file hibernate.cfg.xml
				sessionFactory = new Configuration()
									.configure()
									.buildSessionFactory();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
