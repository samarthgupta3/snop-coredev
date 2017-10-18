package com.smartNodeProtocol.core.service.user.intf;

import com.smartNodeProtocol.core.dao.model.data.user.User;

import java.util.List;

/**
 * Created by Samarth on 06-10-2017.
 */
public interface UserManagementService {

    List<User> getAllUsers();

    User getById(Long id);

    User createNewUser(User user);

    User update(User user);

    void remove(Long id);

    int getNumberOfUsers();
}
