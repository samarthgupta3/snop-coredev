package com.smartNodeProtocol.core.service.user.repositories.impl;

import com.google.common.collect.Ordering;
import com.google.inject.Singleton;
import com.smartNodeProtocol.core.dao.model.data.user.NullUser;
import com.smartNodeProtocol.core.dao.model.data.user.User;
import com.smartNodeProtocol.core.service.user.repositories.impl.mock.GenericMockRepository;
import com.smartNodeProtocol.core.service.user.repositories.intf.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samarth on 06-10-2017.
 */
@Singleton
public class UserRepositoryImpl extends GenericMockRepository<User> implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        this.users = this.createUsers();
    }

    public User getById(Long id) {
        for (User u : this.users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return new NullUser();
    }

    public List<User> getAll() {
        return this.users;
    }

    @Override
    public User create(User user) {
        user.setId(getCurrentMaxId() + 1);
        this.users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        User byId = this.getById(user.getId());
        byId.setFirstName(user.getFirstName());
        byId.setLastName(user.getLastName());
        return byId;
    }

    @Override
    public void remove(Long id) {
        User byId = this.getById(id);
        this.users.remove(byId);
    }

    @Override
    public int getNumberOfUsers() {
        return this.users.size();
    }

    private List<User> createUsers() {
        int numberOfUsers = 10;
        for (long i = 0; i < numberOfUsers; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setFirstName("Foo" + (i + 1));
            user.setLastName("Bar" + (i + 1));
            this.users.add(user);
        }
        return this.users;
    }

    private Long getCurrentMaxId() {
        Ordering<User> ordering = new Ordering<User>() {
            @Override
            public int compare(User left, User right) {
                return Long.compare(left.getId(), right.getId());
            }
        };
        return ordering.max(this.users).getId();
    }
}
