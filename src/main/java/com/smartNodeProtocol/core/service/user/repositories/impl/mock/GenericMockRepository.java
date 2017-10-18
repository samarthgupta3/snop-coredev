package com.smartNodeProtocol.core.service.user.repositories.impl.mock;

import com.smartNodeProtocol.core.service.user.repositories.intf.Repository;

import java.util.List;
/**
 * Created by Samarth on 06-10-2017.
 */
public abstract class GenericMockRepository<T> implements Repository<T> {

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T getById(Long id) {
        return (T) null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
