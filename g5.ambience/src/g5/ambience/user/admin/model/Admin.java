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
@Table(name="User")
@DiscriminatorValue("true")
public class Admin extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4189091368711977599L;

	/**
	 * 
	 */
	public Admin() {
		super();
	}
}
