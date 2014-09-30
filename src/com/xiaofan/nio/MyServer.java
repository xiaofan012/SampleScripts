package com.xiaofan.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 服务端代码
 * 
 * @author Administrator
 *
 */
public class MyServer {
//	private final static Logger logger = Logger.getLogger( MyServer.class );
	
	public static void main(String[] args) {
		Selector selector = null;
		ServerSocketChannel serverSocketChannel = null;
		
		try{
			selector = Selector.open();
			
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking( false );
			
			
			serverSocketChannel.socket().setReuseAddress( true );
			serverSocketChannel.socket().bind( new InetSocketAddress(9999 ));
			
			serverSocketChannel.register( selector, SelectionKey.OP_ACCEPT );
			
			while( selector.select() > 0 ){
				Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
				
				while( itr.hasNext() ){
					SelectionKey readyKey = itr.next();
					itr.remove();
					
					execute( (ServerSocketChannel) readyKey.channel() );
				}
			}
			
		}
		catch( Exception e ){}
	}
	
	
	private static void execute( ServerSocketChannel serverSocketChannel ) throws IOException{
		SocketChannel socketChannel = null;
		try{
			socketChannel = serverSocketChannel.accept();
			MyRequestObject myRequestObject = receiveData( socketChannel );
			System.out.println( myRequestObject.toString() );
			
			MyResponseObject myResponseObject = new MyResponseObject(
					"response for " + myRequestObject.getName(),
					"response for " + myRequestObject.getValue() );
			sendData( socketChannel, myResponseObject );
			System.out.println( myResponseObject.toString() );
		}
		finally{
			try{
				socketChannel.close();
			}catch(Exception ex){}
		}
	}
	
	private static MyRequestObject receiveData( SocketChannel socketChannel ) throws IOException{
		MyRequestObject myRequestObject = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteBuffer buffer = ByteBuffer.allocate( 1024 );
		
		try{
			byte[] bytes ;
			int size = 0;
			while( ( size = socketChannel.read( buffer ) ) >= 0 ){
				buffer.flip();
				bytes = new byte[size];
				buffer.get( bytes );
				baos.write( bytes );
				buffer.clear();
			}
			bytes = baos.toByteArray();
			Object obj = SerializableUtil.bytesToObj(bytes);
			myRequestObject = (MyRequestObject)obj;
		}
		finally{
			try{
				baos.close();
			}catch(Exception e){}
		}
		
		return myRequestObject;
	}
	
	private static void sendData( SocketChannel socketChannel, MyResponseObject myResponseObject) throws IOException{
		byte[] bytes = SerializableUtil.objToBytes( myResponseObject );
		ByteBuffer buffer = ByteBuffer.wrap( bytes );
		socketChannel.write( buffer );
	}
	
}
