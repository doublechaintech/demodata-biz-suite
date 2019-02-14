
package com.test.demodata.formfieldmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;

public interface FormFieldMessageManager{

		

	public FormFieldMessage createFormFieldMessage(DemodataUserContext userContext, String title, String parameterName, String formId, String level) throws Exception;	
	public FormFieldMessage updateFormFieldMessage(DemodataUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormFieldMessage loadFormFieldMessage(DemodataUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(DemodataUserContext userContext, FormFieldMessage formFieldMessage) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(DemodataUserContext userContext, FormFieldMessage formFieldMessage,Map<String,Object>option) throws Exception;
	
	public FormFieldMessage transferToAnotherForm(DemodataUserContext userContext, String formFieldMessageId, String anotherFormId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String formFieldMessageId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, FormFieldMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


