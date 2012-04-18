package g5.ambience.item.model;

import g5.ambience.user.model.User;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Member_has_Item database table.
 * 
 */
@Entity
@Table(name="Member_has_Item")
public class Member_has_Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Member_has_ItemPK id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="returned_date")
	private Date returnedDate;

	@Column(name="user_rating")
	private int userRating;

	//bi-directional many-to-one association to Item
    @ManyToOne
	@JoinColumn(name="item_id", nullable=false, insertable=false, updatable=false)
	private Item item;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
	private User user;

    public Member_has_Item() {
    }

	public Member_has_ItemPK getId() {
		return this.id;
	}

	public void setId(Member_has_ItemPK id) {
		this.id = id;
	}
	
	public Date getReturnedDate() {
		return this.returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public int getUserRating() {
		return this.userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}