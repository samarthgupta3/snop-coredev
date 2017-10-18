package com.smartNodeProtocol.core.service.user.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.smartNodeProtocol.core.dao.model.data.user.User;
import com.smartNodeProtocol.core.service.user.repositories.intf.UserRepository;
import com.smartNodeProtocol.core.service.user.intf.UserManagementService;

import java.util.List;
/**
 * Created by Samarth on 06-10-2017.
 */
@Singleton
public class UserManagementManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;

    @Inject
    public UserManagementManagementServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List getAllUsers() {
        return this.userRepository.getAll();
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User createNewUser(User user) {
        User u = this.userRepository.create(user);
        return u;
    }

    @Override
    public User update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public void remove(Long id) {
        this.userRepository.remove(id);
    }

    @Override
    public int getNumberOfUsers() {
        return this.userRepository.getNumberOfUsers();
    }
}
