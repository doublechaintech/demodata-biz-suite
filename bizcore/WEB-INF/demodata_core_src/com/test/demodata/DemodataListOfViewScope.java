package com.test.demodata;

public class DemodataListOfViewScope extends BaseDemodataListOfViewScope {

	protected static DemodataListOfViewScope instance = new DemodataListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static DemodataListOfViewScope getInstance() {
		return instance;
	}
}






