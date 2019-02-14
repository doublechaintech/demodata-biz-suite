
package com.test.demodata.formmessage;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class FormMessageManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public FormMessageManagerException(String string) {
		super(string);
	}
	public FormMessageManagerException(Message message) {
		super(message);
	}
	public FormMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


