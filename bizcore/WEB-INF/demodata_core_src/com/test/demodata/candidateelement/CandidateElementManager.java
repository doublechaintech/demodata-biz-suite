
package com.test.demodata.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface CandidateElementManager extends BaseManager{

		

	public CandidateElement createCandidateElement(DemodataUserContext userContext, String name,String type,String image,String containerId) throws Exception;
	public CandidateElement updateCandidateElement(DemodataUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(DemodataUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(DemodataUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;

	public CandidateElement transferToAnotherContainer(DemodataUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(DemodataUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByContainer(DemodataUserContext userContext,String containerId) throws Exception;
	public Object listPageByContainer(DemodataUserContext userContext,String containerId, int start, int count) throws Exception;
  

}


