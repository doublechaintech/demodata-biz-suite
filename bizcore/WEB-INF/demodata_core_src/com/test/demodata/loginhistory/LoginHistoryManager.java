
package com.test.demodata.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface LoginHistoryManager extends BaseManager{

		

	public LoginHistory createLoginHistory(DemodataUserContext userContext, String fromIp,String description,String secUserId) throws Exception;
	public LoginHistory updateLoginHistory(DemodataUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(DemodataUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(DemodataUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(DemodataUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;

	public LoginHistory transferToAnotherSecUser(DemodataUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(DemodataUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(DemodataUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


