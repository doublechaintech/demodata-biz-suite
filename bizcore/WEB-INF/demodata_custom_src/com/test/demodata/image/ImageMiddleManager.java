package com.test.demodata.image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.client.ClientProtocolException;

import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.RestUtil;
import com.test.demodata.DemodataUserContext;

public class ImageMiddleManager  extends ImageManagerImpl{

	
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
	
		
		return accessOK();
		
		//return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	
	public Image loadFromMS(DemodataUserContext userContext, String imageId, String[] tokensExpr) throws Exception {
	
		//load images from difference sources and 
		
		//userContext.tokenId();
		//RestClient.builder(hosts)
		/*
		Image image =(Image) RestUtil.remoteGetObject(userContext.tokenId(), 
				"https://demo.doublechaintech.com/demodata/imageManager/loadImage/I000001/123/", Image.class);
		
		*/
		
		 List<Image> imageList = this.loadImageListFromDifferentServices(userContext, new String[] {"demodata"}, imageId, tokensExpr);
		 
		
		return mergeImageFromMicroservice( userContext, imageList);
	}
	//////////////==========================The microservice infrascture for different managers======================///////////////
	//////////////Loading data from different services and join with a key or more keys specified in tokensExpr///////////////
	
	
	protected List<Image> loadImageListFromDifferentServices(DemodataUserContext userContext,String[] serviceList,String imageId, String[] tokensExpr)
			throws ClientProtocolException, IOException{
		
		 List<Image> imageList = new ArrayList<Image>();

		 Stream.of(serviceList).forEach(serviceName->{
			
			try {
				Image image = loadRemoteImage(userContext,serviceName,imageId,tokensExpr);
				imageList.add(image);
			} catch (ClientProtocolException e) {
				
			} catch (IOException e) {
				
			}
			

		 });
		 
		 userContext.log(imageList.stream().map(item->item.getId()).collect(Collectors.joining(";")));
		 
		 return imageList;
		 
	}
	
	
	protected Image mergeImagesFromMicroservice(DemodataUserContext userContext,Image imageDest, Image imageSrc) {
	
		return (Image)imageSrc.copyTo(imageDest);
		
		
	}
	protected Image mergeImageFromMicroservice(DemodataUserContext userContext,List<Image> imageList) {
		Image image = new Image();
		
		imageList.stream().forEach(srcImage->{
			mergeImagesFromMicroservice(userContext,image,srcImage);
		});
		
		
		return image;
		
		
	}
	protected Image loadRemoteImage(DemodataUserContext userContext, String serviceName,String imageId, String[] tokensExpr) throws ClientProtocolException, IOException {
		return this.loadRemoteObject(userContext.tokenId(), serviceName, imageId, tokensExpr, Image.class);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	protected String packTokens(String[] tokensExpr) {
		return String.join(";", tokensExpr);
	}
	protected<T> T loadRemoteObject(String tokenId, String serviceName,String imageId, String[] tokensExpr, Class<?>clazz) throws ClientProtocolException, IOException {
		String url = "https://demo.doublechaintech.com/"+serviceName+"/imageManager/loadImage/"+imageId+"/"+packTokens(tokensExpr)+"/";
		
		Object object= RestUtil.remoteGetObject(tokenId, url, clazz);
		T image =(T)object ;
		return image;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
}
