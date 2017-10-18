package com.smartNodeProtocol.core.visitors;

import com.smartNodeProtocol.core.dao.model.data.Location;
import com.smartNodeProtocol.core.dao.model.PersistenceParam;
import com.smartNodeProtocol.core.nodes.entity.AbstractOrganisation;
import com.smartNodeProtocol.core.visitors.address.DataAddress;
import com.smartNodeProtocol.core.dao.model.data.Book;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface DataObjectVisitor <RESULT,DATA> {

    DataAddress visitBook(Book book, DATA dataParam);

    DataAddress visitUser(AbstractUser abstractUser, DATA dataParam);

    DataAddress visitOrganisation(AbstractOrganisation abstractEntity, PersistenceParam persistenceParam);

    DataAddress visitLocation(Location location, PersistenceParam persistenceParam);

}
