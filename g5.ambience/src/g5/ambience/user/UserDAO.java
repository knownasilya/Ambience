/**
 * 
 */
package g5.ambience.user;

import java.util.Map;

import g5.ambience.user.model.User;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ilya
 *
 */
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	Map<String,String> params;
	
	FacesContext fc;
	
	
	public boolean valid_user(String username, String pass) {	
		
		try {
			User user = em.find(User.class, username);
			if (user.getPasswordHash().equals(pass) && user.getUsername().equals(username)) {
	        	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
	        	return true;
	        } else {
	        	return false;
	        }
		} catch(NullPointerException e){
			System.out.println(e);
		}
		
		return false;        
    }
	
	public String login(){
		fc = FacesContext.getCurrentInstance();
		params = fc.getExternalContext().getRequestParameterMap();
		if(valid_user(params.get("username"),params.get("email"))){
			return "success";
		} else {
			return "failure";
		}
	}

}
