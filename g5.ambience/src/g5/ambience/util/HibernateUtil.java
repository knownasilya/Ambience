/**
 * 
 */
package g5.ambience.util;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * @author ilya
 *
 */
@SuppressWarnings("unused")
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    
	    configuration.configure();
	    
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	    return sessionFactory;
	}
}
