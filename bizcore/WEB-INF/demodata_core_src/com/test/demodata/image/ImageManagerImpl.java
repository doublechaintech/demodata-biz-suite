
package com.test.demodata.image;

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


import com.test.demodata.platform.Platform;

import com.test.demodata.platform.CandidatePlatform;







public class ImageManagerImpl extends CustomDemodataCheckerManager implements ImageManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Image";
	@Override
	public ImageDAO daoOf(DemodataUserContext userContext) {
		return imageDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ImageManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ImageManagerException(message);

	}



 	protected Image saveImage(DemodataUserContext userContext, Image image, String [] tokensExpr) throws Exception{	
 		//return getImageDAO().save(image, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveImage(userContext, image, tokens);
 	}
 	
 	protected Image saveImageDetail(DemodataUserContext userContext, Image image) throws Exception{	

 		
 		return saveImage(userContext, image, allTokens());
 	}
 	
 	public Image loadImage(DemodataUserContext userContext, String imageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).throwExceptionIfHasErrors( ImageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Image image = loadImage( userContext, imageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,image, tokens);
 	}
 	
 	
 	 public Image searchImage(DemodataUserContext userContext, String imageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).throwExceptionIfHasErrors( ImageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Image image = loadImage( userContext, imageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,image, tokens);
 	}
 	
 	

 	protected Image present(DemodataUserContext userContext, Image image, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,image,tokens);
		
		
		Image  imageToPresent = imageDaoOf(userContext).present(image, tokens);
		
		List<BaseEntity> entityListToNaming = imageToPresent.collectRefercencesFromLists();
		imageDaoOf(userContext).alias(entityListToNaming);
		
		return  imageToPresent;
		
		
	}
 
 	
 	
 	public Image loadImageDetail(DemodataUserContext userContext, String imageId) throws Exception{	
 		Image image = loadImage( userContext, imageId, allTokens());
 		return present(userContext,image, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String imageId) throws Exception{	
 		Image image = loadImage( userContext, imageId, viewTokens());
 		return present(userContext,image, allTokens());
		
 	}
 	protected Image saveImage(DemodataUserContext userContext, Image image, Map<String,Object>tokens) throws Exception{	
 		return imageDaoOf(userContext).save(image, tokens);
 	}
 	protected Image loadImage(DemodataUserContext userContext, String imageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).throwExceptionIfHasErrors( ImageManagerException.class);

 
 		return imageDaoOf(userContext).load(imageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Image image, Map<String, Object> tokens){
		super.addActions(userContext, image, tokens);
		
		addAction(userContext, image, tokens,"@create","createImage","createImage/","main","primary");
		addAction(userContext, image, tokens,"@update","updateImage","updateImage/"+image.getId()+"/","main","primary");
		addAction(userContext, image, tokens,"@copy","cloneImage","cloneImage/"+image.getId()+"/","main","primary");
		
		addAction(userContext, image, tokens,"image.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+image.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Image image, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Image createImage(DemodataUserContext userContext, String name,String imagePath,String platformId) throws Exception
	//public Image createImage(DemodataUserContext userContext,String name, String imagePath, String platformId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfImage(name);
		checkerOf(userContext).checkImagePathOfImage(imagePath);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ImageManagerException.class);


		Image image=createNewImage();	

		image.setName(name);
		image.setImagePath(imagePath);
		image.setCreateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		image.setPlatform(platform);
		
		

		image = saveImage(userContext, image, emptyOptions());
		
		onNewInstanceCreated(userContext, image);
		return image;


	}
	protected Image createNewImage()
	{

		return new Image();
	}

	protected void checkParamsForUpdatingImage(DemodataUserContext userContext,String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfImage(imageId);
		checkerOf(userContext).checkVersionOfImage( imageVersion);
		

		if(Image.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfImage(parseString(newValueExpr));
		
			
		}
		if(Image.IMAGE_PATH_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImagePathOfImage(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ImageManagerException.class);


	}



	public Image clone(DemodataUserContext userContext, String fromImageId) throws Exception{

		return imageDaoOf(userContext).clone(fromImageId, this.allTokens());
	}

	public Image internalSaveImage(DemodataUserContext userContext, Image image) throws Exception
	{
		return internalSaveImage(userContext, image, allTokens());

	}
	public Image internalSaveImage(DemodataUserContext userContext, Image image, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingImage(userContext, imageId, imageVersion, property, newValueExpr, tokensExpr);


		synchronized(image){
			//will be good when the image loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Image.
			if (image.isChanged()){
			
			}
			image = saveImage(userContext, image, options);
			return image;

		}

	}

	public Image updateImage(DemodataUserContext userContext,String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingImage(userContext, imageId, imageVersion, property, newValueExpr, tokensExpr);



		Image image = loadImage(userContext, imageId, allTokens());
		if(image.getVersion() != imageVersion){
			String message = "The target version("+image.getVersion()+") is not equals to version("+imageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(image){
			//will be good when the image loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Image.
			
			image.changeProperty(property, newValueExpr);
			image = saveImage(userContext, image, tokens().done());
			return present(userContext,image, mergedAllTokens(tokensExpr));
			//return saveImage(userContext, image, tokens().done());
		}

	}

	public Image updateImageProperty(DemodataUserContext userContext,String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingImage(userContext, imageId, imageVersion, property, newValueExpr, tokensExpr);

		Image image = loadImage(userContext, imageId, allTokens());
		if(image.getVersion() != imageVersion){
			String message = "The target version("+image.getVersion()+") is not equals to version("+imageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(image){
			//will be good when the image loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Image.

			image.changeProperty(property, newValueExpr);
			
			image = saveImage(userContext, image, tokens().done());
			return present(userContext,image, mergedAllTokens(tokensExpr));
			//return saveImage(userContext, image, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ImageTokens tokens(){
		return ImageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ImageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ImageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(DemodataUserContext userContext, String imageId, String anotherPlatformId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfImage(imageId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ImageManagerException.class);

 	}
 	public Image transferToAnotherPlatform(DemodataUserContext userContext, String imageId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, imageId,anotherPlatformId);
 
		Image image = loadImage(userContext, imageId, allTokens());	
		synchronized(image){
			//will be good when the image loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			image.updatePlatform(platform);		
			image = saveImage(userContext, image, emptyOptions());
			
			return present(userContext,image, allTokens());
			
		}

 	}

	


	public CandidatePlatform requestCandidatePlatform(DemodataUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForImage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Platform loadPlatform(DemodataUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{

 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String imageId, int imageVersion) throws Exception {
		//deleteInternal(userContext, imageId, imageVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String imageId, int imageVersion) throws Exception{

		imageDaoOf(userContext).delete(imageId, imageVersion);
	}

	public Image forgetByAll(DemodataUserContext userContext, String imageId, int imageVersion) throws Exception {
		return forgetByAllInternal(userContext, imageId, imageVersion);
	}
	protected Image forgetByAllInternal(DemodataUserContext userContext,
			String imageId, int imageVersion) throws Exception{

		return imageDaoOf(userContext).disconnectFromAll(imageId, imageVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ImageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return imageDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(DemodataUserContext userContext, Image newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Image.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<Image> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Platform> platformList = DemodataBaseUtils.collectReferencedObjectWithType(userContext, list, Platform.class);
		userContext.getDAOGroup().enhanceList(platformList, Platform.class);


    }
	
	public Object listByPlatform(DemodataUserContext userContext,String platformId) throws Exception {
		return listPageByPlatform(userContext, platformId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPlatform(DemodataUserContext userContext,String platformId, int start, int count) throws Exception {
		SmartList<Image> list = imageDaoOf(userContext).findImageByPlatform(platformId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		DemodataCommonListOfViewPage page = new DemodataCommonListOfViewPage();
		page.setClassOfList(Image.class);
		page.setContainerObject(Platform.withId(platformId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("图片列表");
		page.setRequestName("listByPlatform");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");

		page.assemblerContent(userContext, "listByPlatform");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


