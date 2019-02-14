package com.test.demodata;

import java.util.HashMap;
import java.util.Map;

import com.test.demodata.platform.Platform;
import com.test.demodata.platform.PlatformDAO;
import com.test.demodata.platform.PlatformTokens;
import com.test.demodata.image.Image;
import com.test.demodata.image.ImageDAO;
import com.test.demodata.image.ImageTokens;
import com.test.demodata.userdomain.UserDomain;
import com.test.demodata.userdomain.UserDomainDAO;
import com.test.demodata.userdomain.UserDomainTokens;
import com.test.demodata.userwhitelist.UserWhiteList;
import com.test.demodata.userwhitelist.UserWhiteListDAO;
import com.test.demodata.userwhitelist.UserWhiteListTokens;
import com.test.demodata.secuser.SecUser;
import com.test.demodata.secuser.SecUserDAO;
import com.test.demodata.secuser.SecUserTokens;
import com.test.demodata.secuserblocking.SecUserBlocking;
import com.test.demodata.secuserblocking.SecUserBlockingDAO;
import com.test.demodata.secuserblocking.SecUserBlockingTokens;
import com.test.demodata.userapp.UserApp;
import com.test.demodata.userapp.UserAppDAO;
import com.test.demodata.userapp.UserAppTokens;
import com.test.demodata.listaccess.ListAccess;
import com.test.demodata.listaccess.ListAccessDAO;
import com.test.demodata.listaccess.ListAccessTokens;
import com.test.demodata.objectaccess.ObjectAccess;
import com.test.demodata.objectaccess.ObjectAccessDAO;
import com.test.demodata.objectaccess.ObjectAccessTokens;
import com.test.demodata.loginhistory.LoginHistory;
import com.test.demodata.loginhistory.LoginHistoryDAO;
import com.test.demodata.loginhistory.LoginHistoryTokens;
import com.test.demodata.genericform.GenericForm;
import com.test.demodata.genericform.GenericFormDAO;
import com.test.demodata.genericform.GenericFormTokens;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formmessage.FormMessageDAO;
import com.test.demodata.formmessage.FormMessageTokens;
import com.test.demodata.formfieldmessage.FormFieldMessage;
import com.test.demodata.formfieldmessage.FormFieldMessageDAO;
import com.test.demodata.formfieldmessage.FormFieldMessageTokens;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formfield.FormFieldDAO;
import com.test.demodata.formfield.FormFieldTokens;
import com.test.demodata.formaction.FormAction;
import com.test.demodata.formaction.FormActionDAO;
import com.test.demodata.formaction.FormActionTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected ImageDAO imageDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public ImageDAO getImageDAO(){
		return this.imageDAO;
	}
	public void setImageDAO(ImageDAO dao){
		this.imageDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("Image", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getImageDAO().load(id, ImageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getImageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getImageDAO().present((Image)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}

