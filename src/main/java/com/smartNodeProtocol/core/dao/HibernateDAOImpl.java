package com.smartNodeProtocol.core.dao;

import com.smartNodeProtocol.core.dao.model.data.Location;
import com.smartNodeProtocol.core.dao.model.DataObject;
import com.smartNodeProtocol.core.dao.model.PersistenceParam;
import com.smartNodeProtocol.core.nodes.entity.AbstractOrganisation;
import com.smartNodeProtocol.core.visitors.DataObjectVisitor;
import com.smartNodeProtocol.core.visitors.address.DataAddress;
import com.smartNodeProtocol.core.dao.model.data.Book;
import com.smartNodeProtocol.core.dao.model.data.user.AbstractUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Samarth on 18-08-2017.
 */
public class HibernateDAOImpl implements HibernateDAO, DataObjectVisitor<DataAddress, PersistenceParam> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DataAddress saveOrUpdate(DataObject dataObject) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        setCommonFields(dataObject);
        session.saveOrUpdate(dataObject);
        tx.commit();
        session.close();
        return new DataAddress(dataObject.getId(), dataObject.getVersion());
    }

    private void setCommonFields(DataObject dataObject) {
        dataObject.setLastUpdated(new Date());
    }

    public DataAddress visitBook(Book book, PersistenceParam dataParam) {
        return saveOrUpdate(book);
    }

    public DataAddress visitUser(AbstractUser abstractUser, PersistenceParam dataParam) {
        return saveOrUpdate(abstractUser);
    }

    public DataAddress visitOrganisation(AbstractOrganisation abstractOrganisation, PersistenceParam persistenceParam) {
        return saveOrUpdate(abstractOrganisation);
    }

    public DataAddress visitLocation(Location location, PersistenceParam persistenceParam) {
        return saveOrUpdate(location);
    }
}
