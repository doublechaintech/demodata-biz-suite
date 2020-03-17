
package com.test.demodata.wechatminiappidentify;
//import com.test.demodata.EntityNotFoundException;
import com.test.demodata.DemodataException;
import com.test.demodata.Message;
import java.util.List;

public class WechatMiniappIdentifyManagerException extends DemodataException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


