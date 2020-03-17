
package com.test.demodata.treenode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;
import com.test.demodata.BaseManager;
import com.test.demodata.SmartList;

public interface TreeNodeManager extends BaseManager{

		

	public TreeNode createTreeNode(DemodataUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception;
	public TreeNode updateTreeNode(DemodataUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TreeNode loadTreeNode(DemodataUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception;
	public TreeNode internalSaveTreeNode(DemodataUserContext userContext, TreeNode treeNode) throws Exception;
	public TreeNode internalSaveTreeNode(DemodataUserContext userContext, TreeNode treeNode,Map<String,Object>option) throws Exception;



	public void delete(DemodataUserContext userContext, String treeNodeId, int version) throws Exception;
	public int deleteAll(DemodataUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(DemodataUserContext userContext, TreeNode newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}












