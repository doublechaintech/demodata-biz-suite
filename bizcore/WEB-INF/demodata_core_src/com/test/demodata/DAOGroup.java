package com.test.demodata;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

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
import com.test.demodata.userapp.UserApp;
import com.test.demodata.userapp.UserAppDAO;
import com.test.demodata.userapp.UserAppTokens;
import com.test.demodata.quicklink.QuickLink;
import com.test.demodata.quicklink.QuickLinkDAO;
import com.test.demodata.quicklink.QuickLinkTokens;
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
import com.test.demodata.candidatecontainer.CandidateContainer;
import com.test.demodata.candidatecontainer.CandidateContainerDAO;
import com.test.demodata.candidatecontainer.CandidateContainerTokens;
import com.test.demodata.candidateelement.CandidateElement;
import com.test.demodata.candidateelement.CandidateElementDAO;
import com.test.demodata.candidateelement.CandidateElementTokens;
import com.test.demodata.wechatworkappidentify.WechatWorkappIdentify;
import com.test.demodata.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.test.demodata.wechatworkappidentify.WechatWorkappIdentifyTokens;
import com.test.demodata.wechatminiappidentify.WechatMiniappIdentify;
import com.test.demodata.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.test.demodata.wechatminiappidentify.WechatMiniappIdentifyTokens;
import com.test.demodata.treenode.TreeNode;
import com.test.demodata.treenode.TreeNodeDAO;
import com.test.demodata.treenode.TreeNodeTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected ImageDAO imageDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	protected WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO;

	protected WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO;

	protected TreeNodeDAO treeNodeDAO;



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


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
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


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO(){
		return this.wechatWorkappIdentifyDAO;
	}
	public void setWechatWorkappIdentifyDAO(WechatWorkappIdentifyDAO dao){
		this.wechatWorkappIdentifyDAO = dao;
	}


	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO(){
		return this.wechatMiniappIdentifyDAO;
	}
	public void setWechatMiniappIdentifyDAO(WechatMiniappIdentifyDAO dao){
		this.wechatMiniappIdentifyDAO = dao;
	}


	public TreeNodeDAO getTreeNodeDAO(){
		return this.treeNodeDAO;
	}
	public void setTreeNodeDAO(TreeNodeDAO dao){
		this.treeNodeDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> list) throws Exception;
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
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPlatformDAO().enhanceList((List<Platform>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)Platform.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Image", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getImageDAO().load(id, ImageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getImageDAO().enhanceList((List<Image>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getImageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getImageDAO().present((Image)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)Image.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)UserDomain.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserWhiteListDAO().enhanceList((List<UserWhiteList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)UserWhiteList.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)SecUser.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)UserApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)QuickLink.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)ListAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getObjectAccessDAO().enhanceList((List<ObjectAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)ObjectAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)LoginHistory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGenericFormDAO().enhanceList((List<GenericForm>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)GenericForm.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormMessageDAO().enhanceList((List<FormMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)FormMessage.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldMessageDAO().enhanceList((List<FormFieldMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)FormFieldMessage.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldDAO().enhanceList((List<FormField>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)FormField.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormActionDAO().enhanceList((List<FormAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)FormAction.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)CandidateContainer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)CandidateElement.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatWorkappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, WechatWorkappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatWorkappIdentifyDAO().enhanceList((List<WechatWorkappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().present((WechatWorkappIdentify)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)WechatWorkappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatMiniappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, WechatMiniappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatMiniappIdentifyDAO().enhanceList((List<WechatMiniappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().present((WechatMiniappIdentify)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)WechatMiniappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TreeNode", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, TreeNodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTreeNodeDAO().enhanceList((List<TreeNode>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().present((TreeNode)data, tokens);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
        return ids.stream().map(id-> (BaseEntity)TreeNode.withId(id)).collect(Collectors.toList());
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

	public List<BaseEntity> wrapperList(String type, List<String> ids){
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return null;
  	    }
  	    try{
  	    	return loader.wrapperList(this, ids);
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
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}

	public void enhanceList(List list, String type) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return ;
  	    }

  	    loader.enhanceList(this, list);
  	}
}

