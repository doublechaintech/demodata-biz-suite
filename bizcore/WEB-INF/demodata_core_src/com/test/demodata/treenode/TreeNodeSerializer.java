package com.test.demodata.treenode;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.test.demodata.DemodataObjectPlainCustomSerializer;
public class TreeNodeSerializer extends DemodataObjectPlainCustomSerializer<TreeNode>{

	@Override
	public void serialize(TreeNode treeNode, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, treeNode, provider);
		
	}
}








