package com.smartNodeProtocol.core.dao.model.data.user;

import com.smartNodeProtocol.core.dao.model.PersistenceParam;
import com.smartNodeProtocol.core.nodes.AbstractBaseNode;
import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.NodeVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

import javax.persistence.*;

/**
 * Created by Samarth on 02-08-2017.
 */
@Entity
@Table(name = "SNP_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractUser extends AbstractBaseNode {

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Column(name = "LOGIN_ID")
    protected String loginId;

    @Column(name = "PASSWORD")
    protected String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public <RESULT, DATA> RESULT accept(NodeVisitor<RESULT, DATA> visitor, DATA data) {
        return visitor.visitUser(this, data);
    }

    public DataAddress accept(DataObjectVisitor visitor, PersistenceParam persistenceParam) {
        return visitor.visitUser(this, persistenceParam);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
