package com.mm.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public abstract class BaseModel<T> implements Serializable {

	private static final long serialVersionUID = 3871915083014716963L;

	protected  long id;

	protected String uuid;

	protected boolean isNew = true;

	protected boolean isUpdate = true;

	public abstract void preInsert();

	public abstract void preUpdate();

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean getIsNew() {
		return this.isNew || StringUtils.isBlank(getUuid());
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean getIsUpdate() {
		return this.isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
