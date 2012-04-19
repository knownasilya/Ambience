package g5.ambience.item.model;

import g5.ambience.user.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-04-18T13:43:50.595-0400")
@StaticMetamodel(Member_has_Item.class)
public class Member_has_Item_ {
	public static volatile SingularAttribute<Member_has_Item, Member_has_ItemPK> id;
	public static volatile SingularAttribute<Member_has_Item, Date> returnedDate;
	public static volatile SingularAttribute<Member_has_Item, Integer> userRating;
	public static volatile SingularAttribute<Member_has_Item, Item> item;
	public static volatile SingularAttribute<Member_has_Item, User> user;
}
