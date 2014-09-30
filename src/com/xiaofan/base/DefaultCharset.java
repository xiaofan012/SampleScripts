package com.xiaofan.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class DefaultCharset {
	
	/**
	 * 获取系统默认的字符编码集
	 * 
	 * @return 字符编码集名称
	 */
	static public String getDefaultCharsetName(){
		String defaultCharsetName = Charset.defaultCharset().displayName();
		return defaultCharsetName ;
	} 
	
	static public String getDefaultCharsetName2(){
		OutputStreamWriter writer = new OutputStreamWriter( new ByteArrayOutputStream() );
		String charset = writer.getEncoding();
		
		byte[] buffer = new byte[1024];
		InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( buffer ) );
		String charset2 = reader.getEncoding();
		
		return charset;
	}
	
	public static void main(String[] args){
		System.out.println( getDefaultCharsetName() );
		System.out.println( getDefaultCharsetName2() );
		System.out.println( "file.encoding = " + System.getProperty("file.encoding") );
	}
	
//	/**
//	 * 使用第三方jar包获取文档的编码格式
//	 * @param file
//	 * @return
//	 */
//	public Charset getCharsetOfFile( File file ){
//		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();  
//        detector.add(JChardetFacade.getInstance());  
//          
//        Charset charset = null;  
//        try {     
//        	//File file = new File("c:/1.txt");
//            charset = detector.detectCodepage(file.toURL());     
//        }   
//        catch (Exception e) {  
//            e.printStackTrace();  
//        }
//        
//        return charset;
//	}
}
