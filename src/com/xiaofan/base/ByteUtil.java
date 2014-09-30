package com.xiaofan.base;

public class ByteUtil {
	/**
	 * 将整型转换为4字节数组.
	 * 
	 * @param value
	 * @return byte[4] 从左到右，分别对应从高到低
	 */
	public static byte[] intToByteArray(int value) {
		byte[] b = new byte[4];
		// 使用4个byte表示int
		for (int i = 0; i < 4; i++) {
			int offset = (b.length - 1 - i) * 8; // 偏移量
			b[i] = (byte) ((value >> offset) & 0xFF); // 每次取8bit
		}
		return b;
	}
	
	/**
	 * 将字节数组转换为整型.
	 * 
	 * @param bRefArr 数组长度一般为4，不足时则高位补零
	 * @return
	 */
	public static int byteArraytoInt(byte[] bRefArr) {
		if (bRefArr == null) {
			return 0;
		}
		if (bRefArr.length < 4) {
			byte[] bArr = new byte[4];
			for (int i = 0; i < 4 - bRefArr.length; i++) {
				bArr[i] = 0x00;
			}
			System.arraycopy(bRefArr, 0, bArr, 4 - bRefArr.length,
					bRefArr.length);
			bRefArr = bArr;
		}
		int mask = 0xff;
		int temp = 0;
		int n = 0;
		for (int i = 0; i < 4; i++) {
			n <<= 8;
			temp = bRefArr[i] & mask;
			n |= temp;
		}
		return n;
	}
	
	/**
	 * 计算各字节的算术和，并最终转为byte.
	 * 
	 * @param data 约定字节数组 data[] 不能为空
	 * @return byte 
	 */
	public static byte checkSum(byte[] data) {
		int checkSum = 0;
		for (int i = 0; i < data.length; i++) {
			checkSum += (data[i] & 0xff);
		}
		return (byte) checkSum;
	}
	
	/**
	 * 将字节转为十六进制字符串，不足两位的前面补零
	 * @param src
	 * @return
	 */
	public static String byteToHexString(byte src) {
		int v = src & 0xFF;
		String hex = Integer.toHexString(v).toUpperCase();
		if (hex.length() < 2) {
			hex = '0' + hex;
		}
		return hex;
	}
	
	/**
	 * 将字节数组转为十六进制字符串，每个字节占两个字符.
	 * @param src 约定字节数组 src[] 不能为空
	 * @return
	 */
	public static String byteArrayToHexString( byte[] src ){
		StringBuilder hexString = new StringBuilder();
		int len = src.length;
		for( int i=0; i<len; i++){
			hexString.append( byteToHexString( src[i] ));
		}
		return hexString.toString();
	}
	
	/**
	 * 将十六进制字符串转为字节数组
	 * @param hexString 两个十六进制字符标识一个字节，理论上字符串长度应该为2的整数倍
	 * @return
	 */
	public static byte[] hexStringToByteArray(String hexString){
		if( hexString == null || hexString.length() == 0 ){
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	
	/**
	 * 从字节数组中截取一部分构成新的字节数组
	 * 
	 * @param src 源字节数组
	 * @param srcPos 开始位置， srcPos >= 0
	 * @param copyLength 长度， length >= 0
	 * @return 对参数不正确的情况,返回null
	 */
	public static byte[] fetchBytes(byte[] src, int srcPos, int length) {
		byte[] bytes = new byte[length];
		System.arraycopy(src, srcPos, bytes, 0, length);
		return bytes;
	}
	
	/**
	 * 将一个十六进制字符char转为一个字节
	 * @param hexChar 十六进制字符
	 * @return
	 */
	private static byte charToByte(char hexChar){
		return (byte) "0123456789ABCDEF".indexOf(hexChar);
	}
	
	
	public static String intToByteString( int num ){
//		StringBuilder buffer = new StringBuilder();
//		for( int i=1; i<=32; i++ ){
//			int index = 32 - i ;
//			int ret = (num & (1<<index));
//			ret = (ret >> num);
//			if( ret != 0 ){
//				buffer.append( Integer.toString(ret) );
//			}
//		}
//		
//		return buffer.toString();
		
		return Integer.toBinaryString( num );
		
	}
	
	
}
