/**
 * 
 */
package g5.ambience.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ilya
 *
 */
public class JPAFactory {
	private EntityManagerFactory emf;
	
	public JPAFactory() {
		emf = Persistence.createEntityManagerFactory(
			      "jdbc://localhost:3306/Ambience;user=root;password=password");
	}
	
	public EntityManagerFactory getEMF(){
		return emf;
	}

}
