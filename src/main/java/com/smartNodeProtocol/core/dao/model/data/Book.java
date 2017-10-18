package com.smartNodeProtocol.core.dao.model.data;

import com.smartNodeProtocol.core.dao.model.AbstractBaseElement;
import com.smartNodeProtocol.core.dao.model.DataObject;
import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.ElementVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

/**
 * Created by Samarth on 02-08-2017.
 */
public abstract class Book extends AbstractBaseElement implements DataObject {

    public <RESULT, DATA> RESULT accept(ElementVisitor<RESULT, DATA> visitor, DATA data) {
        return visitor.visitBook(this, data);
    }

    public <DATA> DataAddress accept(DataObjectVisitor dataVisitor, DATA dataParam) {
        return dataVisitor.visitBook(this, dataParam);
    }
}
