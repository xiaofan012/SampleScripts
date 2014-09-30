package com.xiaofan.call;

public class Main {
	static CommonClass commonClass = new CommonClass();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		new Ca(commonClass).callMethod();
//		new Cb(commonClass).callMethod();
		
		new Thread( new Runnable(){
			public void run(){
//				new Ca(commonClass).callMethod();
				new Ca( new CommonClass() ).callMethod();
			}
		}).start();
		
		new Thread( new Runnable(){
			public void run(){
//				new Cb(commonClass).callMethod();
				new Ca( new CommonClass() ).callMethod();
			}
		}).start();
	}

}
