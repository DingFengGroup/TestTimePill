package com.dingfeng.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	/*
	 * 转换MD5的一种方式
	 * 任意长度字符串转出的字符串长度都为32
	 */
	private static String toMD5(String plainText) {
		String str = "";
		try {
			// 生成实现指定摘要算法的 MessageDigest 对象。
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 使用指定的字节数组更新摘要。
			md.update(plainText.getBytes());
			// 通过执行诸如填充之类的最终操作完成哈希计算。
			byte b[] = md.digest();
			// 生成具体的md5密码到buf数组
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
				str = buf.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/*
	 * 转换MD5的第二种方式
	 * 当被转换的字符串的长度大于31转出的字符串为31
	 */
	private static String mD5(String str){
		String md5 = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			md5 = (new BigInteger(1,md.digest())).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	/*
	 * 自定义一种方式来加密字符串
	 */
	public static String getMD5(String userName, String password){
		String str = "";
		String userName1 = toMD5(userName+password).substring(0, 16);
		String password1 = toMD5(password).substring(16, 32);
		str = userName1 + password1;
		return str;
	}
}
