package edu.sse.ustc.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.sse.ustc.database.dao.helper.VendorHelper;

public class Helper {

	public static void main(String[] args) {

		System.out.println(stringToDate("2015-7-7 9:37:00"));

	}

	public static Date stringToDate(String str) {

		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = fmt.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), "edu.sse.ustc.common.Helper");
			// e.printStackTrace();
		}

		return date;
	}

	public static String dateToString(Date date) throws ParseException {

		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = fmt.format(date);

		return str;
	}

	public static String BytesToHexString(byte[] b) {
		StringBuilder mac = new StringBuilder();

		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				mac.append(0);
			}
			mac.append(hv);
			if (i != (b.length - 1))
				mac.append(":");
		}
		return mac.toString();
	}

	public static String getVendor(String mac) {
		String rs = VendorHelper.getVendor(mac.toUpperCase());
		if (rs==null)
			return "Unknown";
		else
			return rs;
	}
}
