package com.xiaofan.nio;



/**
 * 客户端代码
 * 
 * @author Administrator
 *
 */
public class MyClient {

	public static void main(String[] args) {
		for( int i=0; i<100; i++ ){
			final int idx = i ;
			new Thread( new MyRunnable(idx)).start();
		}
	}
}
