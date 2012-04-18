/**
 * 
 */
package g5.ambience.user;

import java.util.Map;

import g5.ambience.user.model.User;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author ilya
 *
 */
public class UserDAO {
	
	@PersistenceUnit
	EntityManagerFactory emf;
	
	EntityManager em = emf.createEntityManager();
	Map<String,String> params;
	
	FacesContext fc;
	
	private String username;
	private String password;
	
	
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
		if(valid_user(username, password)){
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
