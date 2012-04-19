/**
 * 
 */
package g5.ambience.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 * @author ilya
 *
 */
public class JPAResourceBean {
	@PersistenceUnit
	private EntityManagerFactory emf;

	public EntityManagerFactory getEMF (){
	    if (emf == null){
	        emf = Persistence.createEntityManagerFactory("g5.ambience");
	    }
	    return emf;
	}
}
