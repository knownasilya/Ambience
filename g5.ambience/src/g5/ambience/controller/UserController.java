/**
 * 
 */
package g5.ambience.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import g5.ambience.model.BundleEntity;
import g5.ambience.model.BundleEntityPK;
import g5.ambience.model.ItemEntity;
import g5.ambience.model.UserEntity;
import g5.ambience.util.Auth;


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
	private Set<BundleEntity> bundleEntities;
	private boolean isLoggedIn;
	@ManagedProperty(value="#{itemController}")
	private ItemController itemController;
	private ItemEntity item;


	

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

			String hash = Auth.hash_password(password);
		
			
			if(user.getPasswordHash().equals(hash)){
				return user;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
	}
	
	private void createUser(String username, String password, String email, String firstName, String lastName, String role){
		try {
			String hash = null;
			
			hash = Auth.hash_password(password);
			 
			UserEntity user = new UserEntity(username, hash, email, firstName, lastName, role);
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally {
		}
	}
	
	public String registerUser(){
		createUser(this.username, this.password, this.email, this.firstName, this.lastName, "member");
		return "profile";
	}
	
	public String login(){
		try{
			if(getUserByUsernameAndPassword(this.getUsername(), this.getPassword()) != null){
				setLoggedIn(true);
				if(getUserByUsernameAndPassword(username, password).getRole().equals("admin")){
					return "dashboard";
				} else if(getUserByUsernameAndPassword(username, password).getRole().equals("member")) {
					return "index"; //just for testing, should be profile
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
	
	public void addItemToBundle(ItemEntity item){
		try {
			em.getTransaction().begin();
			UserEntity user = em.find(UserEntity.class, username);
			BundleEntity bundle = new BundleEntity();
			BundleEntityPK compositePk = new BundleEntityPK();
			compositePk.setCheckedOutDate(new Date());
			compositePk.setItemId(item.getItemId());
			compositePk.setUsername(username);
			bundle.setId(compositePk);
			Set<BundleEntity> bundles = null;
			bundles.add(bundle);
			user.setBundleEntities(bundles);		
			em.persist(bundle);
			em.merge(user);
			em.getTransaction().commit();
		} finally {
		}
	}
	

	public String addToBundle(){		
		try {
			addItemToBundle(item);
		} catch (NullPointerException e) {
			e.getMessage();
		}
		
		return null;
	}
	
	public Set<BundleEntity> findUsersBundles(String username){
		TypedQuery<BundleEntity> query = em.createQuery("SELECT x FROM UserEntity o, BundleEntity x WHERE o.username = :username AND o.username = x.username", BundleEntity.class);
		query.setParameter("username", username);
		return (Set<BundleEntity>)query.getResultList();
	}
	
	
	public void message(String message, String id){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(false);
		
		FacesMessage facesMessage = new FacesMessage(message);
		facesContext.addMessage(id, facesMessage);
	}
	
	public String profile(){
		return "profile";
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


	/**
	 * @return the bundleEntities
	 */
	public Set<BundleEntity> getBundleEntities() {
		return bundleEntities = findUsersBundles(username);
	}


	/**
	 * @param bundleEntities the bundleEntities to set
	 */
	public void setBundleEntities(Set<BundleEntity> bundleEntities) {
		this.bundleEntities = bundleEntities;
	}


	/**
	 * @return the isLoggedIn
	 */
	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	/**
	 * @param isLoggedIn the isLoggedIn to set
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	/**
	 * @return the itemController
	 */
	public ItemController getItemController() {
		return itemController;
	}


	/**
	 * @param itemController the itemController to set
	 */
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}


	/**
	 * @return the item
	 */
	public ItemEntity getItem() {
		return item;
	}


	/**
	 * @param item the item to set
	 */
	public void setItem(ItemEntity item) {
		this.item = item;
	}

}
