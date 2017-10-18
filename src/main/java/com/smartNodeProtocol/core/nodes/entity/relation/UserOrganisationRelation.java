package com.smartNodeProtocol.core.nodes.entity.relation;

import com.smartNodeProtocol.core.nodes.entity.AbstractOrganisation;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;

import javax.persistence.*;

/**
 * Created by Samarth on 06-10-2017.
 */
@Entity
@Table(name = "SNP_USER_ORGANISATION_REL")
@AssociationOverrides({
        @AssociationOverride(name = "user",
                joinColumns = @JoinColumn(name = "USER_ID")),
        @AssociationOverride(name = "organisation",
                joinColumns = @JoinColumn(name = "ORGANISATION_ID"))})
public class UserOrganisationRelation {
    private AbstractUser user;
    private AbstractOrganisation organisation;
    private String role;


}
