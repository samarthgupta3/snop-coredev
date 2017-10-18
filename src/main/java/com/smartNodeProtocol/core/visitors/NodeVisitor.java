package com.smartNodeProtocol.core.visitors;

import com.smartNodeProtocol.core.nodes.entity.AbstractOrganisation;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface NodeVisitor <RESULT,DATA>{

    RESULT visitUser(AbstractUser abstractUser, DATA data);

    RESULT visitOrganisation(AbstractOrganisation abstractEntity, DATA data);
}
