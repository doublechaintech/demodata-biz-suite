
package com.test.demodata.secuserblocking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface SecUserBlockingManager{

		

	public SecUserBlocking createSecUserBlocking(DemodataUserContext userContext, String who, String comments) throws Exception;	
	public SecUserBlocking updateSecUserBlocking(DemodataUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUserBlocking loadSecUserBlocking(DemodataUserContext userContext, String secUserBlockingId, String [] tokensExpr) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(DemodataUserContext userContext, SecUserBlocking secUserBlocking) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(DemodataUserContext userContext, SecUserBlocking secUserBlocking,Map<String,Object>option) throws Exception;
	


	public void delete(DemodataUserContext userContext, String secUserBlockingId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, SecUserBlocking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SecUserManager getSecUserManager(DemodataUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId ,String [] tokensExpr)  throws Exception;
	
	public  SecUserBlocking addSecUser(DemodataUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId , String [] tokensExpr)  throws Exception;
	public  SecUserBlocking removeSecUser(DemodataUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  SecUserBlocking updateSecUser(DemodataUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


