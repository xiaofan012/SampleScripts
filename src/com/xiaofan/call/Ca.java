package com.xiaofan.call;

public class Ca {
	private CommonClass clazz ;
	public Ca( CommonClass c ){
		clazz = c ;
	}
	
	public void callMethod(){
		clazz.method();
	}
}
