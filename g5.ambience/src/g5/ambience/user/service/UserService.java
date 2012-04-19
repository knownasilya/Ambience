/**
 * 
 */
package g5.ambience.user.service;

import java.sql.Date;

import g5.ambience.user.model.User;

/**
 * @author ilya
 *
 */
public interface UserService {
	
	public User getUserByUsername(String username);
	
	public void updateUserBasics(String email, String first_name, String last_name);
	
	public void updateUserAddress(String street, String street_opt, String city, char[] state, int zipcode);
	
	public void updateUserBilling(String cc_name, int cc_number, int cc_security, Date cc_expiration );
	
	public void updateUserProfileImage(int image_code);

}
