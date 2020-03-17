
package com.test.demodata.image;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.test.demodata.BaseDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;

import com.test.demodata.platform.Platform;

import com.test.demodata.platform.PlatformDAO;


public interface ImageDAO extends BaseDAO{

	public SmartList<Image> loadAll();
	public Image load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Image> imageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Image present(Image image,Map<String,Object> options) throws Exception;
	public Image clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Image save(Image image,Map<String,Object> options);
	public SmartList<Image> saveImageList(SmartList<Image> imageList,Map<String,Object> options);
	public SmartList<Image> removeImageList(SmartList<Image> imageList,Map<String,Object> options);
	public SmartList<Image> findImageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countImageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countImageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String imageId, int version) throws Exception;
	public Image disconnectFromAll(String imageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Image> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Image> findImageByPlatform(String platformId, Map<String,Object> options);
 	public int countImageByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countImageByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Image> findImageByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeImageByPlatform(SmartList<Image> resultList, String platformId, Map<String,Object> options);

 
 
}


