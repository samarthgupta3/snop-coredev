package com.smartNodeProtocol.core.dao;

import com.smartNodeProtocol.core.dao.model.DataObject;
import com.smartNodeProtocol.core.visitors.address.DataAddress;

/**
 * Created by Samarth on 18-08-2017.
 */
public interface HibernateDAO {

    <RESULT extends DataAddress> RESULT saveOrUpdate(DataObject dataObject);
}
