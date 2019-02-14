
package com.test.demodata.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(DemodataUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(DemodataUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(DemodataUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(DemodataUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(DemodataUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(DemodataUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














