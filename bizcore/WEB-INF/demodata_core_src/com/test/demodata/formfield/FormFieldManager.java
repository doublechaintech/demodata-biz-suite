
package com.test.demodata.formfield;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface FormFieldManager extends BaseManager{

		

	public FormField createFormField(DemodataUserContext userContext, String label,String localeKey,String parameterName,String type,String formId,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues) throws Exception;
	public FormField updateFormField(DemodataUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormField loadFormField(DemodataUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception;
	public FormField internalSaveFormField(DemodataUserContext userContext, FormField formField) throws Exception;
	public FormField internalSaveFormField(DemodataUserContext userContext, FormField formField,Map<String,Object>option) throws Exception;

	public FormField transferToAnotherForm(DemodataUserContext userContext, String formFieldId, String anotherFormId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String formFieldId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, FormField newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByForm(DemodataUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(DemodataUserContext userContext,String formId, int start, int count) throws Exception;
  

}


