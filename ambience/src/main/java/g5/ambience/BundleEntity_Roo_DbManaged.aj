// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package g5.ambience;

import g5.ambience.BundleEntity;
import g5.ambience.ItemEntity;
import g5.ambience.UserEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect BundleEntity_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", nullable = false, insertable = false, updatable = false)
    private ItemEntity BundleEntity.itemId;
    
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
    private UserEntity BundleEntity.username;
    
    @Column(name = "user_rating")
    private Integer BundleEntity.userRating;
    
    @Column(name = "returned_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date BundleEntity.returnedDate;
    
    public ItemEntity BundleEntity.getItemId() {
        return itemId;
    }
    
    public void BundleEntity.setItemId(ItemEntity itemId) {
        this.itemId = itemId;
    }
    
    public UserEntity BundleEntity.getUsername() {
        return username;
    }
    
    public void BundleEntity.setUsername(UserEntity username) {
        this.username = username;
    }
    
    public Integer BundleEntity.getUserRating() {
        return userRating;
    }
    
    public void BundleEntity.setUserRating(Integer userRating) {
        this.userRating = userRating;
    }
    
    public Date BundleEntity.getReturnedDate() {
        return returnedDate;
    }
    
    public void BundleEntity.setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
    
}
