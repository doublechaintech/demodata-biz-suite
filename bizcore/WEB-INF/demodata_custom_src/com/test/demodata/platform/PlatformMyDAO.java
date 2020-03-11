package com.test.demodata.platform;

import java.util.Map;

import com.test.demodata.MultipleAccessKey;
import com.test.demodata.SmartList;

public class PlatformMyDAO extends PlatformJDBCTemplateDAO {
	
	
	public SmartList<Platform> findPlatformWithKeyX(MultipleAccessKey key, Map<String, Object> options) {
		// TODO Auto-generated method stub
		
		
		return super.queryList("select * from user where sdfsd=?", parameters);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
