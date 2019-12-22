package org.xupan.cms.weixin.kit;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {
	/**
	 * 字符串sha1加密
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest digest = MessageDigest.getInstance("sha1");
			digest.update(str.getBytes());
			byte[] digestMsg = digest.digest();
			for(byte b:digestMsg) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String md5(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(str.getBytes());
			byte[] msg = md.digest();
			for(byte b:msg) {
				sb.append(String.format("%02x",b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
