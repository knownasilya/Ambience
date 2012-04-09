/**
 * 
 */
package g5.ambience.user;
import g5.ambience.user.auth.Authenticator;

/**
 * @author ilya
 *
 */
@SuppressWarnings("unused")
public class User {




	private String username;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private int available_login_attempts;
	private int default_login_attempts = 5;
	private Boolean login_blocked;
	
	/**
	 * @param login_attempts
	 */
	public User() {
		super();
		this.available_login_attempts = default_login_attempts;
		this.login_blocked = false;
	}
	

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
	
	public void block_login(){
		if(get_login_attempts() <= 0){
			this.login_blocked = true;
		}
		else {
			this.login_blocked = false;
		}
	}
	
	public String login(){
		if(login_blocked){
			return "login-locked-out";
		} 
		else {
			if(get_username().equals("admin") && get_password().equals("password")){
				reset_login_attempts();
				return "success";
			}
			else {
				dec_login_attempts();
				block_login();
				return "failure";
			}
		}
	}

}
