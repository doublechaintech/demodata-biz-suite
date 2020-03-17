
package com.test.demodata.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface CandidateContainerManager extends BaseManager{

		

	public CandidateContainer createCandidateContainer(DemodataUserContext userContext, String name) throws Exception;
	public CandidateContainer updateCandidateContainer(DemodataUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(DemodataUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(DemodataUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;



	public void delete(DemodataUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CandidateElementManager getCandidateElementManager(DemodataUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;

	public  CandidateContainer addCandidateElement(DemodataUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(DemodataUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(DemodataUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


