package com.smartNodeProtocol.core.dao.model.data;

import com.smartNodeProtocol.core.dao.model.PersistenceParam;
import com.smartNodeProtocol.core.structure.AbstractDataObject;
import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

/**
 * Created by Samarth on 06-10-2017.
 */
public class Location extends AbstractDataObject {

    protected Double lat;
    protected Double lon;
    protected String label;

    public DataAddress accept(DataObjectVisitor visitor, PersistenceParam persistenceParam) {
        return visitor.visitLocation(this, persistenceParam);
    }
}
