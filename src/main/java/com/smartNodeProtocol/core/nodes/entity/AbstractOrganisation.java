package com.smartNodeProtocol.core.nodes.entity;

import com.smartNodeProtocol.core.dao.model.PersistenceParam;
import com.smartNodeProtocol.core.nodes.AbstractBaseNode;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;
import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.NodeVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.Set;


/**
 * Created by Samarth on 06-10-2017.
 */
@MappedSuperclass
public abstract class AbstractOrganisation extends AbstractBaseNode {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @OneToMany
    private Set<AbstractUser> members;

    public <RESULT, DATA> RESULT accept(NodeVisitor<RESULT, DATA> visitor, DATA data) {
        return visitor.visitOrganisation(this,data);
    }

    public DataAddress accept(DataObjectVisitor visitor, PersistenceParam persistenceParam) {
        return visitor.visitOrganisation(this,persistenceParam);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Set<AbstractUser> getMembers() {
        return members;
    }

    public void setMembers(Set<AbstractUser> members) {
        this.members = members;
    }
}
