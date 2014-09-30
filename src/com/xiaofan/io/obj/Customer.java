package com.xiaofan.io.obj;

import java.io.Serializable;

/**
 * 
 * 序列化类Customer<p>
 * 
 * 必须实现Serializable接口，最好声明serialVersionUID常量；
 * 
 * @author Administrator
 *
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1l; 
	
	private String name ;
	private int age;
	private String gender;
	
	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("name:" + getName()).append(",")
			.append("age:"+getAge()).append(",")
			.append("gender:" + getGender())
			.append("}");
		return sb.toString();
	}
}
