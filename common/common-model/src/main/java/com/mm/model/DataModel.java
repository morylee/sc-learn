package com.mm.model;

import com.mm.base.util.GeneratorUtil;

import java.util.Date;

public class DataModel<T> extends BaseModel<T> {

	private static final long serialVersionUID = -8810902239803383726L;
	protected Date createdAt;

	protected Date updatedAt;

	protected int state;

	public DataModel() {
		super();
		this.state = State.Enable.getCode();
	}

	@Override
	public void preInsert() {
		if (getIsNew()) {
			setUuid(GeneratorUtil.uuid());
		}
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@Override
	public void preUpdate() {
		if (getIsUpdate()) {
			this.updatedAt = new Date();
		}
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
