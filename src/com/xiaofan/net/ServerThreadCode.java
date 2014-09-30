package com.xiaofan.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadCode extends Thread {
	private Socket socket ;
	private BufferedReader sin;
	private PrintWriter sout ;
	
	@SuppressWarnings("unused")
	private ServerThreadCode(){}
	
	public ServerThreadCode( Socket s ) throws IOException{
		socket = s ;
		sin = new BufferedReader( new InputStreamReader( socket.getInputStream()));
		sout = new PrintWriter( new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) ));
		
		start();
	}
	
	public void run(){
		for( ; ; ){
			try {
				String line = sin.readLine();
				if( "bye".equals( line )){
					break;
				}
				System.out.println("Server Received: " + line);
				sout.println( line );
				sout.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeQuietly();
	}
	
	private void closeQuietly(){
		if( sin != null ){
			try {
				sin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if( sout != null ){
			sout.close();
		}
		if( socket != null ){
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
