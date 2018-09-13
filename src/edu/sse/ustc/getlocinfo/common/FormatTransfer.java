package edu.sse.ustc.getlocinfo.common;


public class FormatTransfer {
	/**
	 * transfer integer to a Low-High bytes array
	 * 
	 * @param n
	 * 
	 * @return byte[]
	 */
	public static byte[] toLH(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * transfer integer to a High-Low bytes array
	 * 
	 * @param n
	 * 
	 * @return byte[]
	 */
	public static byte[] toHH(int n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * transfer short to a Low-High bytes array
	 * 
	 * @param n
	 * 
	 * @return byte[]
	 */
	public static byte[] toLH(short n) {
		byte[] b = new byte[2];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/**
	 * transfer short to a High-Low bytes array
	 * 
	 * @param n
	 * 
	 * @return byte[]
	 */
	public static byte[] toHH(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/**
	 * transfer float to a Low-High bytes array
	 */
	public static byte[] toLH(float f) {
		return toLH(Float.floatToRawIntBits(f));
	}

	/**
	 * transfer short to a High-Low bytes array
	 */
	public static byte[] toHH(float f) {
		return toHH(Float.floatToRawIntBits(f));
	}

	/**
	 * transfer string to a bytes array
	 */
	public static byte[] stringToBytes(String s, int length) {
		while (s.getBytes().length < length) {
			s += " ";
		}
		return s.getBytes();
	}

	/**
	 * transfer a bytes array to string
	 * 
	 * @param b
	 * 
	 * @return String
	 */
	public static String bytesToString(byte[] b) {
		StringBuffer result = new StringBuffer("");
		int length = b.length;
		for (int i = 0; i < length; i++) {
			result.append((char) (b[i] & 0xff));
		}
		return result.toString();
	}

	/**
	 * transfer string to a Low-High bytes array
	 * 
	 * @param s
	 * 
	 * @return byte[]
	 */
	public static byte[] stringToBytes(String s) {
		return s.getBytes();
	}

	/**
	 * transfer a High-Low bytes array to integer
	 * 
	 * @param b
	 *            byte[]
	 * @return int
	 */
	public static int hBytesToInt(byte[] b) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			if (b[i] >= 0) {
				s = s + b[i];
			} else {
				s = s + 256 + b[i];
			}
			s = s * 256;
		}
		if (b[3] >= 0) {
			s = s + b[3];
		} else {
			s = s + 256 + b[3];
		}
		return s;
	}

	public static int hBytesToInt(byte[] b, int offset, int len) {
		int s = 0;
		for (int i = offset; i < offset + 3; i++) {
			if (b[i] >= 0) {
				s = s + b[i];
			} else {
				s = s + 256 + b[i];
			}
			s = s * 256;
		}
		if (b[offset + 3] >= 0) {
			s = s + b[offset + 3];
		} else {
			s = s + 256 + b[offset + 3];
		}
		return s;
	}

	/**
	 * transfer a Low-High bytes array to a integer
	 * 
	 * @param b
	 *            byte[]
	 * @return int
	 */
	public static int lBytesToInt(byte[] b) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			if (b[3 - i] >= 0) {
				s = s + b[3 - i];
			} else {
				s = s + 256 + b[3 - i];
			}
			s = s * 256;
		}
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		return s;
	}

	/**
	 * transfer a High-Low bytes array to a short
	 * 
	 * @param b
	 *            byte[]
	 * @return short
	 */
	public static short hBytesToShort(byte[] b) {
		int s = 0;
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		s = s * 256;
		if (b[1] >= 0) {
			s = s + b[1];
		} else {
			s = s + 256 + b[1];
		}

		return (short) s;
	}

	public static short hBytesToShort(byte[] b, int offset, int len) {
		int s = 0;
		if (b[offset] >= 0) {
			s = s + b[offset];
		} else {
			s = s + 256 + b[offset];
		}
		s = s * 256;
		if (b[offset + 1] >= 0) {
			s = s + b[offset + 1];
		} else {
			s = s + 256 + b[offset + 1];
		}

		return (short) s;
	}

	/**
	 * transfer a Low-High bytes array to a short
	 * 
	 * @param b
	 *            byte[]
	 * @return short
	 */
	public static short lBytesToShort(byte[] b) {
		int s = 0;
		if (b[1] >= 0) {
			s = s + b[1];
		} else {
			s = s + 256 + b[1];
		}
		s = s * 256;
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}

		return (short) s;
	}

	public static short lBytesToShort(byte[] b, int offset, int len) {
		int s = 0;
		if (b[offset] >= 0) {
			s = s + b[offset];
		} else {
			s = s + 256 + b[offset];
		}
		s = s * 256;
		if (b[offset - 1] >= 0) {
			s = s + b[offset - 1];
		} else {
			s = s + 256 + b[offset - 1];
		}

		return (short) s;
	}

	/**
	 * transfer a High-Low bytes array to a float
	 * 
	 * @param b
	 *            byte[]
	 * @return float
	 */
	public static float hBytesToFloat(byte[] b) {
		int i = 0;

		i = ((((b[0] & 0xff) << 8 | (b[1] & 0xff)) << 8) | (b[2] & 0xff)) << 8 | (b[3] & 0xff);
		return Float.intBitsToFloat(i);
	}

	/**
	 * transfer a Low-High bytes array to a float
	 * 
	 * @param b
	 *            byte[]
	 * @return float
	 */
	public static float lBytesToFloat(byte[] b) {
		int i = 0;

		i = ((((b[3] & 0xff) << 8 | (b[2] & 0xff)) << 8) | (b[1] & 0xff)) << 8 | (b[0] & 0xff);
		return Float.intBitsToFloat(i);
	}

	/**
	 * reverse a bytes array
	 */
	public static byte[] bytesReverseOrder(byte[] b) {
		int length = b.length;
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[length - i - 1] = b[i];
		}
		return result;
	}

	/**
	 * output a bytes array
	 */
	public static void printBytes(byte[] bb) {
		int length = bb.length;
		for (int i = 0; i < length; i++) {
			System.out.print(bb + " ");
		}
		System.out.println("");
	}

	public static void logBytes(byte[] bb) {
		int length = bb.length;
		String out = "";
		for (int i = 0; i < length; i++) {
			out = out + bb + " ";
		}

	}

	/**
	 * reverse a anti-sequence Integer
	 * 
	 * @param i
	 *            int
	 * @return int
	 */
	public static int reverseInt(int i) {

		return FormatTransfer.hBytesToInt(FormatTransfer.toLH(i));

	}

	/**
	 * reverse a anti-sequence short *
	 * 
	 * @param s
	 *            short
	 * @return short
	 */
	public static short reverseShort(short s) {

		return FormatTransfer.hBytesToShort(FormatTransfer.toLH(s));
	}

	/**
	 * reverse a anti-sequence float *
	 * 
	 * @param f
	 *            float
	 * @return float
	 */
	public static float reverseFloat(float f) {

		return FormatTransfer.hBytesToFloat(FormatTransfer.toLH(f));
	}

	public static String bytesToTime(byte[] b, int offset ,int len){
		
		int year = 2000 + b[offset];
		int month = b[offset+1];
		int day = b[offset+2];
		int hour = b[offset+5];
		int minute = b[offset+6];
		int second = b[offset+7];
		String str = "";
		str = String.valueOf(year);
		str = str+"-"+ String.valueOf(month);
		str = str+"-"+ String.valueOf(day);
		str = str+" "+ String.valueOf(hour);
		str = str+":"+ String.valueOf(minute);
		str = str+":"+ String.valueOf(second);
		
 		return str;
	}
}
