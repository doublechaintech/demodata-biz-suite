
package com.test.demodata.image;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface ImageManager{

		

	public Image createImage(DemodataUserContext userContext, String name, String imagePath, String platformId) throws Exception;	
	public Image updateImage(DemodataUserContext userContext,String imageId, int imageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Image loadImage(DemodataUserContext userContext, String imageId, String [] tokensExpr) throws Exception;
	public Image internalSaveImage(DemodataUserContext userContext, Image image) throws Exception;
	public Image internalSaveImage(DemodataUserContext userContext, Image image,Map<String,Object>option) throws Exception;
	
	public Image transferToAnotherPlatform(DemodataUserContext userContext, String imageId, String anotherPlatformId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String imageId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, Image newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


