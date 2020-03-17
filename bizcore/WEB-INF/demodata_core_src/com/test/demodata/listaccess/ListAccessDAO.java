
package com.test.demodata.listaccess;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.test.demodata.BaseDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;

import com.test.demodata.userapp.UserApp;

import com.test.demodata.userapp.UserAppDAO;


public interface ListAccessDAO extends BaseDAO{

	public SmartList<ListAccess> loadAll();
	public ListAccess load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ListAccess> listAccessList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ListAccess present(ListAccess listAccess,Map<String,Object> options) throws Exception;
	public ListAccess clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ListAccess save(ListAccess listAccess,Map<String,Object> options);
	public SmartList<ListAccess> saveListAccessList(SmartList<ListAccess> listAccessList,Map<String,Object> options);
	public SmartList<ListAccess> removeListAccessList(SmartList<ListAccess> listAccessList,Map<String,Object> options);
	public SmartList<ListAccess> findListAccessWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countListAccessWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countListAccessWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String listAccessId, int version) throws Exception;
	public ListAccess disconnectFromAll(String listAccessId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ListAccess> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ListAccess> findListAccessByApp(String userAppId, Map<String,Object> options);
 	public int countListAccessByApp(String userAppId, Map<String,Object> options);
 	public Map<String, Integer> countListAccessByAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<ListAccess> findListAccessByApp(String userAppId, int start, int count, Map<String,Object> options);
 	public void analyzeListAccessByApp(SmartList<ListAccess> resultList, String userAppId, Map<String,Object> options);

 
 
}


