
package com.test.demodata.treenode;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.test.demodata.BaseDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;




public interface TreeNodeDAO extends BaseDAO{

	public SmartList<TreeNode> loadAll();
	public TreeNode load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TreeNode> treeNodeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TreeNode present(TreeNode treeNode,Map<String,Object> options) throws Exception;
	public TreeNode clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TreeNode save(TreeNode treeNode,Map<String,Object> options);
	public SmartList<TreeNode> saveTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options);
	public SmartList<TreeNode> removeTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options);
	public SmartList<TreeNode> findTreeNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTreeNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTreeNodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String treeNodeId, int version) throws Exception;
	public TreeNode disconnectFromAll(String treeNodeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TreeNode> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

}








