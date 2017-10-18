package com.smartNodeProtocol.core.dao.model;

import com.smartNodeProtocol.core.structure.Element;
import com.smartNodeProtocol.core.structure.enums.ElementType;

/**
 * Created by Samarth on 02-08-2017.
 */
public abstract class AbstractBaseElement implements Element {
    private static final long serialVersionUID = 1L;

    protected Long id;
    protected Integer versionNo;

    public AbstractBaseElement() {
        super();
    }

    public AbstractBaseElement(Long id, Integer versionNo) {
        super();
        this.id = id;
        this.versionNo = versionNo;
    }

    public ElementType getElementType() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}
