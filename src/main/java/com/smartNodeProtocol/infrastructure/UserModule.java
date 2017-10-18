package com.smartNodeProtocol.infrastructure;

import com.google.inject.AbstractModule;
import com.smartNodeProtocol.core.service.user.repositories.impl.UserRepositoryImpl;
import com.smartNodeProtocol.core.service.user.repositories.intf.DummyRepository;
import com.smartNodeProtocol.core.service.user.repositories.intf.UserRepository;
import com.smartNodeProtocol.core.service.user.repositories.impl.mock.DummyMockRepositoryImpl;
import com.smartNodeProtocol.core.service.user.intf.DummyService;
import com.smartNodeProtocol.core.service.user.intf.UserManagementService;
import com.smartNodeProtocol.core.service.user.impl.DummyServiceImpl;
import com.smartNodeProtocol.core.service.user.impl.UserManagementManagementServiceImpl;

public class UserModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DummyRepository.class).to(DummyMockRepositoryImpl.class);
        bind(DummyService.class).to(DummyServiceImpl.class);

        bind(UserRepository.class).to(UserRepositoryImpl.class);
        bind(UserManagementService.class).to(UserManagementManagementServiceImpl.class);
    }
}
