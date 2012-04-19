package g5.ambience.item.model;

import g5.ambience.user.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-04-18T13:43:50.585-0400")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, Integer> itemId;
	public static volatile SingularAttribute<Item, String> developer;
	public static volatile SingularAttribute<Item, String> director;
	public static volatile SingularAttribute<Item, String> esrbRating;
	public static volatile SingularAttribute<Item, String> genre;
	public static volatile SingularAttribute<Item, String> imageUrl;
	public static volatile SingularAttribute<Item, Byte> isOut;
	public static volatile SingularAttribute<Item, String> mpaaRating;
	public static volatile SingularAttribute<Item, String> platform;
	public static volatile SingularAttribute<Item, Integer> referenceNumber;
	public static volatile SingularAttribute<Item, Date> releaseYear;
	public static volatile SingularAttribute<Item, String> synopsis;
	public static volatile SingularAttribute<Item, String> title;
	public static volatile SingularAttribute<Item, String> trailerUrl;
	public static volatile SingularAttribute<Item, String> type;
	public static volatile SingularAttribute<Item, Integer> userRating;
	public static volatile SetAttribute<Item, User> users;
	public static volatile SetAttribute<Item, Member_has_Item> memberHasItems;
}
