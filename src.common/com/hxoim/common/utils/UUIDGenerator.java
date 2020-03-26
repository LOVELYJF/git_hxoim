package com.hxoim.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class UUIDGenerator {
	public static void main(String[] args) {
//		String md5Code = MD5.GetMD5Code("123456");
//		System.out.println(md5Code);
		for (int i = 0; i <12; i++) {
			System.out.println(UUIDGenerator.getPrimaryKey());
		}
	}
	public static String getPrimaryKey(){
        UUID uuid = GuidUtility.createGuidForStrByDatetime(new Date());
        return uuid.toString().toUpperCase();
    }
	//加密
	public static String encryptPwd(String pwd){
		String jmpwd="";
		String passward = "";
		try {
			jmpwd = MD5.GetMD5Code(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		passward = jmpwd.trim();
		return passward;
	}

	/**
	 * MD5加密
	 * @author Kevin
	 */
	public static class MD5 {
		// 全局数组
		private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		// 返回形式为数字跟字符串
		private static String byteToArrayString(byte bByte) {
			int iRet = bByte;
			if (iRet < 0) {
				iRet += 256;
			}
			int iD1 = iRet / 16;
			int iD2 = iRet % 16;
			return strDigits[iD1] + strDigits[iD2];
		}
		// 转换字节数组为16进制字串
		private static String byteToString(byte[] bByte) {
			StringBuffer sBuffer = new StringBuffer();
			for (int i = 0; i < bByte.length; i++) {
				sBuffer.append(byteToArrayString(bByte[i]));
			}
			return sBuffer.toString();
		}
		public static String GetMD5Code(String strObj) {
			String resultString = null;
			try {
				resultString = new String(strObj);
				MessageDigest md = MessageDigest.getInstance("MD5");
				resultString = byteToString(md.digest(strObj.getBytes()));
			} catch (NoSuchAlgorithmException ex) {
				ex.printStackTrace();
			}
			return resultString;
		}
	}
}