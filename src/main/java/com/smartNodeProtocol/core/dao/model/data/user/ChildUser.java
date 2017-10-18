package com.smartNodeProtocol.core.dao.model.data.user;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by Samarth on 18-08-2017.
 */
@Entity
@Table(name = "SNP_USER_TYPE_CHILD")
@PrimaryKeyJoinColumn(name="ID")
@XmlRootElement
public class ChildUser extends AbstractUser {

    @ManyToMany
    protected Set<ParentUser> parents;

    @Override
    public String toString() {
        return "id=" + id + "version=" + version + ", name=" + firstName + ", loginId=" + loginId + super.toString();
    }

    public Set<ParentUser> getParents() {
        return parents;
    }

    public void setParents(Set<ParentUser> parents) {
        this.parents = parents;
    }
}
