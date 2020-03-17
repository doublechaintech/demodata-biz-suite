package com.test.demodata.candidateelement;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.test.demodata.DemodataObjectPlainCustomSerializer;
public class CandidateElementSerializer extends DemodataObjectPlainCustomSerializer<CandidateElement>{

	@Override
	public void serialize(CandidateElement candidateElement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, candidateElement, provider);
		
	}
}


