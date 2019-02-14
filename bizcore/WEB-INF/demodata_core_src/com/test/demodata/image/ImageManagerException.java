
package com.test.demodata.image;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class ImageManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public ImageManagerException(String string) {
		super(string);
	}
	public ImageManagerException(Message message) {
		super(message);
	}
	public ImageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


