// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package g5.ambience;

import g5.ambience.BundleEntity;
import g5.ambience.BundleEntityPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect BundleEntity_Roo_Jpa_Entity {
    
    declare @type: BundleEntity: @Entity;
    
    declare @type: BundleEntity: @Table(name = "BundleEntity");
    
    @EmbeddedId
    private BundleEntityPK BundleEntity.id;
    
    public BundleEntityPK BundleEntity.getId() {
        return this.id;
    }
    
    public void BundleEntity.setId(BundleEntityPK id) {
        this.id = id;
    }
    
}
