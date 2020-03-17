package com.test.demodata.iamservice;

import com.test.demodata.DemodataUserContext;

public interface IdentificationHandler {

	/** 完成认证 */
	LoginResult authenticate(DemodataUserContext userContext, LoginContext loginContext);
	/** 绑定用户 */
	void bindWithSecUser(DemodataUserContext userContext, LoginContext loginContext) throws Exception;
}







