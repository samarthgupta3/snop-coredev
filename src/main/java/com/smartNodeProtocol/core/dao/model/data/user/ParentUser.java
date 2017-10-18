package com.smartNodeProtocol.core.dao.model.data.user;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Samarth on 18-08-2017.
 */
@Entity
@Table(name = "SNP_USER_TYPE_PARENT")
@PrimaryKeyJoinColumn(name = "ID")
@XmlRootElement
public class ParentUser extends AbstractUser {

    @ManyToMany(mappedBy = "parents", cascade = CascadeType.ALL)
    protected Set<ChildUser> children = new HashSet<ChildUser>();

    @Override
    public String toString() {
        return "id=" + id + "version=" + version + ", name=" + firstName + ", loginId=" + loginId + super.toString();
    }

    public Set<ChildUser> getChildren() {
        return children;
    }

    public void setChildren(Set<ChildUser> children) {
        this.children = children;
    }
}
