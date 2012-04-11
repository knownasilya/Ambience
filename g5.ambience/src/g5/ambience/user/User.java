/**
 * 
 */
package g5.ambience.user;


import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Index;

/**
 * @author ilya
 *
 */
@DynamicUpdate
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6072515475403687595L;
	private String username;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private int default_login_attempts = 5;
	private int available_login_attempts;
	
	
	/**
	 * The default User constructor takes no parameters but only initializes the available
	 * login attempts that every user has by default. The default is stored in the
	 * default_login_attempts and is usually 5.
	 */	
	public User(){
		available_login_attempts = default_login_attempts;
	}

	/**
	 * A simple getter method for the username of a {@link User} which can be either 
	 * a {@link Member} or {@link Admin}. This getter returns a unique String object. 
	 * 
	 * @return username	a case-sensitive {@url String} which is unique across the whole system.
	 * @see Member
	 * @see Admin
	 * @see User
	 */
	@Index(name = "username")
	public String get_username() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void set_username(String username) {
		this.username = username;
	}
	/**
	 * @return the first_name
	 */
	public String get_first_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void set_first_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String get_last_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void set_last_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email
	 */
	public String get_email() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void set_email(String email) {
		this.email = email;
	}
	/**
	 * @param password the password to set
	 */
	public void set_password(String password) {
		this.password = password;
	}	
	
	/**
	 * @return the password
	 */
	public String get_password() {
		return password;
	}
	
	public void reset_login_attempts(){
		this.available_login_attempts = default_login_attempts;
	}
	
	/**
	 * @return the login_attempts
	 */
	public int get_login_attempts() {
		return available_login_attempts;
	}

	/**
	 * @param login_attempts the login_attempts to set
	 */
	public void dec_login_attempts() {
		this.available_login_attempts -= 1;
	}

	/**
	 * A simple login function for testing functionality. This function can be used by
	 * the {@link Memeber} or {@link Admin} classes and currently only allows the following
	 * user/password: Admin/password
	 * 
	 * @return success or failure	the return value of this function tells the system which page to render.
	 */
	public String login(){
		if(get_username().equals("admin") && get_password().equals("password")){
			reset_login_attempts();
			return "success";
		}
		else {
			dec_login_attempts();			
			return "failure";
		}
	}


}
