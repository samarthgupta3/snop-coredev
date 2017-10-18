package com.smartNodeProtocol.core.dao;

import com.smartNodeProtocol.core.dao.model.DataObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Samarth on 18-08-2017.
 */
public class HibernateQueryImpl implements HibernateQuery {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T extends DataObject> List<T> query(String query) {
        Session session = this.sessionFactory.openSession();
        List<T> personList = session.createQuery(query).list();
        session.close();
        return personList;
    }
}
