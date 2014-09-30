package com.xiaofan.base.eq;

public class EqualsTest {
	
	public static void main(String[] args){
		new EqualsTest().test2();
	}
	
	public void test(){
		User u1 = new User();
		User u2 = new User();
		boolean b = u1.equals( u2 );
		System.out.println( b );
	}
	
	public void test2(){
		byte[] b1 = new byte[]{ (byte)1, (byte)2 };
		byte[] b2 = new byte[]{ (byte)1, (byte)2 };
		boolean b = b1.equals( b2 );
		System.out.println( b );
	}
	
	
	class User{
		String name;
		int age;
		
		public User(){
		}
	}
	
}
