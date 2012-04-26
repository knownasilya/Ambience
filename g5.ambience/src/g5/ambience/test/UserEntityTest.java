/**
 * 
 */
package g5.ambience.test;

import static org.junit.Assert.*;
import g5.ambience.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ilya
 *
 */
public class UserEntityTest {
	
	private static EntityManager em = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (em == null) {
            em = (EntityManager) Persistence.
                      createEntityManagerFactory("g5.ambience").
                      createEntityManager();
        }
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		     
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		   
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#UserEntity()}.
	 */
	@Test
	public void testUserEntity() {	
		em.getTransaction().begin();
        UserEntity user = new UserEntity();
        user.setUsername("user");
        user.setPasswordHash("pass");
        user.setEmail("email@");        
        em.persist(user);
        em.flush();
        em.getTransaction().commit(); 
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#UserEntity(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserEntityStringStringStringStringString() {
		em.getTransaction().begin();
		UserEntity user = new UserEntity("admin","password","email","first","last");
        em.persist(user);
        em.flush();
        em.getTransaction().commit();
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getUsername()}.
	 */
	@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setUsername(java.lang.String)}.
	 */
	@Test
	public void testSetUsername() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getCcExpiration()}.
	 */
	@Test
	public void testGetCcExpiration() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setCcExpiration(java.util.Date)}.
	 */
	@Test
	public void testSetCcExpiration() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getCcName()}.
	 */
	@Test
	public void testGetCcName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setCcName(java.lang.String)}.
	 */
	@Test
	public void testSetCcName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getCcNumber()}.
	 */
	@Test
	public void testGetCcNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setCcNumber(int)}.
	 */
	@Test
	public void testSetCcNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getCcSecurity()}.
	 */
	@Test
	public void testGetCcSecurity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setCcSecurity(int)}.
	 */
	@Test
	public void testSetCcSecurity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getCity()}.
	 */
	@Test
	public void testGetCity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setCity(java.lang.String)}.
	 */
	@Test
	public void testSetCity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getDob()}.
	 */
	@Test
	public void testGetDob() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setDob(java.util.Date)}.
	 */
	@Test
	public void testSetDob() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getMembershipPlan()}.
	 */
	@Test
	public void testGetMembershipPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setMembershipPlan(java.lang.String)}.
	 */
	@Test
	public void testSetMembershipPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getPasswordHash()}.
	 */
	@Test
	public void testGetPasswordHash() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setPasswordHash(java.lang.String)}.
	 */
	@Test
	public void testSetPasswordHash() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getProfileImage()}.
	 */
	@Test
	public void testGetProfileImage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setProfileImage(java.lang.String)}.
	 */
	@Test
	public void testSetProfileImage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getRole()}.
	 */
	@Test
	public void testGetRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setRole(java.lang.String)}.
	 */
	@Test
	public void testSetRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getState()}.
	 */
	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setState(java.lang.String)}.
	 */
	@Test
	public void testSetState() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getStreet()}.
	 */
	@Test
	public void testGetStreet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setStreet(java.lang.String)}.
	 */
	@Test
	public void testSetStreet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getStreetOpt()}.
	 */
	@Test
	public void testGetStreetOpt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setStreetOpt(java.lang.String)}.
	 */
	@Test
	public void testSetStreetOpt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getZipcode()}.
	 */
	@Test
	public void testGetZipcode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setZipcode(int)}.
	 */
	@Test
	public void testSetZipcode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#getBundleEntities()}.
	 */
	@Test
	public void testGetBundleEntities() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link g5.ambience.model.UserEntity#setBundleEntities(java.util.Set)}.
	 */
	@Test
	public void testSetBundleEntities() {
		fail("Not yet implemented");
	}

}
