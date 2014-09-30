package com.xiaofan.base;

import java.io.UnsupportedEncodingException;

public class MainTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
//		byte[] b = new byte[4];
//		for( int i=0; i<4; i++ ){
//			b[i]=(byte)1;
//		}
//		int i = ByteUtil.byteArraytoInt(b);
//		System.out.println(i);
		
//		int i = 1 << 1 ;
//		System.out.println("i = " + i);
//		
//		int mask = ( 1 << 8 ) * 2 -1 ;
//		
//		println( mask );
//		println( Integer.toBinaryString( mask ));
		
//		byte[] b = new byte[]{1,2,3,4,5};
//		byte[] bytes = new byte[3];
//		System.arraycopy(b, 2, bytes, 0, 3);
//		println( ByteUtil.byteArrayToHexString( bytes ));
//		byte[] bytes2 = ByteUtil.fetchBytes(b, 2, -1);
//		println( ByteUtil.byteArrayToHexString( bytes2 ));
		
//		String str = new String("abc".getBytes(), "utf-8");
//		System.out.println( str );
		
//		String str = "中华人民共和国";
//		byte[] bs = str.getBytes("utf-8");
//		println( bs.length );
		
//		char[] chars = str.toCharArray();
//		println( "length = " + chars.length );
//		for( int i=0; i<chars.length; i++ ){
//			char c = chars[i] ;
//			
//			System.out.println( c  );
//			System.out.println( (int)c );
//		}
		
//		println((1<<24));
		
		
		println( Integer.toBinaryString( 110 ));
		
//		int mask = 
		
//		println( Integer.toBinaryString( Integer.MIN_VALUE ));
//		println( Integer.toBinaryString( -1 ));
		
		
//		println( Integer.toBinaryString( mask ));
//		println( Integer.toBinaryString( 110 <<4 >>4 ) );
		
	}
	
	static void println(Object o){
		String str = o == null ? "NULL" : o.toString();
		System.out.println( str );
	}

}
