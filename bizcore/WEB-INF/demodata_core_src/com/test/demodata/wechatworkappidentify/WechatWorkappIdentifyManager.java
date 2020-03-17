
package com.test.demodata.wechatworkappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface WechatWorkappIdentifyManager extends BaseManager{

		

	public WechatWorkappIdentify createWechatWorkappIdentify(DemodataUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatWorkappIdentify updateWechatWorkappIdentify(DemodataUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify loadWechatWorkappIdentify(DemodataUserContext userContext, String wechatWorkappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(DemodataUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(DemodataUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object>option) throws Exception;

	public WechatWorkappIdentify transferToAnotherSecUser(DemodataUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String wechatWorkappIdentifyId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, WechatWorkappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(DemodataUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(DemodataUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


