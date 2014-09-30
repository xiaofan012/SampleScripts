package com.xiaofan.base;

public class BinaryMath {
	
	/**
	 * 二进制实现加法运算.
	 * @param num1
	 * @param num2
	 * @return
	 */
	static public int add( int num1, int num2){
		/* 
		//递归实现
		if( num2 == 0 ) //没有进位的时候完成运算
			return num1;
		
		int sum =0, carry = 0;
		sum = num1^num2; //完成第一步没有进位的加法运算
		carry = (num1&num2)<<1; //完成第二步进位并左移运算
		return addWithoutArithmetic( sum, carry ); //进行递归，相加
		*/
		/*
		//非递归实现
		int ans = 0;
		while( num2 != 0 ){
			if( (num2&1) != 0 ){
				ans = add( ans, num1 );
			}
			num1 = (num1 << 1);
			num2 = (num2 >> 1);
		}
		return ans;
		*/
		return num2 == 0 ? add( (num1^num2), (num1&num2)<<1 ) : num1;
	} 
	
	//取补码
	static private int negtive( int a ){
		return add(~a, 1);
	}
	
	/**
	 * 二进制实现减法运算
	 * @param num1
	 * @param num2
	 * @return
	 */
	static public int sub( int num1, int num2 ){
		return add( num1, negtive( num2 ) );
	}
	
	/**
	 * 二进制正整数乘法
	 * @param num1
	 * @param num2
	 * @return
	 */
	static public int multiply( int num1, int num2 ){
		int ans = 0;
		while( num2 != 0 ){
			if( (num2 & 1) == 1 ){
				ans = add( ans, num1 );
				num1 = ( num1 << 1);
				num2 = ( num2 >> 1 );
			}
		}
		return ans ;
	}
	
	/**
	 * 二进制正整数除法.
	 * 
	 * 除法就是由乘法的过程逆推，依次减掉（如果x够减的）y^(2^31),y^(2^30),...y^8,y^4,y^2,y^1.
	 * 减掉相应数量的y就在结果加上相应的数量
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	static public int divide( int x, int y ){
		int ans = 0;
		for( int i=31; i>=0; i--){
			//比较x是否大于y的(1<<i)次方，避免将x与(y<<i)比较，因为不确定y的(1<<i)次方是否溢出
			if( ( x >> i) >= y ){
				ans += ( 1 << i );
				x -= ( y << i );
			}
		}
		return ans ;
	}
	
	public static void main(String[] args){
		System.out.println( add( 2, 3 ));
		System.out.println( add( -3, 3 ));
		System.out.println( add( -3, 5 ));
		System.out.println( add( Integer.MAX_VALUE, -1 )); 	
	}
}
