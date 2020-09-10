package com.mm.mq.model;

public enum MsgType {

	/**
	 * 添加小组成员
	 */
	TeamMemberAdd("sys-team-member-add"),
	/**
	 * 删除小组成员
	 */
	TeamMemberRemove("sys-team-member-rm"),
	/**
	 * 添加用户
	 */
	UserAdd("email-user-add"),
	/**
	 * 重置用户密码
	 */
	UserResetPwd("email-user-reset-pwd"),
	/**
	 * 用户修改密码
	 */
	UserUpdatePwd("email-user-update-pwd"),
	/**
	 * 用户找回密码
	 */
	UserFindPwd("email-user-find-pwd"),
	/**
	 * 迭代通知
	 */
	IterationNotify("email-iteration-notify"),
	/**
	 * 任务通知
	 */
	TaskNotify("email-task-notify");

	private String name;

	MsgType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
