package com.test.demodata.loginhistory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.test.demodata.DemodataObjectPlainCustomSerializer;
public class LoginHistorySerializer extends DemodataObjectPlainCustomSerializer<LoginHistory>{

	@Override
	public void serialize(LoginHistory loginHistory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, loginHistory, provider);
		
	}
}


