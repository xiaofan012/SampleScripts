package com.xiaofan.io.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本类实现对象写入文件及从文件读取对象
 * 
 * @author Administrator
 *
 */
public class ObjectIODemo {
	public static void main(String[] args){
		File file = new File("oos.obj");
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(file));
			Customer customer = new Customer("中国人", 23);
			
			oos.writeObject("你好！");
			oos.writeObject(new Date());
			oos.writeObject( customer );
			oos.writeInt( 123 );
			
			List list = new ArrayList();
			for( int i=1; i<=10; i++ ){
				list.add( new Customer("小"+i, i));
			}
			oos.writeObject(list);
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file));
			System.out.println("obj1=" + (String)ois.readObject());
			System.out.println("obj2=" + (Date)ois.readObject());
			System.out.println("obj3=" + (Customer)ois.readObject());
			System.out.println("obj4=" + ois.readInt() );
			System.out.println("obj5=" + (List)ois.readObject());
			
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
