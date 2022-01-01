package Homework2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	public static String getSHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i =0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) +
						0x100, 16).substring(1));
			}
			SHA = sb.toString();
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
	
	public static boolean isFloat(String value) {
		try {
			Float.parseFloat(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

	public static boolean isInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
		
	}
	
	public static String doHash(String str) {
		while(true) {
			str = Utils.getSHA256(str);
			if(str.charAt(0) == '0' &&str.charAt(1) == '0' &&str.charAt(2) == '0' )
				return str;
		}
	}
}
