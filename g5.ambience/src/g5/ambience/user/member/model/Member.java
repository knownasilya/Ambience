/**
 * 
 */
package g5.ambience.user.member.model;
import g5.ambience.user.User;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Ilya Radchenko
 *
 */
@Entity
@DiscriminatorValue("false")
public class Member extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9191451375979026723L;
	private String profile_image;
	private String street;
	private String street_opt;
	private String city;
	private String state;
	private int zipcode;
	private int cc_number;
	private int cc_security;
	private Date cc_expiration; 
	
	/**
	 * @return the username
	 *//*
	public String get_username(){
		return super.get_username();
	}
	
	public void set_username(String username){
		super.set_username(username);
	}
	
	public String get_password(){
		return super.get_password();
	}
	
	public void set_password(String password){
		super.set_password(password);
	}*/
	
	
	
	/**
	 * @return the profile_image
	 */
	public String get_profile_image() {
		return profile_image;
	}
	/**
	 * @param profile_image the profile_image to set
	 */
	public void set_profile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	/**
	 * @return the street
	 */
	public String get_street() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void set_street(String street) {
		this.street = street;
	}
	/**
	 * @return the street_opt
	 */
	public String get_street_opt() {
		return street_opt;
	}
	/**
	 * @param opt_address the opt_address to set
	 */
	public void set_street_opt(String street_opt) {
		this.street_opt = street_opt;
	}
	/**
	 * @return the city
	 */
	public String get_city() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void set_city(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String get_state() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void set_state(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public int get_zipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void set_zipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the cc_number
	 */
	public int get_cc_number() {
		return cc_number;
	}
	/**
	 * @param cc_number the cc_number to set
	 */
	public void set_cc_number(int cc_number) {
		this.cc_number = cc_number;
	}
	/**
	 * @return the cc_security
	 */
	public int get_cc_security() {
		return cc_security;
	}
	/**
	 * @param cc_security the cc_security to set
	 */
	public void set_cc_security(int cc_security) {
		this.cc_security = cc_security;
	}
	/**
	 * @return the cc_expiration
	 */
	public Date get_cc_expiration() {
		return cc_expiration;
	}
	/**
	 * @param cc_expiration the cc_expiration to set
	 */
	public void set_cc_expiration(Date cc_expiration) {
		this.cc_expiration = cc_expiration;
	}	
	
}
