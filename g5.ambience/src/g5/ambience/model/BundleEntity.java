package g5.ambience.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BundleEntity database table.
 * 
 */
@Entity
@Table(name="BundleEntity")
public class BundleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BundleEntityPK id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="returned_date")
	private Date returnedDate;

	@Column(name="user_rating")
	private int userRating;

	//bi-directional many-to-one association to ItemEntity
    @ManyToOne
	@JoinColumn(name="item_id", nullable=false, insertable=false, updatable=false)
	private ItemEntity itemEntity;

	//bi-directional many-to-one association to UserEntity
    @ManyToOne
	@JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
	private UserEntity userEntity;

    public BundleEntity() {
    }

	public BundleEntityPK getId() {
		return this.id;
	}

	public void setId(BundleEntityPK id) {
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

	public ItemEntity getItemEntity() {
		return this.itemEntity;
	}

	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
}