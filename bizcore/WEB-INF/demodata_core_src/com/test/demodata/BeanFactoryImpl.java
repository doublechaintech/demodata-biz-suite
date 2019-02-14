
package com.test.demodata;
import java.util.Map;

import com.test.demodata.platform.Platform;
import com.test.demodata.image.Image;
import com.test.demodata.userdomain.UserDomain;
import com.test.demodata.userwhitelist.UserWhiteList;
import com.test.demodata.secuser.SecUser;
import com.test.demodata.secuserblocking.SecUserBlocking;
import com.test.demodata.userapp.UserApp;
import com.test.demodata.listaccess.ListAccess;
import com.test.demodata.objectaccess.ObjectAccess;
import com.test.demodata.loginhistory.LoginHistory;
import com.test.demodata.genericform.GenericForm;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formfieldmessage.FormFieldMessage;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Image createImage(Map<String,Object> options){
		return new Image();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










