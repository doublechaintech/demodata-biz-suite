package com.test.demodata.formfieldmessage;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.test.demodata.DemodataObjectPlainCustomSerializer;
public class FormFieldMessageSerializer extends DemodataObjectPlainCustomSerializer<FormFieldMessage>{

	@Override
	public void serialize(FormFieldMessage formFieldMessage, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formFieldMessage, provider);
		
	}
}


