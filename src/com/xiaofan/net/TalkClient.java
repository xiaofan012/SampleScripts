package com.xiaofan.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
	static int SERVER_PORT = 9999 ;
	public static void main(String[] args) throws IOException {
		//向本机的9999端口发出客户请求
		Socket socket = new Socket("127.0.0.1", SERVER_PORT);
		/*
		SocketAddress serverAddr = new InetSocketAddress( "127.0.0.1", 9999 );
		Socket socket = new Socket();
		socket.connect( serverAddr, 2000 );
		*/
		
		try{
			BufferedReader sin = new BufferedReader( new InputStreamReader( System.in ));
			
			PrintWriter os = new PrintWriter( socket.getOutputStream() );
			BufferedReader is = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
			
			String readLine = null;
			readLine = sin.readLine();
			while( !"bye".equals( readLine )){
				os.println( readLine );
//				os.write( readLine );
				os.flush();
				System.out.println("Client:" + readLine);
				System.out.println("Server:" + is.readLine() );
				
				readLine = sin.readLine();
			}
			os.close();
			is.close();
			
			sin.close();
		}
		catch( Exception e){
			e.printStackTrace();
		}
		finally{
			socket.close();
		}
	}
}
