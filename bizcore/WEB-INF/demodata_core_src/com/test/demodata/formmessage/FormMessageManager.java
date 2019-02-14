
package com.test.demodata.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(DemodataUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(DemodataUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(DemodataUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(DemodataUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(DemodataUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(DemodataUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


