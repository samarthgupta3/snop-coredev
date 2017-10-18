package com.smartNodeProtocol.core.dao.model.data.user;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "SNP_USER_TYPE_BASIC")
@PrimaryKeyJoinColumn(name = "ID")
public class User extends AbstractUser {



}
