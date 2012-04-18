/**
 * 
 */
package g5.ambience.user.member.model;

import g5.ambience.user.model.User;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Ilya Radchenko
 *
 */
@Entity
@Table(name="User")
@DiscriminatorValue("member")
public class Member extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9191451375979026723L;

    @Temporal( TemporalType.DATE)
	@Column(name="cc_expiration")
	private Date ccExpiration;

	@Column(name="cc_name", length=60)
	private String ccName;

	@Column(name="cc_number")
	private int ccNumber;

	@Column(name="cc_security")
	private int ccSecurity;
	
	@Column(name="profile_image", length=100)
	private String profileImage;
	
	@Column(name="membership_plan", length=45)
	private String membershipPlan;
	
	
	public String getProfileImage() {
		return this.profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	/**
	 * @return the cc_number
	 */
	public int getCc_number() {
		return ccNumber;
	}
	/**
	 * @param cc_number the cc_number to set
	 */
	public void setCc_number(int cc_number) {
		this.ccNumber = cc_number;
	}
	/**
	 * @return the cc_security
	 */
	public int getCc_security() {
		return ccSecurity;
	}
	/**
	 * @param cc_security the cc_security to set
	 */
	public void setCc_security(int cc_security) {
		this.ccSecurity = cc_security;
	}
	/**
	 * @return the cc_expiration
	 */
	public Date getCc_expiration() {
		return ccExpiration;
	}
	/**
	 * @param cc_expiration the cc_expiration to set
	 */
	public void setCc_expiration(Date cc_expiration) {
		this.ccExpiration = cc_expiration;
	} 
	
	public String getCcName() {
		return this.ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	
	public String getMembershipPlan() {
		return this.membershipPlan;
	}

	public void setMembershipPlan(String membershipPlan) {
		this.membershipPlan = membershipPlan;
	}
	
	
}
