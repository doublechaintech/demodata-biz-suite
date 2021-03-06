
package com.test.demodata.platform;

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


import com.test.demodata.image.Image;


import com.test.demodata.platform.Platform;






public class PlatformManagerImpl extends CustomDemodataCheckerManager implements PlatformManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Platform";
	@Override
	public PlatformDAO daoOf(DemodataUserContext userContext) {
		return platformDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}



 	protected Platform savePlatform(DemodataUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(DemodataUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(DemodataUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(DemodataUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(DemodataUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = platformDaoOf(userContext).present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		platformDaoOf(userContext).alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(DemodataUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(DemodataUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return platformDaoOf(userContext).save(platform, tokens);
 	}
 	protected Platform loadPlatform(DemodataUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return platformDaoOf(userContext).load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addImage","addImage","addImage/"+platform.getId()+"/","imageList","primary");
		addAction(userContext, platform, tokens,"platform.removeImage","removeImage","removeImage/"+platform.getId()+"/","imageList","primary");
		addAction(userContext, platform, tokens,"platform.updateImage","updateImage","updateImage/"+platform.getId()+"/","imageList","primary");
		addAction(userContext, platform, tokens,"platform.copyImageFrom","copyImageFrom","copyImageFrom/"+platform.getId()+"/","imageList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Platform createPlatform(DemodataUserContext userContext, String name) throws Exception
	//public Platform createPlatform(DemodataUserContext userContext,String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPlatform(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;


	}
	protected Platform createNewPlatform()
	{

		return new Platform();
	}

	protected void checkParamsForUpdatingPlatform(DemodataUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPlatform(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}



	public Platform clone(DemodataUserContext userContext, String fromPlatformId) throws Exception{

		return platformDaoOf(userContext).clone(fromPlatformId, this.allTokens());
	}

	public Platform internalSavePlatform(DemodataUserContext userContext, Platform platform) throws Exception
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(DemodataUserContext userContext, Platform platform, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);


		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			if (platform.isChanged()){
			
			}
			platform = savePlatform(userContext, platform, options);
			return platform;

		}

	}

	public Platform updatePlatform(DemodataUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);



		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}

	public Platform updatePlatformProperty(DemodataUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);

		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.

			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortImageListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String platformId, int platformVersion) throws Exception{

		platformDaoOf(userContext).delete(platformId, platformVersion);
	}

	public Platform forgetByAll(DemodataUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);
	}
	protected Platform forgetByAllInternal(DemodataUserContext userContext,
			String platformId, int platformVersion) throws Exception{

		return platformDaoOf(userContext).disconnectFromAll(platformId, platformVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return platformDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingImage(DemodataUserContext userContext, String platformId, String name, String imagePath,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfImage(name);
		
		checkerOf(userContext).checkImagePathOfImage(imagePath);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}
	public  Platform addImage(DemodataUserContext userContext, String platformId, String name, String imagePath, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingImage(userContext,platformId,name, imagePath,tokensExpr);

		Image image = createImage(userContext,name, imagePath);

		Platform platform = loadPlatform(userContext, platformId, emptyOptions());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addImage( image );
			platform = savePlatform(userContext, platform, tokens().withImageList().done());
			
			userContext.getManagerGroup().getImageManager().onNewInstanceCreated(userContext, image);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingImageProperties(DemodataUserContext userContext, String platformId,String id,String name,String imagePath,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfImage(id);

		checkerOf(userContext).checkNameOfImage( name);
		checkerOf(userContext).checkImagePathOfImage( imagePath);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform updateImageProperties(DemodataUserContext userContext, String platformId, String id,String name,String imagePath, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingImageProperties(userContext,platformId,id,name,imagePath,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withImageListList()
				.searchImageListWith(Image.ID_PROPERTY, "is", id).done();

		Platform platformToUpdate = loadPlatform(userContext, platformId, options);

		if(platformToUpdate.getImageList().isEmpty()){
			throw new PlatformManagerException("Image is NOT FOUND with id: '"+id+"'");
		}

		Image item = platformToUpdate.getImageList().first();

		item.updateName( name );
		item.updateImagePath( imagePath );


		//checkParamsForAddingImage(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withImageList().done());
		synchronized(platform){
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}


	protected Image createImage(DemodataUserContext userContext, String name, String imagePath) throws Exception{

		Image image = new Image();
		
		
		image.setName(name);		
		image.setImagePath(imagePath);		
		image.setCreateTime(userContext.now());
	
		
		return image;


	}

	protected Image createIndexedImage(String id, int version){

		Image image = new Image();
		image.setId(id);
		image.setVersion(version);
		return image;

	}

	protected void checkParamsForRemovingImageList(DemodataUserContext userContext, String platformId,
			String imageIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String imageIdItem: imageIds){
			checkerOf(userContext).checkIdOfImage(imageIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeImageList(DemodataUserContext userContext, String platformId,
			String imageIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingImageList(userContext, platformId,  imageIds, tokensExpr);


			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveImageList(platform, imageIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withImageList().done());
				deleteRelationListInGraph(userContext, platform.getImageList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingImage(DemodataUserContext userContext, String platformId,
		String imageId, int imageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).checkVersionOfImage(imageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeImage(DemodataUserContext userContext, String platformId,
		String imageId, int imageVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingImage(userContext,platformId, imageId, imageVersion,tokensExpr);

		Image image = createIndexedImage(imageId, imageVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeImage( image );
			platform = savePlatform(userContext, platform, tokens().withImageList().done());
			deleteRelationInGraph(userContext, image);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingImage(DemodataUserContext userContext, String platformId,
		String imageId, int imageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).checkVersionOfImage(imageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform copyImageFrom(DemodataUserContext userContext, String platformId,
		String imageId, int imageVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingImage(userContext,platformId, imageId, imageVersion,tokensExpr);

		Image image = createIndexedImage(imageId, imageVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			platform.copyImageFrom( image );
			platform = savePlatform(userContext, platform, tokens().withImageList().done());
			
			userContext.getManagerGroup().getImageManager().onNewInstanceCreated(userContext, (Image)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingImage(DemodataUserContext userContext, String platformId, String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).checkVersionOfImage(imageVersion);
		

		if(Image.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfImage(parseString(newValueExpr));
		
		}
		
		if(Image.IMAGE_PATH_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImagePathOfImage(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}

	public  Platform updateImage(DemodataUserContext userContext, String platformId, String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingImage(userContext, platformId, imageId, imageVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withImageList().searchImageListWith(Image.ID_PROPERTY, "eq", imageId).done();



		Platform platform = loadPlatform(userContext, platformId, loadTokens);

		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeImage( image );
			//make changes to AcceleraterAccount.
			Image imageIndex = createIndexedImage(imageId, imageVersion);

			Image image = platform.findTheImage(imageIndex);
			if(image == null){
				throw new PlatformManagerException(image+" is NOT FOUND" );
			}

			image.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withImageList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(DemodataUserContext userContext, Platform newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Platform.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<Platform> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


