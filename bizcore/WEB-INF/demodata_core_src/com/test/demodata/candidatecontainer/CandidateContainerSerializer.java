package com.test.demodata.candidatecontainer;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.test.demodata.DemodataObjectPlainCustomSerializer;
public class CandidateContainerSerializer extends DemodataObjectPlainCustomSerializer<CandidateContainer>{

	@Override
	public void serialize(CandidateContainer candidateContainer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, candidateContainer, provider);
		
	}
}


