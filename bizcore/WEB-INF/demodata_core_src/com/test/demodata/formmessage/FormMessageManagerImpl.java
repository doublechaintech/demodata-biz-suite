
package com.test.demodata.formmessage;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;

import com.test.demodata.*;
import com.test.demodata.tree.*;
import com.test.demodata.treenode.*;
import com.test.demodata.DemodataUserContextImpl;
import com.test.demodata.iamservice.*;
import com.test.demodata.services.IamService;
import com.test.demodata.secuser.SecUser;
import com.test.demodata.userapp.UserApp;
import com.terapico.uccaf.BaseUserContext;


import com.test.demodata.genericform.GenericForm;

import com.test.demodata.genericform.CandidateGenericForm;







public class FormMessageManagerImpl extends CustomDemodataCheckerManager implements FormMessageManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "FormMessage";
	@Override
	public FormMessageDAO daoOf(DemodataUserContext userContext) {
		return formMessageDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FormMessageManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FormMessageManagerException(message);

	}



 	protected FormMessage saveFormMessage(DemodataUserContext userContext, FormMessage formMessage, String [] tokensExpr) throws Exception{	
 		//return getFormMessageDAO().save(formMessage, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormMessage(userContext, formMessage, tokens);
 	}
 	
 	protected FormMessage saveFormMessageDetail(DemodataUserContext userContext, FormMessage formMessage) throws Exception{	

 		
 		return saveFormMessage(userContext, formMessage, allTokens());
 	}
 	
 	public FormMessage loadFormMessage(DemodataUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formMessage, tokens);
 	}
 	
 	
 	 public FormMessage searchFormMessage(DemodataUserContext userContext, String formMessageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formMessage, tokens);
 	}
 	
 	

 	protected FormMessage present(DemodataUserContext userContext, FormMessage formMessage, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formMessage,tokens);
		
		
		FormMessage  formMessageToPresent = formMessageDaoOf(userContext).present(formMessage, tokens);
		
		List<BaseEntity> entityListToNaming = formMessageToPresent.collectRefercencesFromLists();
		formMessageDaoOf(userContext).alias(entityListToNaming);
		
		return  formMessageToPresent;
		
		
	}
 
 	
 	
 	public FormMessage loadFormMessageDetail(DemodataUserContext userContext, String formMessageId) throws Exception{	
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, allTokens());
 		return present(userContext,formMessage, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String formMessageId) throws Exception{	
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, viewTokens());
 		return present(userContext,formMessage, allTokens());
		
 	}
 	protected FormMessage saveFormMessage(DemodataUserContext userContext, FormMessage formMessage, Map<String,Object>tokens) throws Exception{	
 		return formMessageDaoOf(userContext).save(formMessage, tokens);
 	}
 	protected FormMessage loadFormMessage(DemodataUserContext userContext, String formMessageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 
 		return formMessageDaoOf(userContext).load(formMessageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, FormMessage formMessage, Map<String, Object> tokens){
		super.addActions(userContext, formMessage, tokens);
		
		addAction(userContext, formMessage, tokens,"@create","createFormMessage","createFormMessage/","main","primary");
		addAction(userContext, formMessage, tokens,"@update","updateFormMessage","updateFormMessage/"+formMessage.getId()+"/","main","primary");
		addAction(userContext, formMessage, tokens,"@copy","cloneFormMessage","cloneFormMessage/"+formMessage.getId()+"/","main","primary");
		
		addAction(userContext, formMessage, tokens,"form_message.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formMessage.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, FormMessage formMessage, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FormMessage createFormMessage(DemodataUserContext userContext, String title,String formId,String level) throws Exception
	//public FormMessage createFormMessage(DemodataUserContext userContext,String title, String formId, String level) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfFormMessage(title);
		checkerOf(userContext).checkLevelOfFormMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);


		FormMessage formMessage=createNewFormMessage();	

		formMessage.setTitle(title);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formMessage.setForm(form);
		
		
		formMessage.setLevel(level);

		formMessage = saveFormMessage(userContext, formMessage, emptyOptions());
		
		onNewInstanceCreated(userContext, formMessage);
		return formMessage;


	}
	protected FormMessage createNewFormMessage()
	{

		return new FormMessage();
	}

	protected void checkParamsForUpdatingFormMessage(DemodataUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).checkVersionOfFormMessage( formMessageVersion);
		

		if(FormMessage.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfFormMessage(parseString(newValueExpr));
		
			
		}		

		
		if(FormMessage.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormMessage(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);


	}



	public FormMessage clone(DemodataUserContext userContext, String fromFormMessageId) throws Exception{

		return formMessageDaoOf(userContext).clone(fromFormMessageId, this.allTokens());
	}

	public FormMessage internalSaveFormMessage(DemodataUserContext userContext, FormMessage formMessage) throws Exception
	{
		return internalSaveFormMessage(userContext, formMessage, allTokens());

	}
	public FormMessage internalSaveFormMessage(DemodataUserContext userContext, FormMessage formMessage, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);


		synchronized(formMessage){
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.
			if (formMessage.isChanged()){
			
			}
			formMessage = saveFormMessage(userContext, formMessage, options);
			return formMessage;

		}

	}

	public FormMessage updateFormMessage(DemodataUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);



		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());
		if(formMessage.getVersion() != formMessageVersion){
			String message = "The target version("+formMessage.getVersion()+") is not equals to version("+formMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formMessage){
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.
			
			formMessage.changeProperty(property, newValueExpr);
			formMessage = saveFormMessage(userContext, formMessage, tokens().done());
			return present(userContext,formMessage, mergedAllTokens(tokensExpr));
			//return saveFormMessage(userContext, formMessage, tokens().done());
		}

	}

	public FormMessage updateFormMessageProperty(DemodataUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);

		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());
		if(formMessage.getVersion() != formMessageVersion){
			String message = "The target version("+formMessage.getVersion()+") is not equals to version("+formMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formMessage){
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.

			formMessage.changeProperty(property, newValueExpr);
			
			formMessage = saveFormMessage(userContext, formMessage, tokens().done());
			return present(userContext,formMessage, mergedAllTokens(tokensExpr));
			//return saveFormMessage(userContext, formMessage, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FormMessageTokens tokens(){
		return FormMessageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormMessageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormMessageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(DemodataUserContext userContext, String formMessageId, String anotherFormId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);

 	}
 	public FormMessage transferToAnotherForm(DemodataUserContext userContext, String formMessageId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formMessageId,anotherFormId);
 
		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());	
		synchronized(formMessage){
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formMessage.updateForm(form);		
			formMessage = saveFormMessage(userContext, formMessage, emptyOptions());
			
			return present(userContext,formMessage, allTokens());
			
		}

 	}

	


	public CandidateGenericForm requestCandidateForm(DemodataUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormMessage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GenericForm loadGenericForm(DemodataUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{

 		return genericFormDaoOf(userContext).load(newFormId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String formMessageId, int formMessageVersion) throws Exception {
		//deleteInternal(userContext, formMessageId, formMessageVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String formMessageId, int formMessageVersion) throws Exception{

		formMessageDaoOf(userContext).delete(formMessageId, formMessageVersion);
	}

	public FormMessage forgetByAll(DemodataUserContext userContext, String formMessageId, int formMessageVersion) throws Exception {
		return forgetByAllInternal(userContext, formMessageId, formMessageVersion);
	}
	protected FormMessage forgetByAllInternal(DemodataUserContext userContext,
			String formMessageId, int formMessageVersion) throws Exception{

		return formMessageDaoOf(userContext).disconnectFromAll(formMessageId, formMessageVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormMessageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return formMessageDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(DemodataUserContext userContext, FormMessage newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(DemodataUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(DemodataBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(DemodataUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(DemodataBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(DemodataUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(DemodataBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(DemodataUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(DemodataBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(DemodataUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		DemodataUserContextImpl userContext = (DemodataUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(DemodataUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(DemodataUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(DemodataUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(DemodataUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	public void onAuthenticateNewUserLogged(DemodataUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, should create a account and bind with sec user, BUT, I don't know how to
		// create new object as of generate this method. It depends on business logical. So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(DemodataUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FormMessage.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<FormMessage> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GenericForm> formList = DemodataBaseUtils.collectReferencedObjectWithType(userContext, list, GenericForm.class);
		userContext.getDAOGroup().enhanceList(formList, GenericForm.class);


    }
	
	public Object listByForm(DemodataUserContext userContext,String formId) throws Exception {
		return listPageByForm(userContext, formId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByForm(DemodataUserContext userContext,String formId, int start, int count) throws Exception {
		SmartList<FormMessage> list = formMessageDaoOf(userContext).findFormMessageByForm(formId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		DemodataCommonListOfViewPage page = new DemodataCommonListOfViewPage();
		page.setClassOfList(FormMessage.class);
		page.setContainerObject(GenericForm.withId(formId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("表单信息列表");
		page.setRequestName("listByForm");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");

		page.assemblerContent(userContext, "listByForm");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


