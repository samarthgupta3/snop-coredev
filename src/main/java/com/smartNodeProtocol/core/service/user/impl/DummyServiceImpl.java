package com.smartNodeProtocol.core.service.user.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.smartNodeProtocol.core.dao.model.data.user.User;
import com.smartNodeProtocol.core.service.user.repositories.intf.DummyRepository;
import com.smartNodeProtocol.core.service.user.intf.DummyService;

@Singleton
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dummyRepository;

    @Inject
    public DummyServiceImpl(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    @Override
    public User getDefaultUser() {
        Object defaultUser = this.dummyRepository.getDefaultUser();
        return this.dummyRepository.getDefaultUser();
    }

}
