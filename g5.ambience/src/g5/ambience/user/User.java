/**
 * 
 */
package g5.ambience.user;

/**
 * @author ilya
 *
 */
public class User {


	private String username;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	
	
	

	/**
	 * @return the username
	 */
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

}
