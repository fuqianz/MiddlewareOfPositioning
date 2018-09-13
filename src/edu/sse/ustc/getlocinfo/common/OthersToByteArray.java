package edu.sse.ustc.getlocinfo.common;


public class OthersToByteArray {

	public static byte[] intToByteArray(Integer it) {

		byte[] ba = new byte[4];

		ba[0] = (byte) (it & (0xFF));
		ba[1] = (byte) ((it >> 8) & (0xFF));
		ba[2] = (byte) ((it >> 16) & (0xFF));
		ba[3] = (byte) ((it >> 24) & (0xFF));

		return ba;
	}

	public static byte[] shortToByteArray(short it) {

		byte[] ba = new byte[2];

		ba[0] = (byte) (it & (0xFF));
		ba[1] = (byte) ((it >> 8) & (0xFF));

		return ba;
	}

	public static byte[] stringToByteArray(String str) {

		return str.getBytes();
	}

	// public static void main(String argc[]) {
	//
	// Integer it = 8;
	// byte[] ba = intToByteArray(it);
	// for (int index = 0; index < ba.length; index++)
	// System.out.print(ba[index]);
	// System.out.println();
	// short ist = 4;
	// byte[] bas = shortToByteArray(ist);
	// for (int index = 0; index < bas.length; index++)
	// System.out.print(bas[index]);
	// System.out.println();
	// String str = "1qwsd124";
	// byte[] bast = stringToByteArray(str);
	// for (int index = 0; index < bast.length; index++)
	// System.out.print(bast[index]+" ");
	// }
}
