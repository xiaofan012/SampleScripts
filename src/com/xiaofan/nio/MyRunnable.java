package com.xiaofan.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MyRunnable implements Runnable {
	private final int idx ;
	
	public MyRunnable( int idx ){
		this.idx = idx ;
	}
	
	public void run(){
		SocketChannel socketChannel = null;
		try{
			socketChannel = SocketChannel.open();
			SocketAddress socketAddress = new InetSocketAddress( "localhost", 9999 );
			socketChannel.connect( socketAddress );
			
			MyRequestObject myRequestObj = new MyRequestObject( "request_"+idx, "request_" + idx);
			System.out.println( myRequestObj.toString() );
			sendData( socketChannel, myRequestObj );
			
			MyResponseObject myResponseObj = receiveData( socketChannel );
			System.out.println( myResponseObj );
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		finally{
			try{
				socketChannel.close();
			}catch(Exception e){}
		}
	}
	
	private void sendData( SocketChannel socketChannel, MyRequestObject myRequestObj ) throws IOException{
		byte[] bytes = SerializableUtil.objToBytes( myRequestObj );
		ByteBuffer buffer = ByteBuffer.wrap( bytes );
		socketChannel.write( buffer );
		socketChannel.socket().shutdownOutput();
	}
	
	private MyResponseObject receiveData( SocketChannel socketChannel ) throws IOException{
		MyResponseObject myResponseObj = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try{
			ByteBuffer buffer = ByteBuffer.allocate( 1024 );
			byte[] bytes;
			int size = 0;
			while( (size = socketChannel.read( buffer )) >= 0 ){
				buffer.flip();
				bytes = new byte[ size ];
				buffer.get( bytes );
				baos.write( bytes );
				buffer.clear();
			}
			bytes = baos.toByteArray();
			Object obj = SerializableUtil.bytesToObj( bytes );
			myResponseObj = (MyResponseObject) obj ;
			socketChannel.socket().shutdownOutput();
		}
		finally{
			try{
				baos.close();
			}catch(Exception e){}
		}
		
		return myResponseObj;
	}
}
