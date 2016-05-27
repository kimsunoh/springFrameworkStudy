package com.kitri.util;

public class Encoder {
	
	public static String isoToEuc(String tmp) {
		String euc = "";
		try {
			if (tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "EUC-KR");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return euc;
	}
}
