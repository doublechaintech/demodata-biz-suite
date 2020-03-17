
package com.test.demodata.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(DemodataUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(DemodataUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(DemodataUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(DemodataUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(DemodataUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(DemodataUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(DemodataUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(DemodataUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(DemodataUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(DemodataUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(DemodataUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(DemodataUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(DemodataUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(DemodataUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(DemodataUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(DemodataUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(DemodataUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(DemodataUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentify(DemodataUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentify(DemodataUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentify(DemodataUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(DemodataUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentify(DemodataUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentify(DemodataUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentify(DemodataUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(DemodataUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(DemodataUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


