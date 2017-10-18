package com.smartNodeProtocol.core.dao.model;

import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Samarth on 18-08-2017.
 */
public interface DataObject extends Serializable {

    DataAddress accept(DataObjectVisitor visitor, PersistenceParam persistenceParam);

    Long getId();

    Integer getVersion();

    Date getCreated();

    void setCreated(Date created);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getLastUpdated();

    void setLastUpdated(Date lastUpdated);

    String getLastUpdatedBy();

    void setLastUpdatedBy(String lastUpdatedBy);
}
