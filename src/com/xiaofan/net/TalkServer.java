package com.xiaofan.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 本例为简单的Socket聊天程序，只支持一个客户端接入一次.<br>
 * 
 * <p>当通信的一方断开后，另一方再尝试发消息时，会抛出如下错误
 * <pre>
 * java.net.SocketException: Connection reset
		at java.net.SocketInputStream.read(SocketInputStream.java:168)
		at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:264)
		at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:306)
		at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:158)
		at java.io.InputStreamReader.read(InputStreamReader.java:167)
		at java.io.BufferedReader.fill(BufferedReader.java:136)
		at java.io.BufferedReader.readLine(BufferedReader.java:299)
		at java.io.BufferedReader.readLine(BufferedReader.java:362)
		at com.xiaofan.net.TalkServer.main(TalkServer.java:29)
 * </pre>
 * 
 * 
 * @author Administrator
 *
 */
public class TalkServer {
	static int PORT_MONITOR = 9999 ;
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket socket = null;
		
		server = new ServerSocket( PORT_MONITOR );
		System.out.println("SocketServer已经启动，并准备好监听端口9999了...");
		
		//阻塞，直到有客户端连接
		socket = server.accept();
		
		try{
			BufferedReader sin = new BufferedReader( new InputStreamReader( System.in ));
			BufferedReader is = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
			PrintWriter os = new PrintWriter( socket.getOutputStream() );
			
			System.out.println( "Client:" + is.readLine() );
			String line = null;
			line = sin.readLine();
			while( !"bye".equals( line )){
				os.println( line );
				os.flush();
				System.out.println("Server:" + line );
				System.out.println("Client:" + is.readLine() );
				
				line = sin.readLine();
			}
			
			is.close();
			os.close();
			sin.close();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		finally{
			socket.close();
		}
	}
}
