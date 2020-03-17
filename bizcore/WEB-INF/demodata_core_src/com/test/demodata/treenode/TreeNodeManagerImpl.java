
package com.test.demodata.treenode;

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










public class TreeNodeManagerImpl extends CustomDemodataCheckerManager implements TreeNodeManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "TreeNode";
	@Override
	public TreeNodeDAO daoOf(DemodataUserContext userContext) {
		return treeNodeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TreeNodeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TreeNodeManagerException(message);

	}



 	protected TreeNode saveTreeNode(DemodataUserContext userContext, TreeNode treeNode, String [] tokensExpr) throws Exception{	
 		//return getTreeNodeDAO().save(treeNode, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTreeNode(userContext, treeNode, tokens);
 	}
 	
 	protected TreeNode saveTreeNodeDetail(DemodataUserContext userContext, TreeNode treeNode) throws Exception{	

 		
 		return saveTreeNode(userContext, treeNode, allTokens());
 	}
 	
 	public TreeNode loadTreeNode(DemodataUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,treeNode, tokens);
 	}
 	
 	
 	 public TreeNode searchTreeNode(DemodataUserContext userContext, String treeNodeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,treeNode, tokens);
 	}
 	
 	

 	protected TreeNode present(DemodataUserContext userContext, TreeNode treeNode, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,treeNode,tokens);
		
		
		TreeNode  treeNodeToPresent = treeNodeDaoOf(userContext).present(treeNode, tokens);
		
		List<BaseEntity> entityListToNaming = treeNodeToPresent.collectRefercencesFromLists();
		treeNodeDaoOf(userContext).alias(entityListToNaming);
		
		return  treeNodeToPresent;
		
		
	}
 
 	
 	
 	public TreeNode loadTreeNodeDetail(DemodataUserContext userContext, String treeNodeId) throws Exception{	
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, allTokens());
 		return present(userContext,treeNode, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String treeNodeId) throws Exception{	
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, viewTokens());
 		return present(userContext,treeNode, allTokens());
		
 	}
 	protected TreeNode saveTreeNode(DemodataUserContext userContext, TreeNode treeNode, Map<String,Object>tokens) throws Exception{	
 		return treeNodeDaoOf(userContext).save(treeNode, tokens);
 	}
 	protected TreeNode loadTreeNode(DemodataUserContext userContext, String treeNodeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 
 		return treeNodeDaoOf(userContext).load(treeNodeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, TreeNode treeNode, Map<String, Object> tokens){
		super.addActions(userContext, treeNode, tokens);
		
		addAction(userContext, treeNode, tokens,"@create","createTreeNode","createTreeNode/","main","primary");
		addAction(userContext, treeNode, tokens,"@update","updateTreeNode","updateTreeNode/"+treeNode.getId()+"/","main","primary");
		addAction(userContext, treeNode, tokens,"@copy","cloneTreeNode","cloneTreeNode/"+treeNode.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, TreeNode treeNode, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TreeNode createTreeNode(DemodataUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception
	//public TreeNode createTreeNode(DemodataUserContext userContext,String nodeId, String nodeType, int leftValue, int rightValue) throws Exception
	{

		

		

		checkerOf(userContext).checkNodeIdOfTreeNode(nodeId);
		checkerOf(userContext).checkNodeTypeOfTreeNode(nodeType);
		checkerOf(userContext).checkLeftValueOfTreeNode(leftValue);
		checkerOf(userContext).checkRightValueOfTreeNode(rightValue);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);


		TreeNode treeNode=createNewTreeNode();	

		treeNode.setNodeId(nodeId);
		treeNode.setNodeType(nodeType);
		treeNode.setLeftValue(leftValue);
		treeNode.setRightValue(rightValue);

		treeNode = saveTreeNode(userContext, treeNode, emptyOptions());
		
		onNewInstanceCreated(userContext, treeNode);
		return treeNode;


	}
	protected TreeNode createNewTreeNode()
	{

		return new TreeNode();
	}

	protected void checkParamsForUpdatingTreeNode(DemodataUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).checkVersionOfTreeNode( treeNodeVersion);
		

		if(TreeNode.NODE_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNodeIdOfTreeNode(parseString(newValueExpr));
		
			
		}
		if(TreeNode.NODE_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNodeTypeOfTreeNode(parseString(newValueExpr));
		
			
		}
		if(TreeNode.LEFT_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeftValueOfTreeNode(parseInt(newValueExpr));
		
			
		}
		if(TreeNode.RIGHT_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRightValueOfTreeNode(parseInt(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);


	}



	public TreeNode clone(DemodataUserContext userContext, String fromTreeNodeId) throws Exception{

		return treeNodeDaoOf(userContext).clone(fromTreeNodeId, this.allTokens());
	}

	public TreeNode internalSaveTreeNode(DemodataUserContext userContext, TreeNode treeNode) throws Exception
	{
		return internalSaveTreeNode(userContext, treeNode, allTokens());

	}
	public TreeNode internalSaveTreeNode(DemodataUserContext userContext, TreeNode treeNode, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);


		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.
			if (treeNode.isChanged()){
			
			}
			treeNode = saveTreeNode(userContext, treeNode, options);
			return treeNode;

		}

	}

	public TreeNode updateTreeNode(DemodataUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);



		TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
		if(treeNode.getVersion() != treeNodeVersion){
			String message = "The target version("+treeNode.getVersion()+") is not equals to version("+treeNodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.
			
			treeNode.changeProperty(property, newValueExpr);
			treeNode = saveTreeNode(userContext, treeNode, tokens().done());
			return present(userContext,treeNode, mergedAllTokens(tokensExpr));
			//return saveTreeNode(userContext, treeNode, tokens().done());
		}

	}

	public TreeNode updateTreeNodeProperty(DemodataUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);

		TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
		if(treeNode.getVersion() != treeNodeVersion){
			String message = "The target version("+treeNode.getVersion()+") is not equals to version("+treeNodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.

			treeNode.changeProperty(property, newValueExpr);
			
			treeNode = saveTreeNode(userContext, treeNode, tokens().done());
			return present(userContext,treeNode, mergedAllTokens(tokensExpr));
			//return saveTreeNode(userContext, treeNode, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TreeNodeTokens tokens(){
		return TreeNodeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TreeNodeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TreeNodeTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {
		//deleteInternal(userContext, treeNodeId, treeNodeVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String treeNodeId, int treeNodeVersion) throws Exception{

		treeNodeDaoOf(userContext).delete(treeNodeId, treeNodeVersion);
	}

	public TreeNode forgetByAll(DemodataUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {
		return forgetByAllInternal(userContext, treeNodeId, treeNodeVersion);
	}
	protected TreeNode forgetByAllInternal(DemodataUserContext userContext,
			String treeNodeId, int treeNodeVersion) throws Exception{

		return treeNodeDaoOf(userContext).disconnectFromAll(treeNodeId, treeNodeVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TreeNodeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return treeNodeDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(DemodataUserContext userContext, TreeNode newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TreeNode.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<TreeNode> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}








