package com.smartNodeProtocol.core.service.user.repositories.impl.mock;

import com.smartNodeProtocol.core.dao.model.data.user.User;
import com.smartNodeProtocol.core.service.user.repositories.intf.DummyRepository;

/**
 * Created by Samarth on 06-10-2017.
 */
public class DummyMockRepositoryImpl extends GenericMockRepository<User> implements DummyRepository {

    @Override
    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("JonFromREST");
        user.setLastName("DoeFromREST");
        return user;
    }
}
