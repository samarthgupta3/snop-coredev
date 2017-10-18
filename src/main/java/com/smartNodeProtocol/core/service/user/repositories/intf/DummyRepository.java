package com.smartNodeProtocol.core.service.user.repositories.intf;

import com.smartNodeProtocol.core.dao.model.data.user.User;

/**
 * Created by Samarth on 06-10-2017.
 */
public interface DummyRepository extends Repository<User> {
    User getDefaultUser();
}
