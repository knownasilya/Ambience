package g5.ambience.user.model;

import g5.ambience.item.model.Item;
import g5.ambience.item.model.Member_has_Item;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role",discriminatorType=DiscriminatorType.INTEGER,columnDefinition="role")
@DiscriminatorValue("user")
@Table(name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=45)
	private String username;

	@Column(length=45)
	private String city;

    @Temporal( TemporalType.DATE)
	private Date dob;

	@Column(nullable=false, length=60)
	private String email;

	@Column(name="first_name", length=45)
	private String firstName;

	@Column(name="role", nullable=false)
	private String role;

	@Column(name="last_name", length=45)
	private String lastName;

	@Column(name="password_hash", nullable=false, length=32)
	private String passwordHash;

	@Column(length=45)
	private String state;

	@Column(length=45)
	private String street;

	@Column(name="street_opt", length=45)
	private String streetOpt;

	private int zipcode;

	//bi-directional many-to-many association to Item
	@ManyToMany(mappedBy="users")
	private Set<Item> items;

	//bi-directional many-to-one association to Member_has_Item
	@OneToMany(mappedBy="user")
	private Set<Member_has_Item> bundles;

    public User() {
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetOpt() {
		return this.streetOpt;
	}

	public void setStreetOpt(String streetOpt) {
		this.streetOpt = streetOpt;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * Adds an item to a purchase bundle when a user chooses it through the interface. 
	 * 
	 * @param item
	 * @return void
	 */
	public void addToBundle(Item item){
		this.items.add(item);
	}
	
	public Set<Member_has_Item> getAllBundles() {
		return this.bundles;
	}

	public void addBundles(Set<Member_has_Item> bundles) {
		this.bundles = bundles;
	}
	
	/**
	 * This returns the user's bundle
	 * 
	 * @return Set<Item>
	 */
	public Set<Item> getBundle() {
		return this.items;
	}

	
	/**
	 * Removes an item from the purchase bundle when the user chooses it from the bundle interface
	 * 
	 * @param item
	 * @return void
	 */
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	public void remove_from_bundle(Item item){
		if(this.items.contains(item)){
			this.items.remove(item);
		}
	}
	
	public boolean is_registered(String username, String pass) {	
		
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
		if(is_registered(username, passwordHash)){
			return "success";
		} else {
			return "failure";
		}
	}
}