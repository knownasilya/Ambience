/**
 * 
 */
package g5.ambience.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
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
	private String email;


	

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
	
	private void createUser(String username, String password, String email, String firstName, String lastName, String role){
		try {
			UserEntity user = new UserEntity(username, password, email, firstName, lastName, role);
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} finally {
		}
	}
	
	public String registerUser(){
		createUser(this.username, this.password, this.email, this.firstName, this.lastName, "member");
		return "profile";
	}
	
	public String login(){
		try{
			if(getUserByUsernameAndPassword(this.getUsername(), this.getPassword()) != null){
				if(getUserByUsernameAndPassword(username, password).getRole().equals("admin")){
					return "dashboard";
				} else if(getUserByUsernameAndPassword(username, password).getRole().equals("member")) {
					return "profile";
				}
				
			} else {				
				// Actually this goes off if the username is correct, but the password is not.
				// The message is the same for security reasons.			
				message("Invalid credentials!", "login_btn");
			}
		} catch(NullPointerException e) {
			message("Invalid credentials!", "login_btn");
			e.getMessage();			
		}
		return null;
	}
	
	public void message(String message, String id){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(false);
		
		FacesMessage facesMessage = new FacesMessage(message);
		facesContext.addMessage(id, facesMessage);
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
