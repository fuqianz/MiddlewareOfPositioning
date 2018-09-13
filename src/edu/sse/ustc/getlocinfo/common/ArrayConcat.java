package edu.sse.ustc.getlocinfo.common;

import java.util.Arrays;

public class ArrayConcat {

	public static byte[] concat(byte[] first, byte[] second) {

		int offset = 0;
		byte[] result = Arrays.copyOf(first, first.length + second.length);

		offset += first.length;
		System.arraycopy(second, 0, result, offset, second.length);

		return result;
	}

	public static byte[] concat(byte[] first, byte[] second, byte[] three, byte[] four) {

		byte[] result = Arrays.copyOf(first, first.length + second.length + three.length + four.length);

		result = ArrayConcat.concat(first, second);
		result = ArrayConcat.concat(result, three);
		result = ArrayConcat.concat(result, four);

		return result;
	}
}
