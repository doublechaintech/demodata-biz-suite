
package com.test.demodata.formfield;

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







public class FormFieldManagerImpl extends CustomDemodataCheckerManager implements FormFieldManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "FormField";
	@Override
	public FormFieldDAO daoOf(DemodataUserContext userContext) {
		return formFieldDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FormFieldManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FormFieldManagerException(message);

	}



 	protected FormField saveFormField(DemodataUserContext userContext, FormField formField, String [] tokensExpr) throws Exception{	
 		//return getFormFieldDAO().save(formField, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormField(userContext, formField, tokens);
 	}
 	
 	protected FormField saveFormFieldDetail(DemodataUserContext userContext, FormField formField) throws Exception{	

 		
 		return saveFormField(userContext, formField, allTokens());
 	}
 	
 	public FormField loadFormField(DemodataUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	
 	 public FormField searchFormField(DemodataUserContext userContext, String formFieldId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	

 	protected FormField present(DemodataUserContext userContext, FormField formField, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formField,tokens);
		
		
		FormField  formFieldToPresent = formFieldDaoOf(userContext).present(formField, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldToPresent.collectRefercencesFromLists();
		formFieldDaoOf(userContext).alias(entityListToNaming);
		
		return  formFieldToPresent;
		
		
	}
 
 	
 	
 	public FormField loadFormFieldDetail(DemodataUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, allTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, viewTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	protected FormField saveFormField(DemodataUserContext userContext, FormField formField, Map<String,Object>tokens) throws Exception{	
 		return formFieldDaoOf(userContext).save(formField, tokens);
 	}
 	protected FormField loadFormField(DemodataUserContext userContext, String formFieldId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 
 		return formFieldDaoOf(userContext).load(formFieldId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, FormField formField, Map<String, Object> tokens){
		super.addActions(userContext, formField, tokens);
		
		addAction(userContext, formField, tokens,"@create","createFormField","createFormField/","main","primary");
		addAction(userContext, formField, tokens,"@update","updateFormField","updateFormField/"+formField.getId()+"/","main","primary");
		addAction(userContext, formField, tokens,"@copy","cloneFormField","cloneFormField/"+formField.getId()+"/","main","primary");
		
		addAction(userContext, formField, tokens,"form_field.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formField.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, FormField formField, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FormField createFormField(DemodataUserContext userContext, String label,String localeKey,String parameterName,String type,String formId,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues) throws Exception
	//public FormField createFormField(DemodataUserContext userContext,String label, String localeKey, String parameterName, String type, String formId, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception
	{

		

		

		checkerOf(userContext).checkLabelOfFormField(label);
		checkerOf(userContext).checkLocaleKeyOfFormField(localeKey);
		checkerOf(userContext).checkParameterNameOfFormField(parameterName);
		checkerOf(userContext).checkTypeOfFormField(type);
		checkerOf(userContext).checkPlaceholderOfFormField(placeholder);
		checkerOf(userContext).checkDefaultValueOfFormField(defaultValue);
		checkerOf(userContext).checkDescriptionOfFormField(description);
		checkerOf(userContext).checkFieldGroupOfFormField(fieldGroup);
		checkerOf(userContext).checkMinimumValueOfFormField(minimumValue);
		checkerOf(userContext).checkMaximumValueOfFormField(maximumValue);
		checkerOf(userContext).checkRequiredOfFormField(required);
		checkerOf(userContext).checkDisabledOfFormField(disabled);
		checkerOf(userContext).checkCustomRenderingOfFormField(customRendering);
		checkerOf(userContext).checkCandidateValuesOfFormField(candidateValues);
		checkerOf(userContext).checkSuggestValuesOfFormField(suggestValues);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);


		FormField formField=createNewFormField();	

		formField.setLabel(label);
		formField.setLocaleKey(localeKey);
		formField.setParameterName(parameterName);
		formField.setType(type);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formField.setForm(form);
		
		
		formField.setPlaceholder(placeholder);
		formField.setDefaultValue(defaultValue);
		formField.setDescription(description);
		formField.setFieldGroup(fieldGroup);
		formField.setMinimumValue(minimumValue);
		formField.setMaximumValue(maximumValue);
		formField.setRequired(required);
		formField.setDisabled(disabled);
		formField.setCustomRendering(customRendering);
		formField.setCandidateValues(candidateValues);
		formField.setSuggestValues(suggestValues);

		formField = saveFormField(userContext, formField, emptyOptions());
		
		onNewInstanceCreated(userContext, formField);
		return formField;


	}
	protected FormField createNewFormField()
	{

		return new FormField();
	}

	protected void checkParamsForUpdatingFormField(DemodataUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).checkVersionOfFormField( formFieldVersion);
		

		if(FormField.LABEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLabelOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.LOCALE_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocaleKeyOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.PARAMETER_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkParameterNameOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfFormField(parseString(newValueExpr));
		
			
		}		

		
		if(FormField.PLACEHOLDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPlaceholderOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.DEFAULT_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDefaultValueOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.FIELD_GROUP_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFieldGroupOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.MINIMUM_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMinimumValueOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.MAXIMUM_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMaximumValueOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.REQUIRED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRequiredOfFormField(parseBoolean(newValueExpr));
		
			
		}
		if(FormField.DISABLED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisabledOfFormField(parseBoolean(newValueExpr));
		
			
		}
		if(FormField.CUSTOM_RENDERING_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCustomRenderingOfFormField(parseBoolean(newValueExpr));
		
			
		}
		if(FormField.CANDIDATE_VALUES_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCandidateValuesOfFormField(parseString(newValueExpr));
		
			
		}
		if(FormField.SUGGEST_VALUES_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSuggestValuesOfFormField(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);


	}



	public FormField clone(DemodataUserContext userContext, String fromFormFieldId) throws Exception{

		return formFieldDaoOf(userContext).clone(fromFormFieldId, this.allTokens());
	}

	public FormField internalSaveFormField(DemodataUserContext userContext, FormField formField) throws Exception
	{
		return internalSaveFormField(userContext, formField, allTokens());

	}
	public FormField internalSaveFormField(DemodataUserContext userContext, FormField formField, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);


		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			if (formField.isChanged()){
			
			}
			formField = saveFormField(userContext, formField, options);
			return formField;

		}

	}

	public FormField updateFormField(DemodataUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);



		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			formField.changeProperty(property, newValueExpr);
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}

	public FormField updateFormFieldProperty(DemodataUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);

		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.

			formField.changeProperty(property, newValueExpr);
			
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FormFieldTokens tokens(){
		return FormFieldTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(DemodataUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFormField(formFieldId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);

 	}
 	public FormField transferToAnotherForm(DemodataUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldId,anotherFormId);
 
		FormField formField = loadFormField(userContext, formFieldId, allTokens());	
		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formField.updateForm(form);		
			formField = saveFormField(userContext, formField, emptyOptions());
			
			return present(userContext,formField, allTokens());
			
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
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormField(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(DemodataUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		//deleteInternal(userContext, formFieldId, formFieldVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{

		formFieldDaoOf(userContext).delete(formFieldId, formFieldVersion);
	}

	public FormField forgetByAll(DemodataUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldId, formFieldVersion);
	}
	protected FormField forgetByAllInternal(DemodataUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{

		return formFieldDaoOf(userContext).disconnectFromAll(formFieldId, formFieldVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return formFieldDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(DemodataUserContext userContext, FormField newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FormField.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<FormField> list) throws Exception {
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
		SmartList<FormField> list = formFieldDaoOf(userContext).findFormFieldByForm(formId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		DemodataCommonListOfViewPage page = new DemodataCommonListOfViewPage();
		page.setClassOfList(FormField.class);
		page.setContainerObject(GenericForm.withId(formId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("表单字段列表");
		page.setRequestName("listByForm");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");

		page.assemblerContent(userContext, "listByForm");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


