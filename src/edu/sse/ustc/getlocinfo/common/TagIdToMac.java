package edu.sse.ustc.getlocinfo.common;

public class TagIdToMac {

	public static String transferMac(byte[] b) {
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

}
