package com.smartNodeProtocol.core.service.user.repositories.intf;

import com.smartNodeProtocol.core.dao.model.data.user.User;

public interface UserRepository extends Repository<User> {
    User create(User user);

    User update(User user);

    void remove(Long id);

    int getNumberOfUsers();
}
