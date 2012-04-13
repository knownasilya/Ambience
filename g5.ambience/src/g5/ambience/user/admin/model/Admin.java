/**
 * 
 */
package g5.ambience.user.admin.model;

import javax.persistence.*;

import g5.ambience.user.User;

/**
 * @author ilya
 *
 */
@Entity
@DiscriminatorValue("true")
public class Admin extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4189091368711977599L;
	private boolean is_admin;

	/**
	 * 
	 */
	public Admin() {
		super();
	}

	/**
	 * @return the is_admin
	 */
	public boolean get_is_admin() {
		return is_admin;
	}

	/**
	 * @param is_admin the is_admin to set
	 */
	public void set_is_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

}
