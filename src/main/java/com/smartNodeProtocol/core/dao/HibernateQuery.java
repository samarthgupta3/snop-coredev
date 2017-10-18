package com.smartNodeProtocol.core.dao;

import com.smartNodeProtocol.core.dao.model.DataObject;

import java.util.List;

/**
 * Created by Samarth on 18-08-2017.
 */
public interface HibernateQuery {

    <T extends DataObject> List<T> query(String query);
}
