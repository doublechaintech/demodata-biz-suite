
package com.test.demodata.candidatecontainer;

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


import com.test.demodata.candidateelement.CandidateElement;


import com.test.demodata.candidatecontainer.CandidateContainer;






public class CandidateContainerManagerImpl extends CustomDemodataCheckerManager implements CandidateContainerManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "CandidateContainer";
	@Override
	public CandidateContainerDAO daoOf(DemodataUserContext userContext) {
		return candidateContainerDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CandidateContainerManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CandidateContainerManagerException(message);

	}



 	protected CandidateContainer saveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer, String [] tokensExpr) throws Exception{	
 		//return getCandidateContainerDAO().save(candidateContainer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCandidateContainer(userContext, candidateContainer, tokens);
 	}
 	
 	protected CandidateContainer saveCandidateContainerDetail(DemodataUserContext userContext, CandidateContainer candidateContainer) throws Exception{	

 		
 		return saveCandidateContainer(userContext, candidateContainer, allTokens());
 	}
 	
 	public CandidateContainer loadCandidateContainer(DemodataUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}
 	
 	
 	 public CandidateContainer searchCandidateContainer(DemodataUserContext userContext, String candidateContainerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}
 	
 	

 	protected CandidateContainer present(DemodataUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,candidateContainer,tokens);
		
		
		CandidateContainer  candidateContainerToPresent = candidateContainerDaoOf(userContext).present(candidateContainer, tokens);
		
		List<BaseEntity> entityListToNaming = candidateContainerToPresent.collectRefercencesFromLists();
		candidateContainerDaoOf(userContext).alias(entityListToNaming);
		
		return  candidateContainerToPresent;
		
		
	}
 
 	
 	
 	public CandidateContainer loadCandidateContainerDetail(DemodataUserContext userContext, String candidateContainerId) throws Exception{	
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, allTokens());
 		return present(userContext,candidateContainer, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String candidateContainerId) throws Exception{	
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, viewTokens());
 		return present(userContext,candidateContainer, allTokens());
		
 	}
 	protected CandidateContainer saveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer, Map<String,Object>tokens) throws Exception{	
 		return candidateContainerDaoOf(userContext).save(candidateContainer, tokens);
 	}
 	protected CandidateContainer loadCandidateContainer(DemodataUserContext userContext, String candidateContainerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 
 		return candidateContainerDaoOf(userContext).load(candidateContainerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){
		super.addActions(userContext, candidateContainer, tokens);
		
		addAction(userContext, candidateContainer, tokens,"@create","createCandidateContainer","createCandidateContainer/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@update","updateCandidateContainer","updateCandidateContainer/"+candidateContainer.getId()+"/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@copy","cloneCandidateContainer","cloneCandidateContainer/"+candidateContainer.getId()+"/","main","primary");
		
		addAction(userContext, candidateContainer, tokens,"candidate_container.addCandidateElement","addCandidateElement","addCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.removeCandidateElement","removeCandidateElement","removeCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.updateCandidateElement","updateCandidateElement","updateCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.copyCandidateElementFrom","copyCandidateElementFrom","copyCandidateElementFrom/"+candidateContainer.getId()+"/","candidateElementList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CandidateContainer createCandidateContainer(DemodataUserContext userContext, String name) throws Exception
	//public CandidateContainer createCandidateContainer(DemodataUserContext userContext,String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCandidateContainer(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


		CandidateContainer candidateContainer=createNewCandidateContainer();	

		candidateContainer.setName(name);

		candidateContainer = saveCandidateContainer(userContext, candidateContainer, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateContainer);
		return candidateContainer;


	}
	protected CandidateContainer createNewCandidateContainer()
	{

		return new CandidateContainer();
	}

	protected void checkParamsForUpdatingCandidateContainer(DemodataUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkVersionOfCandidateContainer( candidateContainerVersion);
		

		if(CandidateContainer.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCandidateContainer(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}



	public CandidateContainer clone(DemodataUserContext userContext, String fromCandidateContainerId) throws Exception{

		return candidateContainerDaoOf(userContext).clone(fromCandidateContainerId, this.allTokens());
	}

	public CandidateContainer internalSaveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer) throws Exception
	{
		return internalSaveCandidateContainer(userContext, candidateContainer, allTokens());

	}
	public CandidateContainer internalSaveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);


		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			if (candidateContainer.isChanged()){
			
			}
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, options);
			return candidateContainer;

		}

	}

	public CandidateContainer updateCandidateContainer(DemodataUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);



		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			
			candidateContainer.changeProperty(property, newValueExpr);
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}

	public CandidateContainer updateCandidateContainerProperty(DemodataUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);

		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.

			candidateContainer.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CandidateContainerTokens tokens(){
		return CandidateContainerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateContainerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCandidateElementListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateContainerTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		//deleteInternal(userContext, candidateContainerId, candidateContainerVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{

		candidateContainerDaoOf(userContext).delete(candidateContainerId, candidateContainerVersion);
	}

	public CandidateContainer forgetByAll(DemodataUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateContainerId, candidateContainerVersion);
	}
	protected CandidateContainer forgetByAllInternal(DemodataUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{

		return candidateContainerDaoOf(userContext).disconnectFromAll(candidateContainerId, candidateContainerVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateContainerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return candidateContainerDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingCandidateElement(DemodataUserContext userContext, String candidateContainerId, String name, String type, String image,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);

		
		checkerOf(userContext).checkNameOfCandidateElement(name);
		
		checkerOf(userContext).checkTypeOfCandidateElement(type);
		
		checkerOf(userContext).checkImageOfCandidateElement(image);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}
	public  CandidateContainer addCandidateElement(DemodataUserContext userContext, String candidateContainerId, String name, String type, String image, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, type, image,tokensExpr);

		CandidateElement candidateElement = createCandidateElement(userContext,name, type, image);

		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, emptyOptions());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.addCandidateElement( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			userContext.getManagerGroup().getCandidateElementManager().onNewInstanceCreated(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCandidateElementProperties(DemodataUserContext userContext, String candidateContainerId,String id,String name,String type,String image,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(id);

		checkerOf(userContext).checkNameOfCandidateElement( name);
		checkerOf(userContext).checkTypeOfCandidateElement( type);
		checkerOf(userContext).checkImageOfCandidateElement( image);

		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}
	public  CandidateContainer updateCandidateElementProperties(DemodataUserContext userContext, String candidateContainerId, String id,String name,String type,String image, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateElementProperties(userContext,candidateContainerId,id,name,type,image,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCandidateElementListList()
				.searchCandidateElementListWith(CandidateElement.ID_PROPERTY, "is", id).done();

		CandidateContainer candidateContainerToUpdate = loadCandidateContainer(userContext, candidateContainerId, options);

		if(candidateContainerToUpdate.getCandidateElementList().isEmpty()){
			throw new CandidateContainerManagerException("CandidateElement is NOT FOUND with id: '"+id+"'");
		}

		CandidateElement item = candidateContainerToUpdate.getCandidateElementList().first();

		item.updateName( name );
		item.updateType( type );
		item.updateImage( image );


		//checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, code, used,tokensExpr);
		CandidateContainer candidateContainer = saveCandidateContainer(userContext, candidateContainerToUpdate, tokens().withCandidateElementList().done());
		synchronized(candidateContainer){
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}


	protected CandidateElement createCandidateElement(DemodataUserContext userContext, String name, String type, String image) throws Exception{

		CandidateElement candidateElement = new CandidateElement();
		
		
		candidateElement.setName(name);		
		candidateElement.setType(type);		
		candidateElement.setImage(image);
	
		
		return candidateElement;


	}

	protected CandidateElement createIndexedCandidateElement(String id, int version){

		CandidateElement candidateElement = new CandidateElement();
		candidateElement.setId(id);
		candidateElement.setVersion(version);
		return candidateElement;

	}

	protected void checkParamsForRemovingCandidateElementList(DemodataUserContext userContext, String candidateContainerId,
			String candidateElementIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		for(String candidateElementIdItem: candidateElementIds){
			checkerOf(userContext).checkIdOfCandidateElement(candidateElementIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}
	public  CandidateContainer removeCandidateElementList(DemodataUserContext userContext, String candidateContainerId,
			String candidateElementIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCandidateElementList(userContext, candidateContainerId,  candidateElementIds, tokensExpr);


			CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
			synchronized(candidateContainer){
				//Will be good when the candidateContainer loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				candidateContainerDaoOf(userContext).planToRemoveCandidateElementList(candidateContainer, candidateElementIds, allTokens());
				candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
				deleteRelationListInGraph(userContext, candidateContainer.getCandidateElementList());
				return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCandidateElement(DemodataUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}
	public  CandidateContainer removeCandidateElement(DemodataUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);

		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.removeCandidateElement( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			deleteRelationInGraph(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCandidateElement(DemodataUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}
	public  CandidateContainer copyCandidateElementFrom(DemodataUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);

		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			candidateContainer.copyCandidateElementFrom( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			userContext.getManagerGroup().getCandidateElementManager().onNewInstanceCreated(userContext, (CandidateElement)candidateContainer.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCandidateElement(DemodataUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		

		if(CandidateElement.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
		
		}
		
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
		
		}
		
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}

	public  CandidateContainer updateCandidateElement(DemodataUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCandidateElement(userContext, candidateContainerId, candidateElementId, candidateElementVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCandidateElementList().searchCandidateElementListWith(CandidateElement.ID_PROPERTY, "eq", candidateElementId).done();



		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, loadTokens);

		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//candidateContainer.removeCandidateElement( candidateElement );
			//make changes to AcceleraterAccount.
			CandidateElement candidateElementIndex = createIndexedCandidateElement(candidateElementId, candidateElementVersion);

			CandidateElement candidateElement = candidateContainer.findTheCandidateElement(candidateElementIndex);
			if(candidateElement == null){
				throw new CandidateContainerManagerException(candidateElement+" is NOT FOUND" );
			}

			candidateElement.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(DemodataUserContext userContext, CandidateContainer newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CandidateContainer.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<CandidateContainer> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


