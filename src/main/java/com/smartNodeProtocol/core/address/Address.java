package com.smartNodeProtocol.core.address;

import com.smartNodeProtocol.core.visitors.AddressVisitor;

import java.io.Serializable;

public abstract class Address implements Serializable {

	private static final long serialVersionUID = 1l;
	protected final Long id;
	protected Integer versionNo;

	public Address(Long id, Integer versionNo) {
		this.id = id;
		this.versionNo = versionNo;
	}


	public Long getId() {
		return id;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void resetVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Address that = (Address)obj;
		boolean isIdEq = id==null? that.getId()==null: id.equals(that.getId());
		Integer thatVerNo = that.getVersionNo();
		boolean isVersionEq;
		if (versionNo != null) {
			isVersionEq = versionNo.equals(thatVerNo);
		} else {
			isVersionEq = thatVerNo == null ? true : false;
		}
		return isIdEq && isVersionEq;
	}

	public abstract <RESULT, DATA> RESULT accept(AddressVisitor<RESULT, DATA> visitor, DATA data);

}
