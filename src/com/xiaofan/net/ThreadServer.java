package com.xiaofan.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
	static final int PORT_MONITOR = 9999;
	
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket( PORT_MONITOR );
		try{
			while(true){
				Socket socket = server.accept();
				new ServerThreadCode( socket );
			}
		}
		finally{
			server.close();
		}
	}
}
