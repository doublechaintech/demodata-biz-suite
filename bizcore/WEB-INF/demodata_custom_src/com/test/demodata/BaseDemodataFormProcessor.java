package com.test.demodata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseDemodataFormProcessor extends BaseFormProcessor{
	protected DemodataUserContext userContext;
	
	public DemodataUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(DemodataUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(DemodataException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(DemodataUserContext userContext) {
		return null; 
	}
}























