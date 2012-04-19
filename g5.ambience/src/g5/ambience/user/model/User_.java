package g5.ambience.user.model;

import g5.ambience.item.model.Item;
import g5.ambience.item.model.Member_has_Item;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-04-18T13:43:50.603-0400")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> city;
	public static volatile SingularAttribute<User, Date> dob;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> passwordHash;
	public static volatile SingularAttribute<User, String> state;
	public static volatile SingularAttribute<User, String> street;
	public static volatile SingularAttribute<User, String> streetOpt;
	public static volatile SingularAttribute<User, Integer> zipcode;
	public static volatile SetAttribute<User, Item> items;
	public static volatile SetAttribute<User, Member_has_Item> bundles;
}
