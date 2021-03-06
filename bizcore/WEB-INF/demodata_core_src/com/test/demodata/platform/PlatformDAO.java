
package com.test.demodata.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.test.demodata.BaseDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;

import com.test.demodata.image.Image;

import com.test.demodata.image.ImageDAO;


public interface PlatformDAO extends BaseDAO{

	public SmartList<Platform> loadAll();
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ImageDAO getImageDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForImage(DemodataUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveImageList(Platform platform, String imageIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:Image的platform的ImageList
	public SmartList<Image> loadOurImageList(DemodataUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
}


