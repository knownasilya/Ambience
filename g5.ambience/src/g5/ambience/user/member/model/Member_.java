package g5.ambience.user.member.model;

import g5.ambience.user.model.User_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-04-18T14:23:22.971-0400")
@StaticMetamodel(Member.class)
public class Member_ extends User_ {
	public static volatile SingularAttribute<Member, Date> ccExpiration;
	public static volatile SingularAttribute<Member, String> ccName;
	public static volatile SingularAttribute<Member, Integer> ccNumber;
	public static volatile SingularAttribute<Member, Integer> ccSecurity;
	public static volatile SingularAttribute<Member, String> profileImage;
	public static volatile SingularAttribute<Member, String> membershipPlan;
}
