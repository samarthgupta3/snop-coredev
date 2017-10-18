package com.smartNodeProtocol.core.service.integrity.nodeElement;

import com.smartNodeProtocol.core.nodes.entity.AbstractOrganisation;
import com.smartNodeProtocol.core.structure.Element;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;

import java.util.Collection;

/**
 * Created by Samarth on 02-08-2017.
 */
public class NodeElementLinkImpl implements NodeElementLink {

    public Collection<Element> visitUser(AbstractUser abstractUser, NodeElementParam param) {
        return null;
    }

    public Collection<Element> visitOrganisation(AbstractOrganisation abstractEntity, NodeElementParam nodeElementParam) {
        return null;
    }
}
