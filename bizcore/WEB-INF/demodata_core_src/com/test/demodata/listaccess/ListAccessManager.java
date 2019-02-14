
package com.test.demodata.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface ListAccessManager{

		

	public ListAccess createListAccess(DemodataUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception;	
	public ListAccess updateListAccess(DemodataUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(DemodataUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(DemodataUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(DemodataUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;
	
	public ListAccess transferToAnotherApp(DemodataUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


