package com.xiaofan.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * JavaIO读取文本文件的4种经典代码参考.
 * 
 * 注意：java底层实现能够确保根据文本文件的编码集转换成对应的字节流，
 * 但是字节流转换成字符集的时候，一定要匹配的字符集，否则将成为乱码；
 * 
 * @author Administrator
 * @version v1.0.0
 * @since 2014年9月26日 星期五
 *
 */
public class TextFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextFileReader reader = new TextFileReader();
		
		try{
			String str = reader.readTextFile2( "abc.txt" );
			System.out.println( str );
		}
		catch( IOException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读取文本文件--用FileReader按字符读取
	 * 
	 * @param fileName
	 * @return 文本字符串
	 * @throws IOException
	 */
	public String readTextFile(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
		FileReader fr = null;
		
		try{
			fr = new FileReader( fileName );
			char[] buffer = new char[1024];
			int len ;
			while( (len = fr.read(buffer))!= -1 ){
				sb.append(buffer, 0, len);
			}
			return sb.toString();
		}
		finally{
			if( fr != null )fr.close();
		}
	}
	
	
	/**
	 * 读取文本文件--用FileInputStream按字节读取
	 * 
	 * @param fileName
	 * @return 文本字符串
	 * @throws IOException
	 */
	public String readTextFile2(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = null;
		try{
			fis = new FileInputStream( fileName );
			byte[] buffer = new byte[1024];
			int len;
			while( (len = fis.read(buffer)) != -1 ){
				String temp = new String(buffer, 0, len);
				sb.append(temp);
			}
			return sb.toString();
		}
		finally{
			if( fis != null ) fis.close();
		}
	}
	
	/**
	 * 读取文本文件--用BufferedReader读取
	 * 
	 * @param fileName
	 * @return 文本字符串
	 * @throws IOException
	 */
	public String readTextFile3( String fileName ) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try{
			br = new BufferedReader( new InputStreamReader( new FileInputStream( fileName ), "utf-8" ));
			char[] buffer = new char[1024];
			int len ;
			while(( len = br.read(buffer) ) != -1 ){
				sb.append( buffer, 0, len);
			}
			return sb.toString();
		}
		finally{
			if( br != null ) br.close();
		}
	}
	
	/**
	 * 读取文本文件--用BufferedReader.readLine()按行读取
	 * 
	 * @param fileName
	 * @return 文本字符串
	 * @throws IOException
	 */
	public String readTextFile4(String fileName ) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try{
			br = new BufferedReader( new InputStreamReader( new FileInputStream( fileName ), "utf-8" ));
			String line ;
			while( (line = br.readLine() ) != null ){
				sb.append( line );
				sb.append("\r\n");
			}
			return sb.toString();
		}
		finally{
			if( br != null ) br.close();
		}
	}
	
}
