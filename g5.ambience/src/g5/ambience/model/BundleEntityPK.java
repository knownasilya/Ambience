package g5.ambience.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BundleEntity database table.
 * 
 */
@Embeddable
public class BundleEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_id", unique=true, nullable=false)
	private int itemId;

    @Temporal( TemporalType.DATE)
	@Column(name="checked_out_date", unique=true, nullable=false)
	private java.util.Date checkedOutDate;

	@Column(unique=true, nullable=false, length=45)
	private String username;

    public BundleEntityPK() {
    }
    
	public int getItemId() {
		return this.itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public java.util.Date getCheckedOutDate() {
		return this.checkedOutDate;
	}
	
	public void setCheckedOutDate(java.util.Date checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BundleEntityPK)) {
			return false;
		}
		BundleEntityPK castOther = (BundleEntityPK)other;
		return 
			(this.itemId == castOther.itemId)
			&& this.checkedOutDate.equals(castOther.checkedOutDate)
			&& this.username.equals(castOther.username);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.checkedOutDate.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
    }
}