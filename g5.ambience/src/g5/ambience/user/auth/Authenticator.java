/**
 * 
 */
package g5.ambience.user.auth;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import g5.ambience.user.User;


/**
 * @author ilya
 *
 */
public class Authenticator {
	
	private User user;
	
	public Authenticator(){
		//Needs to be initialized
	}
	
	public boolean auth(User user){
		boolean result = false;
		@PersistenceContext
		EntityManager em;
		User db_user = em.find(User.class, user.getUsername());
		if(user.equals(db_user)){
			
		}
		return result;
	}
	
}
