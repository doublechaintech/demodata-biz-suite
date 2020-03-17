package com.test.demodata;


import com.terapico.caf.viewpage.SerializeScope;

public class DemodataViewScope extends DemodataBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static DemodataViewScope instance = null;
	public static DemodataViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (DemodataViewScope.class) {
			instance = new DemodataViewScope();
		}
		return instance;
	}
}








