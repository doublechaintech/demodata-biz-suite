
package com.test.demodata.secuser;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class SecUserManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public SecUserManagerException(String string) {
		super(string);
	}
	public SecUserManagerException(Message message) {
		super(message);
	}
	public SecUserManagerException(List<Message> messageList) {
		super(messageList);
	}

}


