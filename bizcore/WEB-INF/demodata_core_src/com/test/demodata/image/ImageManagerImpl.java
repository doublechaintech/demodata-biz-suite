
package com.test.demodata.image;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.test.demodata.BaseEntity;


import com.test.demodata.Message;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;

import com.test.demodata.DemodataUserContext;
//import com.test.demodata.BaseManagerImpl;
import com.test.demodata.DemodataCheckerManager;
import com.test.demodata.CustomDemodataCheckerManager;

import com.test.demodata.platform.Platform;

import com.test.demodata.platform.CandidatePlatform;







public class ImageManagerImpl extends CustomDemodataCheckerManager implements ImageManager {
	
	private static final String SERVICE_TYPE = "Image";
	
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
 
 		userContext.getChecker().checkIdOfImage(imageId);
		userContext.getChecker().throwExceptionIfHasErrors( ImageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Image image = loadImage( userContext, imageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,image, tokens);
 	}
 	
 	
 	 public Image searchImage(DemodataUserContext userContext, String imageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfImage(imageId);
		userContext.getChecker().throwExceptionIfHasErrors( ImageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Image image = loadImage( userContext, imageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,image, tokens);
 	}
 	
 	

 	protected Image present(DemodataUserContext userContext, Image image, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,image,tokens);
		
		
		Image  imageToPresent = userContext.getDAOGroup().getImageDAO().present(image, tokens);
		
		List<BaseEntity> entityListToNaming = imageToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getImageDAO().alias(entityListToNaming);
		
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
 		return userContext.getDAOGroup().getImageDAO().save(image, tokens);
 	}
 	protected Image loadImage(DemodataUserContext userContext, String imageId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfImage(imageId);
		userContext.getChecker().throwExceptionIfHasErrors( ImageManagerException.class);

 
 		return userContext.getDAOGroup().getImageDAO().load(imageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Image image, Map<String, Object> tokens){
		super.addActions(userContext, image, tokens);
		
		addAction(userContext, image, tokens,"@create","createImage","createImage/","main","primary");
		addAction(userContext, image, tokens,"@update","updateImage","updateImage/"+image.getId()+"/","main","primary");
		addAction(userContext, image, tokens,"@copy","cloneImage","cloneImage/"+image.getId()+"/","main","primary");
		
		addAction(userContext, image, tokens,"image.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+image.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(DemodataUserContext userContext, Image image, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Image createImage(DemodataUserContext userContext,String name, String image, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfImage(name);
		userContext.getChecker().checkImageOfImage(image);
	
		userContext.getChecker().throwExceptionIfHasErrors(ImageManagerException.class);


		Image image=createNewImage();	

		image.setName(name);
		image.setImage(image);
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
		

		
		
		userContext.getChecker().checkIdOfImage(imageId);
		userContext.getChecker().checkVersionOfImage( imageVersion);
		

		if(Image.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfImage(parseString(newValueExpr));
		}
		if(Image.IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkImageOfImage(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ImageManagerException.class);
	
		
	}
	
	
	
	public Image clone(DemodataUserContext userContext, String fromImageId) throws Exception{
		
		return userContext.getDAOGroup().getImageDAO().clone(fromImageId, this.allTokens());
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
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ImageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(DemodataUserContext userContext, String imageId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfImage(imageId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ImageManagerException.class);
 		
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForImage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(DemodataUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(DemodataUserContext userContext, String imageId, int imageVersion) throws Exception {
		//deleteInternal(userContext, imageId, imageVersion);		
	}
	protected void deleteInternal(DemodataUserContext userContext,
			String imageId, int imageVersion) throws Exception{
			
		userContext.getDAOGroup().getImageDAO().delete(imageId, imageVersion);
	}
	
	public Image forgetByAll(DemodataUserContext userContext, String imageId, int imageVersion) throws Exception {
		return forgetByAllInternal(userContext, imageId, imageVersion);		
	}
	protected Image forgetByAllInternal(DemodataUserContext userContext,
			String imageId, int imageVersion) throws Exception{
			
		return userContext.getDAOGroup().getImageDAO().disconnectFromAll(imageId, imageVersion);
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
		return userContext.getDAOGroup().getImageDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(DemodataUserContext userContext, Image newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


