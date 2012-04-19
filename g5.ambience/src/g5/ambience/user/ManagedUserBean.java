/**
 * 
 */
package g5.ambience.user;

import java.sql.Date;

import g5.ambience.user.model.User;
import g5.ambience.user.service.UserService;
import g5.ambience.utils.JPAResourceBean;

import javax.persistence.EntityManager;


/**
 * @author ilya
 *
 */
public class ManagedUserBean implements UserService  {
	
    //stores a reference to global EMF for acquiring EM
    protected JPAResourceBean jpaResourceBean;
	
	@Override
	public User getUserByUsername(String username) {	
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		try {
			return em.find(User.class, username);
		} finally {
	        em.close();
	    }     
    }

	@Override
	public void updateUserBasics(String email, String first_name,
			String last_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserAddress(String street, String street_opt,
			String city, char[] state, int zipcode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateUserBilling(String cc_name, int cc_number,
			int cc_security, Date cc_expiration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserProfileImage(int image_code) {
		// TODO Auto-generated method stub
		
	}

}
