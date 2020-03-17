
package com.test.demodata.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface QuickLinkManager extends BaseManager{

		

	public QuickLink createQuickLink(DemodataUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;
	public QuickLink updateQuickLink(DemodataUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(DemodataUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(DemodataUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(DemodataUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;

	public QuickLink transferToAnotherApp(DemodataUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(DemodataUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(DemodataUserContext userContext,String appId, int start, int count) throws Exception;
  

}


