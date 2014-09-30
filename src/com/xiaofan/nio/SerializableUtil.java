package com.xiaofan.nio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * 将java对象序列化成字节数组或者把字节数组反序列化成java对象
 * 
 * @author Administrator
 *
 */
public class SerializableUtil {
	
	public static byte[] objToBytes( Object obj ){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream( baos );
			oos.writeObject( obj );
			byte[] bytes = baos.toByteArray();
			return bytes;
		}
		catch( IOException e){
			throw new RuntimeException( e.getMessage(), e );
		}
		finally{
			try{
				oos.close();
			}
			catch(Exception e){}
		}
	}
	
	
	public static Object bytesToObj( byte[] bytes ){
		ByteArrayInputStream bais = new ByteArrayInputStream( bytes );
		ObjectInputStream ois = null;
		try{
			ois = new ObjectInputStream( bais );
			Object obj = ois.readObject();
			return obj;
		}
		catch(IOException e){
			throw new RuntimeException( e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException( e.getMessage(), e );
		}
		finally{
			try{
				ois.close();
			}
			catch( Exception e ){}
		}
	}
	
}
