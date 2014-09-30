package com.xiaofan.call;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonClass {
	public synchronized void method(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("method began to work ..., time = " + format.format( new Date() ) );
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method finished, time = " + format.format( new Date() ));
	}
}
