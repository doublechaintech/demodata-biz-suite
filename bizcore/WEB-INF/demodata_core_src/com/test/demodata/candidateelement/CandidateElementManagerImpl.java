
package com.test.demodata.candidateelement;

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


import com.test.demodata.candidatecontainer.CandidateContainer;

import com.test.demodata.candidatecontainer.CandidateCandidateContainer;







public class CandidateElementManagerImpl extends CustomDemodataCheckerManager implements CandidateElementManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "CandidateElement";
	@Override
	public CandidateElementDAO daoOf(DemodataUserContext userContext) {
		return candidateElementDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CandidateElementManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CandidateElementManagerException(message);

	}



 	protected CandidateElement saveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement, String [] tokensExpr) throws Exception{	
 		//return getCandidateElementDAO().save(candidateElement, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCandidateElement(userContext, candidateElement, tokens);
 	}
 	
 	protected CandidateElement saveCandidateElementDetail(DemodataUserContext userContext, CandidateElement candidateElement) throws Exception{	

 		
 		return saveCandidateElement(userContext, candidateElement, allTokens());
 	}
 	
 	public CandidateElement loadCandidateElement(DemodataUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	
 	 public CandidateElement searchCandidateElement(DemodataUserContext userContext, String candidateElementId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	

 	protected CandidateElement present(DemodataUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,candidateElement,tokens);
		
		
		CandidateElement  candidateElementToPresent = candidateElementDaoOf(userContext).present(candidateElement, tokens);
		
		List<BaseEntity> entityListToNaming = candidateElementToPresent.collectRefercencesFromLists();
		candidateElementDaoOf(userContext).alias(entityListToNaming);
		
		return  candidateElementToPresent;
		
		
	}
 
 	
 	
 	public CandidateElement loadCandidateElementDetail(DemodataUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, allTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, viewTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	protected CandidateElement saveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement, Map<String,Object>tokens) throws Exception{	
 		return candidateElementDaoOf(userContext).save(candidateElement, tokens);
 	}
 	protected CandidateElement loadCandidateElement(DemodataUserContext userContext, String candidateElementId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 
 		return candidateElementDaoOf(userContext).load(candidateElementId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
		super.addActions(userContext, candidateElement, tokens);
		
		addAction(userContext, candidateElement, tokens,"@create","createCandidateElement","createCandidateElement/","main","primary");
		addAction(userContext, candidateElement, tokens,"@update","updateCandidateElement","updateCandidateElement/"+candidateElement.getId()+"/","main","primary");
		addAction(userContext, candidateElement, tokens,"@copy","cloneCandidateElement","cloneCandidateElement/"+candidateElement.getId()+"/","main","primary");
		
		addAction(userContext, candidateElement, tokens,"candidate_element.transfer_to_container","transferToAnotherContainer","transferToAnotherContainer/"+candidateElement.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CandidateElement createCandidateElement(DemodataUserContext userContext, String name,String type,String image,String containerId) throws Exception
	//public CandidateElement createCandidateElement(DemodataUserContext userContext,String name, String type, String image, String containerId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCandidateElement(name);
		checkerOf(userContext).checkTypeOfCandidateElement(type);
		checkerOf(userContext).checkImageOfCandidateElement(image);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);


		CandidateElement candidateElement=createNewCandidateElement();	

		candidateElement.setName(name);
		candidateElement.setType(type);
		candidateElement.setImage(image);
			
		CandidateContainer container = loadCandidateContainer(userContext, containerId,emptyOptions());
		candidateElement.setContainer(container);
		
		

		candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateElement);
		return candidateElement;


	}
	protected CandidateElement createNewCandidateElement()
	{

		return new CandidateElement();
	}

	protected void checkParamsForUpdatingCandidateElement(DemodataUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement( candidateElementVersion);
		

		if(CandidateElement.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
		
			
		}
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
		
			
		}
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);


	}



	public CandidateElement clone(DemodataUserContext userContext, String fromCandidateElementId) throws Exception{

		return candidateElementDaoOf(userContext).clone(fromCandidateElementId, this.allTokens());
	}

	public CandidateElement internalSaveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement) throws Exception
	{
		return internalSaveCandidateElement(userContext, candidateElement, allTokens());

	}
	public CandidateElement internalSaveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);


		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			if (candidateElement.isChanged()){
			
			}
			candidateElement = saveCandidateElement(userContext, candidateElement, options);
			return candidateElement;

		}

	}

	public CandidateElement updateCandidateElement(DemodataUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);



		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			
			candidateElement.changeProperty(property, newValueExpr);
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}

	public CandidateElement updateCandidateElementProperty(DemodataUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);

		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.

			candidateElement.changeProperty(property, newValueExpr);
			
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CandidateElementTokens tokens(){
		return CandidateElementTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateElementTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateElementTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherContainer(DemodataUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
 		checkerOf(userContext).checkIdOfCandidateContainer(anotherContainerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);

 	}
 	public CandidateElement transferToAnotherContainer(DemodataUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{
 		checkParamsForTransferingAnotherContainer(userContext, candidateElementId,anotherContainerId);
 
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());	
		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CandidateContainer container = loadCandidateContainer(userContext, anotherContainerId, emptyOptions());		
			candidateElement.updateContainer(container);		
			candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
			
			return present(userContext,candidateElement, allTokens());
			
		}

 	}

	


	public CandidateCandidateContainer requestCandidateContainer(DemodataUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCandidateContainer result = new CandidateCandidateContainer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CandidateContainer> candidateList = candidateContainerDaoOf(userContext).requestCandidateCandidateContainerForCandidateElement(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected CandidateContainer loadCandidateContainer(DemodataUserContext userContext, String newContainerId, Map<String,Object> options) throws Exception
 	{

 		return candidateContainerDaoOf(userContext).load(newContainerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		//deleteInternal(userContext, candidateElementId, candidateElementVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{

		candidateElementDaoOf(userContext).delete(candidateElementId, candidateElementVersion);
	}

	public CandidateElement forgetByAll(DemodataUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateElementId, candidateElementVersion);
	}
	protected CandidateElement forgetByAllInternal(DemodataUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{

		return candidateElementDaoOf(userContext).disconnectFromAll(candidateElementId, candidateElementVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateElementManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return candidateElementDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(DemodataUserContext userContext, CandidateElement newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CandidateElement.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<CandidateElement> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<CandidateContainer> containerList = DemodataBaseUtils.collectReferencedObjectWithType(userContext, list, CandidateContainer.class);
		userContext.getDAOGroup().enhanceList(containerList, CandidateContainer.class);


    }
	
	public Object listByContainer(DemodataUserContext userContext,String containerId) throws Exception {
		return listPageByContainer(userContext, containerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByContainer(DemodataUserContext userContext,String containerId, int start, int count) throws Exception {
		SmartList<CandidateElement> list = candidateElementDaoOf(userContext).findCandidateElementByContainer(containerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		DemodataCommonListOfViewPage page = new DemodataCommonListOfViewPage();
		page.setClassOfList(CandidateElement.class);
		page.setContainerObject(CandidateContainer.withId(containerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("候选人元素列表");
		page.setRequestName("listByContainer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");

		page.assemblerContent(userContext, "listByContainer");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


