package com.test.demodata.image;

import com.terapico.utils.RestUtil;

import com.terapico.uccaf.BaseUserContext;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.UserContext;

public class ImageMiddleManager  extends ImageManagerImpl{

	
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
	
		
		return accessOK();
		
		//return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	@Override
	public Image loadImage(DemodataUserContext userContext, String imageId, String[] tokensExpr) throws Exception {
	
		//load images from difference sources and 
		
		//userContext.tokenId();
		//RestClient.builder(hosts)
		//RestUtil.remoteGetObject("", "http://", clazz)
		
		
		return super.loadImage(userContext, imageId, tokensExpr);
	}
	
	
	
	
	
	
}
