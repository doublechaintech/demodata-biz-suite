package com.test.demodata;

public class CustomDemodataUserContextImpl extends DemodataBizUserContextImpl{
	protected BaseEntity currentUserInfo;

	public BaseEntity getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(BaseEntity currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}

