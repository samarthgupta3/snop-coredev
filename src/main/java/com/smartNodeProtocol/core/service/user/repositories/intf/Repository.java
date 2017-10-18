package com.smartNodeProtocol.core.service.user.repositories.intf;

import java.util.List;

/**
 * Created by Samarth on 06-10-2017.
 */
public interface Repository<T> {

    List<T> getAll();

    T getById(Long id);
}
