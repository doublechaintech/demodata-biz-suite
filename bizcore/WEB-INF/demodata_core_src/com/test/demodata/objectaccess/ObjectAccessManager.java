
package com.test.demodata.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface ObjectAccessManager extends BaseManager{

		

	public ObjectAccess createObjectAccess(DemodataUserContext userContext, String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String appId) throws Exception;
	public ObjectAccess updateObjectAccess(DemodataUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(DemodataUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(DemodataUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(DemodataUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;

	public ObjectAccess transferToAnotherApp(DemodataUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(DemodataUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(DemodataUserContext userContext,String appId, int start, int count) throws Exception;
  

}


