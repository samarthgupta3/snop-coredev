package com.smartNodeProtocol.core.visitors.address;

/**
 * Created by Samarth on 18-08-2017.
 */
public class DataAddress {
    Long id;
    Integer version;

    public DataAddress(Long id, Integer version) {
        this.id = id;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
