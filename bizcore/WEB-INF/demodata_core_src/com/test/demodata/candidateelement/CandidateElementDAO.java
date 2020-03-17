
package com.test.demodata.candidateelement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.test.demodata.BaseDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;

import com.test.demodata.candidatecontainer.CandidateContainer;

import com.test.demodata.candidatecontainer.CandidateContainerDAO;


public interface CandidateElementDAO extends BaseDAO{

	public SmartList<CandidateElement> loadAll();
	public CandidateElement load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CandidateElement> candidateElementList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CandidateElement present(CandidateElement candidateElement,Map<String,Object> options) throws Exception;
	public CandidateElement clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CandidateElement save(CandidateElement candidateElement,Map<String,Object> options);
	public SmartList<CandidateElement> saveCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options);
	public SmartList<CandidateElement> removeCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options);
	public SmartList<CandidateElement> findCandidateElementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCandidateElementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCandidateElementWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String candidateElementId, int version) throws Exception;
	public CandidateElement disconnectFromAll(String candidateElementId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<CandidateElement> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId, Map<String,Object> options);
 	public int countCandidateElementByContainer(String candidateContainerId, Map<String,Object> options);
 	public Map<String, Integer> countCandidateElementByContainerIds(String[] ids, Map<String,Object> options);
 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId, int start, int count, Map<String,Object> options);
 	public void analyzeCandidateElementByContainer(SmartList<CandidateElement> resultList, String candidateContainerId, Map<String,Object> options);

 
 
}


