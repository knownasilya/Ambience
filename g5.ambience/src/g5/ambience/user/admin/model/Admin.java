/**
 * 
 */
package g5.ambience.user.admin.model;

import javax.persistence.*;

import g5.ambience.item.Item;
import g5.ambience.user.User;
import g5.ambience.user.member.model.Member;

/**
 * @author ilya
 *
 */
@Entity
@Table(name="User")
@DiscriminatorValue("admin")
public class Admin extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4189091368711977599L;
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	
	protected void createItem(){
		Item item = new Item();
		em.persist(item);
	}
	
	public String createMemeber(){
		try {
			Member another = new Member();
			another.setUsername(getUsername());
			another.setEmail(getEmail());
			another.setRole("member");
			em.persist(another);
		} finally {
			em.close();
		}
		
		return "success";
	}
}
