package com.smartNodeProtocol.core.structure;

import com.smartNodeProtocol.core.dao.model.DataObject;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Samarth on 18-08-2017.
 */
@MappedSuperclass
public abstract class AbstractDataObject implements DataObject {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    @Version
    @Column(name="Version")
    protected Integer version;

    @Column(name = "CREATED")
    private Date created = new Date();

    @Column(name = "CREATED_BY")
    private String createdBy = "System";

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated = new Date();

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy = "System";


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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
