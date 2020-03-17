
package com.test.demodata.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface WechatMiniappIdentifyManager extends BaseManager{

		

	public WechatMiniappIdentify createWechatMiniappIdentify(DemodataUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentify updateWechatMiniappIdentify(DemodataUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify loadWechatMiniappIdentify(DemodataUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(DemodataUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(DemodataUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentify transferToAnotherSecUser(DemodataUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, WechatMiniappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(DemodataUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(DemodataUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


