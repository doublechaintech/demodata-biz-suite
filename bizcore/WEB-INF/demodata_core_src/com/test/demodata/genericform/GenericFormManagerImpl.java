
package com.test.demodata.genericform;

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


import com.test.demodata.formfieldmessage.FormFieldMessage;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formaction.FormAction;


import com.test.demodata.genericform.GenericForm;






public class GenericFormManagerImpl extends CustomDemodataCheckerManager implements GenericFormManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "GenericForm";
	@Override
	public GenericFormDAO daoOf(DemodataUserContext userContext) {
		return genericFormDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws GenericFormManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new GenericFormManagerException(message);

	}



 	protected GenericForm saveGenericForm(DemodataUserContext userContext, GenericForm genericForm, String [] tokensExpr) throws Exception{	
 		//return getGenericFormDAO().save(genericForm, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGenericForm(userContext, genericForm, tokens);
 	}
 	
 	protected GenericForm saveGenericFormDetail(DemodataUserContext userContext, GenericForm genericForm) throws Exception{	

 		
 		return saveGenericForm(userContext, genericForm, allTokens());
 	}
 	
 	public GenericForm loadGenericForm(DemodataUserContext userContext, String genericFormId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).throwExceptionIfHasErrors( GenericFormManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,genericForm, tokens);
 	}
 	
 	
 	 public GenericForm searchGenericForm(DemodataUserContext userContext, String genericFormId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).throwExceptionIfHasErrors( GenericFormManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,genericForm, tokens);
 	}
 	
 	

 	protected GenericForm present(DemodataUserContext userContext, GenericForm genericForm, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,genericForm,tokens);
		
		
		GenericForm  genericFormToPresent = genericFormDaoOf(userContext).present(genericForm, tokens);
		
		List<BaseEntity> entityListToNaming = genericFormToPresent.collectRefercencesFromLists();
		genericFormDaoOf(userContext).alias(entityListToNaming);
		
		return  genericFormToPresent;
		
		
	}
 
 	
 	
 	public GenericForm loadGenericFormDetail(DemodataUserContext userContext, String genericFormId) throws Exception{	
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, allTokens());
 		return present(userContext,genericForm, allTokens());
		
 	}
 	
 	public Object view(DemodataUserContext userContext, String genericFormId) throws Exception{	
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, viewTokens());
 		return present(userContext,genericForm, allTokens());
		
 	}
 	protected GenericForm saveGenericForm(DemodataUserContext userContext, GenericForm genericForm, Map<String,Object>tokens) throws Exception{	
 		return genericFormDaoOf(userContext).save(genericForm, tokens);
 	}
 	protected GenericForm loadGenericForm(DemodataUserContext userContext, String genericFormId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).throwExceptionIfHasErrors( GenericFormManagerException.class);

 
 		return genericFormDaoOf(userContext).load(genericFormId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, GenericForm genericForm, Map<String, Object> tokens){
		super.addActions(userContext, genericForm, tokens);
		
		addAction(userContext, genericForm, tokens,"@create","createGenericForm","createGenericForm/","main","primary");
		addAction(userContext, genericForm, tokens,"@update","updateGenericForm","updateGenericForm/"+genericForm.getId()+"/","main","primary");
		addAction(userContext, genericForm, tokens,"@copy","cloneGenericForm","cloneGenericForm/"+genericForm.getId()+"/","main","primary");
		
		addAction(userContext, genericForm, tokens,"generic_form.addFormMessage","addFormMessage","addFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormMessage","removeFormMessage","removeFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormMessage","updateFormMessage","updateFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormMessageFrom","copyFormMessageFrom","copyFormMessageFrom/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormFieldMessage","addFormFieldMessage","addFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormFieldMessage","removeFormFieldMessage","removeFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormFieldMessage","updateFormFieldMessage","updateFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormFieldMessageFrom","copyFormFieldMessageFrom","copyFormFieldMessageFrom/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormField","addFormField","addFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormField","removeFormField","removeFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormField","updateFormField","updateFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormFieldFrom","copyFormFieldFrom","copyFormFieldFrom/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormAction","addFormAction","addFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormAction","removeFormAction","removeFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormAction","updateFormAction","updateFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormActionFrom","copyFormActionFrom","copyFormActionFrom/"+genericForm.getId()+"/","formActionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, GenericForm genericForm, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public GenericForm createGenericForm(DemodataUserContext userContext, String title,String description) throws Exception
	//public GenericForm createGenericForm(DemodataUserContext userContext,String title, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfGenericForm(title);
		checkerOf(userContext).checkDescriptionOfGenericForm(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


		GenericForm genericForm=createNewGenericForm();	

		genericForm.setTitle(title);
		genericForm.setDescription(description);

		genericForm = saveGenericForm(userContext, genericForm, emptyOptions());
		
		onNewInstanceCreated(userContext, genericForm);
		return genericForm;


	}
	protected GenericForm createNewGenericForm()
	{

		return new GenericForm();
	}

	protected void checkParamsForUpdatingGenericForm(DemodataUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkVersionOfGenericForm( genericFormVersion);
		

		if(GenericForm.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfGenericForm(parseString(newValueExpr));
		
			
		}
		if(GenericForm.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfGenericForm(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


	}



	public GenericForm clone(DemodataUserContext userContext, String fromGenericFormId) throws Exception{

		return genericFormDaoOf(userContext).clone(fromGenericFormId, this.allTokens());
	}

	public GenericForm internalSaveGenericForm(DemodataUserContext userContext, GenericForm genericForm) throws Exception
	{
		return internalSaveGenericForm(userContext, genericForm, allTokens());

	}
	public GenericForm internalSaveGenericForm(DemodataUserContext userContext, GenericForm genericForm, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);


		synchronized(genericForm){
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.
			if (genericForm.isChanged()){
			
			}
			genericForm = saveGenericForm(userContext, genericForm, options);
			return genericForm;

		}

	}

	public GenericForm updateGenericForm(DemodataUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);



		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		if(genericForm.getVersion() != genericFormVersion){
			String message = "The target version("+genericForm.getVersion()+") is not equals to version("+genericFormVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(genericForm){
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.
			
			genericForm.changeProperty(property, newValueExpr);
			genericForm = saveGenericForm(userContext, genericForm, tokens().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			//return saveGenericForm(userContext, genericForm, tokens().done());
		}

	}

	public GenericForm updateGenericFormProperty(DemodataUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);

		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		if(genericForm.getVersion() != genericFormVersion){
			String message = "The target version("+genericForm.getVersion()+") is not equals to version("+genericFormVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(genericForm){
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.

			genericForm.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			//return saveGenericForm(userContext, genericForm, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected GenericFormTokens tokens(){
		return GenericFormTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GenericFormTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortFormMessageListWith("id","desc")
		.sortFormFieldMessageListWith("id","desc")
		.sortFormFieldListWith("id","desc")
		.sortFormActionListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GenericFormTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String genericFormId, int genericFormVersion) throws Exception {
		//deleteInternal(userContext, genericFormId, genericFormVersion);
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String genericFormId, int genericFormVersion) throws Exception{

		genericFormDaoOf(userContext).delete(genericFormId, genericFormVersion);
	}

	public GenericForm forgetByAll(DemodataUserContext userContext, String genericFormId, int genericFormVersion) throws Exception {
		return forgetByAllInternal(userContext, genericFormId, genericFormVersion);
	}
	protected GenericForm forgetByAllInternal(DemodataUserContext userContext,
			String genericFormId, int genericFormVersion) throws Exception{

		return genericFormDaoOf(userContext).disconnectFromAll(genericFormId, genericFormVersion);
	}




	public int deleteAll(DemodataUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GenericFormManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(DemodataUserContext userContext) throws Exception{
		return genericFormDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingFormMessage(DemodataUserContext userContext, String genericFormId, String title, String level,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGenericForm(genericFormId);

		
		checkerOf(userContext).checkTitleOfFormMessage(title);
		
		checkerOf(userContext).checkLevelOfFormMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


	}
	public  GenericForm addFormMessage(DemodataUserContext userContext, String genericFormId, String title, String level, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFormMessage(userContext,genericFormId,title, level,tokensExpr);

		FormMessage formMessage = createFormMessage(userContext,title, level);

		GenericForm genericForm = loadGenericForm(userContext, genericFormId, emptyOptions());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormMessage( formMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			
			userContext.getManagerGroup().getFormMessageManager().onNewInstanceCreated(userContext, formMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormMessageProperties(DemodataUserContext userContext, String genericFormId,String id,String title,String level,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormMessage(id);

		checkerOf(userContext).checkTitleOfFormMessage( title);
		checkerOf(userContext).checkLevelOfFormMessage( level);

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm updateFormMessageProperties(DemodataUserContext userContext, String genericFormId, String id,String title,String level, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormMessageProperties(userContext,genericFormId,id,title,level,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormMessageListList()
				.searchFormMessageListWith(FormMessage.ID_PROPERTY, "is", id).done();

		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);

		if(genericFormToUpdate.getFormMessageList().isEmpty()){
			throw new GenericFormManagerException("FormMessage is NOT FOUND with id: '"+id+"'");
		}

		FormMessage item = genericFormToUpdate.getFormMessageList().first();

		item.updateTitle( title );
		item.updateLevel( level );


		//checkParamsForAddingFormMessage(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormMessageList().done());
		synchronized(genericForm){
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}


	protected FormMessage createFormMessage(DemodataUserContext userContext, String title, String level) throws Exception{

		FormMessage formMessage = new FormMessage();
		
		
		formMessage.setTitle(title);		
		formMessage.setLevel(level);
	
		
		return formMessage;


	}

	protected FormMessage createIndexedFormMessage(String id, int version){

		FormMessage formMessage = new FormMessage();
		formMessage.setId(id);
		formMessage.setVersion(version);
		return formMessage;

	}

	protected void checkParamsForRemovingFormMessageList(DemodataUserContext userContext, String genericFormId,
			String formMessageIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		for(String formMessageIdItem: formMessageIds){
			checkerOf(userContext).checkIdOfFormMessage(formMessageIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormMessageList(DemodataUserContext userContext, String genericFormId,
			String formMessageIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFormMessageList(userContext, genericFormId,  formMessageIds, tokensExpr);


			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				genericFormDaoOf(userContext).planToRemoveFormMessageList(genericForm, formMessageIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormMessageList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFormMessage(DemodataUserContext userContext, String genericFormId,
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).checkVersionOfFormMessage(formMessageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormMessage(DemodataUserContext userContext, String genericFormId,
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFormMessage(userContext,genericFormId, formMessageId, formMessageVersion,tokensExpr);

		FormMessage formMessage = createIndexedFormMessage(formMessageId, formMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormMessage( formMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			deleteRelationInGraph(userContext, formMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFormMessage(DemodataUserContext userContext, String genericFormId,
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).checkVersionOfFormMessage(formMessageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm copyFormMessageFrom(DemodataUserContext userContext, String genericFormId,
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFormMessage(userContext,genericFormId, formMessageId, formMessageVersion,tokensExpr);

		FormMessage formMessage = createIndexedFormMessage(formMessageId, formMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			genericForm.copyFormMessageFrom( formMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			
			userContext.getManagerGroup().getFormMessageManager().onNewInstanceCreated(userContext, (FormMessage)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFormMessage(DemodataUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).checkVersionOfFormMessage(formMessageVersion);
		

		if(FormMessage.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfFormMessage(parseString(newValueExpr));
		
		}
		
		if(FormMessage.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormMessage(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}

	public  GenericForm updateFormMessage(DemodataUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFormMessage(userContext, genericFormId, formMessageId, formMessageVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFormMessageList().searchFormMessageListWith(FormMessage.ID_PROPERTY, "eq", formMessageId).done();



		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);

		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormMessage( formMessage );
			//make changes to AcceleraterAccount.
			FormMessage formMessageIndex = createIndexedFormMessage(formMessageId, formMessageVersion);

			FormMessage formMessage = genericForm.findTheFormMessage(formMessageIndex);
			if(formMessage == null){
				throw new GenericFormManagerException(formMessage+" is NOT FOUND" );
			}

			formMessage.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingFormFieldMessage(DemodataUserContext userContext, String genericFormId, String title, String parameterName, String level,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGenericForm(genericFormId);

		
		checkerOf(userContext).checkTitleOfFormFieldMessage(title);
		
		checkerOf(userContext).checkParameterNameOfFormFieldMessage(parameterName);
		
		checkerOf(userContext).checkLevelOfFormFieldMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


	}
	public  GenericForm addFormFieldMessage(DemodataUserContext userContext, String genericFormId, String title, String parameterName, String level, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFormFieldMessage(userContext,genericFormId,title, parameterName, level,tokensExpr);

		FormFieldMessage formFieldMessage = createFormFieldMessage(userContext,title, parameterName, level);

		GenericForm genericForm = loadGenericForm(userContext, genericFormId, emptyOptions());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormFieldMessage( formFieldMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			
			userContext.getManagerGroup().getFormFieldMessageManager().onNewInstanceCreated(userContext, formFieldMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormFieldMessageProperties(DemodataUserContext userContext, String genericFormId,String id,String title,String parameterName,String level,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormFieldMessage(id);

		checkerOf(userContext).checkTitleOfFormFieldMessage( title);
		checkerOf(userContext).checkParameterNameOfFormFieldMessage( parameterName);
		checkerOf(userContext).checkLevelOfFormFieldMessage( level);

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm updateFormFieldMessageProperties(DemodataUserContext userContext, String genericFormId, String id,String title,String parameterName,String level, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormFieldMessageProperties(userContext,genericFormId,id,title,parameterName,level,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormFieldMessageListList()
				.searchFormFieldMessageListWith(FormFieldMessage.ID_PROPERTY, "is", id).done();

		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);

		if(genericFormToUpdate.getFormFieldMessageList().isEmpty()){
			throw new GenericFormManagerException("FormFieldMessage is NOT FOUND with id: '"+id+"'");
		}

		FormFieldMessage item = genericFormToUpdate.getFormFieldMessageList().first();

		item.updateTitle( title );
		item.updateParameterName( parameterName );
		item.updateLevel( level );


		//checkParamsForAddingFormFieldMessage(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormFieldMessageList().done());
		synchronized(genericForm){
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}


	protected FormFieldMessage createFormFieldMessage(DemodataUserContext userContext, String title, String parameterName, String level) throws Exception{

		FormFieldMessage formFieldMessage = new FormFieldMessage();
		
		
		formFieldMessage.setTitle(title);		
		formFieldMessage.setParameterName(parameterName);		
		formFieldMessage.setLevel(level);
	
		
		return formFieldMessage;


	}

	protected FormFieldMessage createIndexedFormFieldMessage(String id, int version){

		FormFieldMessage formFieldMessage = new FormFieldMessage();
		formFieldMessage.setId(id);
		formFieldMessage.setVersion(version);
		return formFieldMessage;

	}

	protected void checkParamsForRemovingFormFieldMessageList(DemodataUserContext userContext, String genericFormId,
			String formFieldMessageIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		for(String formFieldMessageIdItem: formFieldMessageIds){
			checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormFieldMessageList(DemodataUserContext userContext, String genericFormId,
			String formFieldMessageIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFormFieldMessageList(userContext, genericFormId,  formFieldMessageIds, tokensExpr);


			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				genericFormDaoOf(userContext).planToRemoveFormFieldMessageList(genericForm, formFieldMessageIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormFieldMessageList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFormFieldMessage(DemodataUserContext userContext, String genericFormId,
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).checkVersionOfFormFieldMessage(formFieldMessageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormFieldMessage(DemodataUserContext userContext, String genericFormId,
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFormFieldMessage(userContext,genericFormId, formFieldMessageId, formFieldMessageVersion,tokensExpr);

		FormFieldMessage formFieldMessage = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormFieldMessage( formFieldMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			deleteRelationInGraph(userContext, formFieldMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFormFieldMessage(DemodataUserContext userContext, String genericFormId,
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).checkVersionOfFormFieldMessage(formFieldMessageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm copyFormFieldMessageFrom(DemodataUserContext userContext, String genericFormId,
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFormFieldMessage(userContext,genericFormId, formFieldMessageId, formFieldMessageVersion,tokensExpr);

		FormFieldMessage formFieldMessage = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			genericForm.copyFormFieldMessageFrom( formFieldMessage );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			
			userContext.getManagerGroup().getFormFieldMessageManager().onNewInstanceCreated(userContext, (FormFieldMessage)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFormFieldMessage(DemodataUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).checkVersionOfFormFieldMessage(formFieldMessageVersion);
		

		if(FormFieldMessage.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfFormFieldMessage(parseString(newValueExpr));
		
		}
		
		if(FormFieldMessage.PARAMETER_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkParameterNameOfFormFieldMessage(parseString(newValueExpr));
		
		}
		
		if(FormFieldMessage.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormFieldMessage(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}

	public  GenericForm updateFormFieldMessage(DemodataUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFormFieldMessage(userContext, genericFormId, formFieldMessageId, formFieldMessageVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFormFieldMessageList().searchFormFieldMessageListWith(FormFieldMessage.ID_PROPERTY, "eq", formFieldMessageId).done();



		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);

		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormFieldMessage( formFieldMessage );
			//make changes to AcceleraterAccount.
			FormFieldMessage formFieldMessageIndex = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);

			FormFieldMessage formFieldMessage = genericForm.findTheFormFieldMessage(formFieldMessageIndex);
			if(formFieldMessage == null){
				throw new GenericFormManagerException(formFieldMessage+" is NOT FOUND" );
			}

			formFieldMessage.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingFormField(DemodataUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGenericForm(genericFormId);

		
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
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


	}
	public  GenericForm addFormField(DemodataUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFormField(userContext,genericFormId,label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, required, disabled, customRendering, candidateValues, suggestValues,tokensExpr);

		FormField formField = createFormField(userContext,label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, required, disabled, customRendering, candidateValues, suggestValues);

		GenericForm genericForm = loadGenericForm(userContext, genericFormId, emptyOptions());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormField( formField );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			
			userContext.getManagerGroup().getFormFieldManager().onNewInstanceCreated(userContext, formField);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormFieldProperties(DemodataUserContext userContext, String genericFormId,String id,String label,String localeKey,String parameterName,String type,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormField(id);

		checkerOf(userContext).checkLabelOfFormField( label);
		checkerOf(userContext).checkLocaleKeyOfFormField( localeKey);
		checkerOf(userContext).checkParameterNameOfFormField( parameterName);
		checkerOf(userContext).checkTypeOfFormField( type);
		checkerOf(userContext).checkPlaceholderOfFormField( placeholder);
		checkerOf(userContext).checkDefaultValueOfFormField( defaultValue);
		checkerOf(userContext).checkDescriptionOfFormField( description);
		checkerOf(userContext).checkFieldGroupOfFormField( fieldGroup);
		checkerOf(userContext).checkMinimumValueOfFormField( minimumValue);
		checkerOf(userContext).checkMaximumValueOfFormField( maximumValue);
		checkerOf(userContext).checkRequiredOfFormField( required);
		checkerOf(userContext).checkDisabledOfFormField( disabled);
		checkerOf(userContext).checkCustomRenderingOfFormField( customRendering);
		checkerOf(userContext).checkCandidateValuesOfFormField( candidateValues);
		checkerOf(userContext).checkSuggestValuesOfFormField( suggestValues);

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm updateFormFieldProperties(DemodataUserContext userContext, String genericFormId, String id,String label,String localeKey,String parameterName,String type,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormFieldProperties(userContext,genericFormId,id,label,localeKey,parameterName,type,placeholder,defaultValue,description,fieldGroup,minimumValue,maximumValue,required,disabled,customRendering,candidateValues,suggestValues,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormFieldListList()
				.searchFormFieldListWith(FormField.ID_PROPERTY, "is", id).done();

		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);

		if(genericFormToUpdate.getFormFieldList().isEmpty()){
			throw new GenericFormManagerException("FormField is NOT FOUND with id: '"+id+"'");
		}

		FormField item = genericFormToUpdate.getFormFieldList().first();

		item.updateLabel( label );
		item.updateLocaleKey( localeKey );
		item.updateParameterName( parameterName );
		item.updateType( type );
		item.updatePlaceholder( placeholder );
		item.updateDefaultValue( defaultValue );
		item.updateDescription( description );
		item.updateFieldGroup( fieldGroup );
		item.updateMinimumValue( minimumValue );
		item.updateMaximumValue( maximumValue );
		item.updateRequired( required );
		item.updateDisabled( disabled );
		item.updateCustomRendering( customRendering );
		item.updateCandidateValues( candidateValues );
		item.updateSuggestValues( suggestValues );


		//checkParamsForAddingFormField(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormFieldList().done());
		synchronized(genericForm){
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}


	protected FormField createFormField(DemodataUserContext userContext, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception{

		FormField formField = new FormField();
		
		
		formField.setLabel(label);		
		formField.setLocaleKey(localeKey);		
		formField.setParameterName(parameterName);		
		formField.setType(type);		
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
	
		
		return formField;


	}

	protected FormField createIndexedFormField(String id, int version){

		FormField formField = new FormField();
		formField.setId(id);
		formField.setVersion(version);
		return formField;

	}

	protected void checkParamsForRemovingFormFieldList(DemodataUserContext userContext, String genericFormId,
			String formFieldIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		for(String formFieldIdItem: formFieldIds){
			checkerOf(userContext).checkIdOfFormField(formFieldIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormFieldList(DemodataUserContext userContext, String genericFormId,
			String formFieldIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFormFieldList(userContext, genericFormId,  formFieldIds, tokensExpr);


			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				genericFormDaoOf(userContext).planToRemoveFormFieldList(genericForm, formFieldIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormFieldList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFormField(DemodataUserContext userContext, String genericFormId,
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).checkVersionOfFormField(formFieldVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormField(DemodataUserContext userContext, String genericFormId,
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFormField(userContext,genericFormId, formFieldId, formFieldVersion,tokensExpr);

		FormField formField = createIndexedFormField(formFieldId, formFieldVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormField( formField );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			deleteRelationInGraph(userContext, formField);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFormField(DemodataUserContext userContext, String genericFormId,
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).checkVersionOfFormField(formFieldVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm copyFormFieldFrom(DemodataUserContext userContext, String genericFormId,
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFormField(userContext,genericFormId, formFieldId, formFieldVersion,tokensExpr);

		FormField formField = createIndexedFormField(formFieldId, formFieldVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			genericForm.copyFormFieldFrom( formField );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			
			userContext.getManagerGroup().getFormFieldManager().onNewInstanceCreated(userContext, (FormField)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFormField(DemodataUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).checkVersionOfFormField(formFieldVersion);
		

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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}

	public  GenericForm updateFormField(DemodataUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFormField(userContext, genericFormId, formFieldId, formFieldVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFormFieldList().searchFormFieldListWith(FormField.ID_PROPERTY, "eq", formFieldId).done();



		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);

		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormField( formField );
			//make changes to AcceleraterAccount.
			FormField formFieldIndex = createIndexedFormField(formFieldId, formFieldVersion);

			FormField formField = genericForm.findTheFormField(formFieldIndex);
			if(formField == null){
				throw new GenericFormManagerException(formField+" is NOT FOUND" );
			}

			formField.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingFormAction(DemodataUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGenericForm(genericFormId);

		
		checkerOf(userContext).checkLabelOfFormAction(label);
		
		checkerOf(userContext).checkLocaleKeyOfFormAction(localeKey);
		
		checkerOf(userContext).checkActionKeyOfFormAction(actionKey);
		
		checkerOf(userContext).checkLevelOfFormAction(level);
		
		checkerOf(userContext).checkUrlOfFormAction(url);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);


	}
	public  GenericForm addFormAction(DemodataUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFormAction(userContext,genericFormId,label, localeKey, actionKey, level, url,tokensExpr);

		FormAction formAction = createFormAction(userContext,label, localeKey, actionKey, level, url);

		GenericForm genericForm = loadGenericForm(userContext, genericFormId, emptyOptions());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormAction( formAction );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			
			userContext.getManagerGroup().getFormActionManager().onNewInstanceCreated(userContext, formAction);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormActionProperties(DemodataUserContext userContext, String genericFormId,String id,String label,String localeKey,String actionKey,String level,String url,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormAction(id);

		checkerOf(userContext).checkLabelOfFormAction( label);
		checkerOf(userContext).checkLocaleKeyOfFormAction( localeKey);
		checkerOf(userContext).checkActionKeyOfFormAction( actionKey);
		checkerOf(userContext).checkLevelOfFormAction( level);
		checkerOf(userContext).checkUrlOfFormAction( url);

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm updateFormActionProperties(DemodataUserContext userContext, String genericFormId, String id,String label,String localeKey,String actionKey,String level,String url, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormActionProperties(userContext,genericFormId,id,label,localeKey,actionKey,level,url,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormActionListList()
				.searchFormActionListWith(FormAction.ID_PROPERTY, "is", id).done();

		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);

		if(genericFormToUpdate.getFormActionList().isEmpty()){
			throw new GenericFormManagerException("FormAction is NOT FOUND with id: '"+id+"'");
		}

		FormAction item = genericFormToUpdate.getFormActionList().first();

		item.updateLabel( label );
		item.updateLocaleKey( localeKey );
		item.updateActionKey( actionKey );
		item.updateLevel( level );
		item.updateUrl( url );


		//checkParamsForAddingFormAction(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormActionList().done());
		synchronized(genericForm){
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}


	protected FormAction createFormAction(DemodataUserContext userContext, String label, String localeKey, String actionKey, String level, String url) throws Exception{

		FormAction formAction = new FormAction();
		
		
		formAction.setLabel(label);		
		formAction.setLocaleKey(localeKey);		
		formAction.setActionKey(actionKey);		
		formAction.setLevel(level);		
		formAction.setUrl(url);
	
		
		return formAction;


	}

	protected FormAction createIndexedFormAction(String id, int version){

		FormAction formAction = new FormAction();
		formAction.setId(id);
		formAction.setVersion(version);
		return formAction;

	}

	protected void checkParamsForRemovingFormActionList(DemodataUserContext userContext, String genericFormId,
			String formActionIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		for(String formActionIdItem: formActionIds){
			checkerOf(userContext).checkIdOfFormAction(formActionIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormActionList(DemodataUserContext userContext, String genericFormId,
			String formActionIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFormActionList(userContext, genericFormId,  formActionIds, tokensExpr);


			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				genericFormDaoOf(userContext).planToRemoveFormActionList(genericForm, formActionIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormActionList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFormAction(DemodataUserContext userContext, String genericFormId,
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction(formActionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm removeFormAction(DemodataUserContext userContext, String genericFormId,
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFormAction(userContext,genericFormId, formActionId, formActionVersion,tokensExpr);

		FormAction formAction = createIndexedFormAction(formActionId, formActionVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormAction( formAction );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			deleteRelationInGraph(userContext, formAction);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFormAction(DemodataUserContext userContext, String genericFormId,
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGenericForm( genericFormId);
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction(formActionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}
	public  GenericForm copyFormActionFrom(DemodataUserContext userContext, String genericFormId,
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFormAction(userContext,genericFormId, formActionId, formActionVersion,tokensExpr);

		FormAction formAction = createIndexedFormAction(formActionId, formActionVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			genericForm.copyFormActionFrom( formAction );
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			
			userContext.getManagerGroup().getFormActionManager().onNewInstanceCreated(userContext, (FormAction)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFormAction(DemodataUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGenericForm(genericFormId);
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction(formActionVersion);
		

		if(FormAction.LABEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLabelOfFormAction(parseString(newValueExpr));
		
		}
		
		if(FormAction.LOCALE_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocaleKeyOfFormAction(parseString(newValueExpr));
		
		}
		
		if(FormAction.ACTION_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkActionKeyOfFormAction(parseString(newValueExpr));
		
		}
		
		if(FormAction.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormAction(parseString(newValueExpr));
		
		}
		
		if(FormAction.URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUrlOfFormAction(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GenericFormManagerException.class);

	}

	public  GenericForm updateFormAction(DemodataUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFormAction(userContext, genericFormId, formActionId, formActionVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFormActionList().searchFormActionListWith(FormAction.ID_PROPERTY, "eq", formActionId).done();



		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);

		synchronized(genericForm){
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormAction( formAction );
			//make changes to AcceleraterAccount.
			FormAction formActionIndex = createIndexedFormAction(formActionId, formActionVersion);

			FormAction formAction = genericForm.findTheFormAction(formActionIndex);
			if(formAction == null){
				throw new GenericFormManagerException(formAction+" is NOT FOUND" );
			}

			formAction.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(DemodataUserContext userContext, GenericForm newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, GenericForm.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(DemodataUserContext userContext,SmartList<GenericForm> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


