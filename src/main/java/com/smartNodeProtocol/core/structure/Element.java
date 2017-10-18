package com.smartNodeProtocol.core.structure;

import com.smartNodeProtocol.core.dao.model.DataObject;
import com.smartNodeProtocol.core.structure.enums.ElementType;
import com.smartNodeProtocol.core.visitors.ElementVisitor;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface Element extends DataObject {

    <RESULT, DATA> RESULT accept(ElementVisitor<RESULT, DATA> visitor, DATA data);

    ElementType getElementType();

    Node getOwnerNode();
}
