package com.xiaofan.nio;

import java.io.Serializable;

/**
 * 
 * 客户端发出的请求
 * 
 * @author Administrator
 *
 */
public class MyRequestObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name ;
	private String value ;
	private byte[] bytes;
	
	public MyRequestObject( String name, String value ){
		this.name = name ;
		this.value = value ;
		this.bytes = new byte[ 1024 ];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Request[ name: " + name + ", ")
			.append("value: " + value + ", ")
			.append(" bytes: " + bytes.length + " ]");
		
		return sb.toString();
	}

}
