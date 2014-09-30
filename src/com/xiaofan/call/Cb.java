package com.xiaofan.call;

public class Cb {
	private CommonClass clazz ;
	public Cb( CommonClass c ){
		clazz = c ;
	}
	
	public void callMethod(){
		clazz.method();
	}
}
