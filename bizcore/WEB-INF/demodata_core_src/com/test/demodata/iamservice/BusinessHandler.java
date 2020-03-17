package com.test.demodata.iamservice;

import com.test.demodata.DemodataUserContext;

public interface BusinessHandler {

	void onAuthenticationFailed(DemodataUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateNewUserLogged(DemodataUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateUserLogged(DemodataUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

}







