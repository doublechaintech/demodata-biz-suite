
package com.test.demodata.quicklink;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class QuickLinkManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public QuickLinkManagerException(String string) {
		super(string);
	}
	public QuickLinkManagerException(Message message) {
		super(message);
	}
	public QuickLinkManagerException(List<Message> messageList) {
		super(messageList);
	}

}


