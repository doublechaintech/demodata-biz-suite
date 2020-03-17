
package com.test.demodata.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface UserAppManager extends BaseManager{

		

	public UserApp createUserApp(DemodataUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception;
	public UserApp updateUserApp(DemodataUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(DemodataUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public UserApp internalSaveUserApp(DemodataUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(DemodataUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;

	public UserApp transferToAnotherSecUser(DemodataUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  QuickLinkManager getQuickLinkManager(DemodataUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;

	public  UserApp addQuickLink(DemodataUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(DemodataUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(DemodataUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(DemodataUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;

	public  UserApp addListAccess(DemodataUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(DemodataUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(DemodataUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ObjectAccessManager getObjectAccessManager(DemodataUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 ,String [] tokensExpr)  throws Exception;

	public  UserApp addObjectAccess(DemodataUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 , String [] tokensExpr)  throws Exception;
	public  UserApp removeObjectAccess(DemodataUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateObjectAccess(DemodataUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(DemodataUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(DemodataUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


