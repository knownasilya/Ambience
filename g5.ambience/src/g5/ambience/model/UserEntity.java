package g5.ambience.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the UserEntity database table.
 * 
 */
@Entity
@Table(name="UserEntity")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String username;

    @Temporal( TemporalType.DATE)
	@Column(name="cc_expiration")
	private Date ccExpiration;

	@Column(name="cc_name", length=60)
	private String ccName;

	@Column(name="cc_number")
	private int ccNumber;

	@Column(name="cc_security")
	private int ccSecurity;

	@Column(length=45)
	private String city;

    @Temporal( TemporalType.DATE)
	private Date dob;

	@Column(nullable=false, length=60)
	private String email;

	@Column(name="first_name", length=45)
	private String firstName;

	@Column(name="last_name", length=45)
	private String lastName;

	@Column(name="membership_plan", length=45)
	private String membershipPlan;

	@Column(name="password_hash", nullable=false, length=32)
	private String passwordHash;

	@Column(name="profile_image", length=100)
	private String profileImage;

	@Column(length=45)
	private String role;

	@Column(length=45)
	private String state;

	@Column(length=45)
	private String street;

	@Column(name="street_opt", length=45)
	private String streetOpt;

	private int zipcode;

	//bi-directional many-to-one association to BundleEntity
	@OneToMany(mappedBy="userEntity")
	private Set<BundleEntity> bundleEntities;

    public UserEntity() {
    }
    
    public UserEntity(String username, String password, String email, String firstName, String lastName, String role){
    	this.username = username;
    	//Hash the password first
    	this.passwordHash = password;
    	this.email = email;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.role = role;
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCcExpiration() {
		return this.ccExpiration;
	}

	public void setCcExpiration(Date ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcName() {
		return this.ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public int getCcNumber() {
		return this.ccNumber;
	}

	public void setCcNumber(int ccNumber) {
		this.ccNumber = ccNumber;
	}

	public int getCcSecurity() {
		return this.ccSecurity;
	}

	public void setCcSecurity(int ccSecurity) {
		this.ccSecurity = ccSecurity;
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

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMembershipPlan() {
		return this.membershipPlan;
	}

	public void setMembershipPlan(String membershipPlan) {
		this.membershipPlan = membershipPlan;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getProfileImage() {
		return this.profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public Set<BundleEntity> getBundleEntities() {
		return this.bundleEntities;
	}

	public void setBundleEntities(Set<BundleEntity> bundleEntities) {
		this.bundleEntities = bundleEntities;
	}
	
}