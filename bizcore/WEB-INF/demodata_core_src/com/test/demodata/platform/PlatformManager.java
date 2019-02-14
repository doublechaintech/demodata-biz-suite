
package com.test.demodata.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(DemodataUserContext userContext, String name) throws Exception;	
	public Platform updatePlatform(DemodataUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(DemodataUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(DemodataUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(DemodataUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(DemodataUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ImageManager getImageManager(DemodataUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addImage(DemodataUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeImage(DemodataUserContext userContext, String platformId, String imageId, int imageVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateImage(DemodataUserContext userContext, String platformId, String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


