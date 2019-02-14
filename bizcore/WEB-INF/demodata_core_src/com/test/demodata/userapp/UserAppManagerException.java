
package com.test.demodata.userapp;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class UserAppManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public UserAppManagerException(String string) {
		super(string);
	}
	public UserAppManagerException(Message message) {
		super(message);
	}
	public UserAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


