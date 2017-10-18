package com.smartNodeProtocol.core.nodes.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by Samarth on 18-08-2017.
 */
@Entity
@Table(name = "SNP_ORGANISATION")
public class Organisation extends AbstractOrganisation {

    public Organisation() {
        super();
    }

}
