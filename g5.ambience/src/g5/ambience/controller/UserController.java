/**
 * 
 */
package g5.ambience.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import g5.ambience.model.UserEntity;


/**
 * @author ilya
 *
 */
public class UserController {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	

	
	@PersistenceContext(unitName="g5.ambience")
	EntityManager em;
	
	FacesContext fc;
	
	FacesMessage fm;
	
	public UserController(){
		if(em == null){
			em = (EntityManager) Persistence.createEntityManagerFactory("g5.ambience").createEntityManager();
		}		
	}
	
	private UserEntity getUserByUsernameAndPassword(String username, String password){		
		try{
			UserEntity user = em.find(UserEntity.class, username);
			if(user.getPasswordHash().equals(password)){
				return user;
			}
		} finally {
		}
		return null;
	}
	
	private void createUser(String username, String password, String email, String firstName, String lastName){
		if (em == null) {
            em = (EntityManager) Persistence.
                      createEntityManagerFactory("g5.ambience").
                      createEntityManager();
        }
		try {
			UserEntity user = new UserEntity(username, password, email, firstName, lastName);
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public void registerUser(){
		
	}
	
	public String login(){
		try{
			if(getUserByUsernameAndPassword(this.getUsername(), this.getPassword()) != null){
				if(getUserByUsernameAndPassword(username, password).getRole().equals("admin")){
					return "dashboard";
				} else if(getUserByUsernameAndPassword(username, password).getRole().equals("member")) {
					return "profile";
				} else {
					return "login";
				}			
			}
			else {
				fm.setSummary("Try Again!");
			}
		} catch(NullPointerException e) {
			e.getMessage();
		}
		return "index";
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
