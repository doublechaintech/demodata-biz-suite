
package com.test.demodata.userapp;
import com.test.demodata.EntityNotFoundException;

public class UserAppVersionChangedException extends UserAppManagerException {
	private static final long serialVersionUID = 1L;
	public UserAppVersionChangedException(String string) {
		super(string);
	}


}


