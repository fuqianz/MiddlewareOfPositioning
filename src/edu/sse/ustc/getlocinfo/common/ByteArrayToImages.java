package edu.sse.ustc.getlocinfo.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

import sun.misc.BASE64Decoder;
import edu.sse.ustc.common.MyLog;

public class ByteArrayToImages {

	public static boolean transferAndSave(String image_string, String mapFormat, String file_name) {

		if (image_string.length() < 0 || mapFormat == null || file_name == null) {
			MyLog.error("NO image file to be saved","edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
			return false;
		}

		BASE64Decoder decoder = new BASE64Decoder();

		byte[] image = null;
		try {
			image = decoder.decodeBuffer(image_string);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			MyLog.error(e1.toString(), "edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
			// e1.printStackTrace();
		}

		// for(int i = 0 ; i < image.length ; i ++)
		// {
		// if(image[i] > 127)
		// System.out.println(image[i] + i);
		// }

		String url = ".//map_image//" + file_name + "." + mapFormat;
		File file = new File(url);

		if (file.exists()) {
			MyLog.error(url + "is exist already", "edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
			return false;
		}

		FileImageOutputStream fios = null;

		try {
			fios = new FileImageOutputStream(file);
			fios.write(image, 0, image.length);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			MyLog.error(e.toString(), "edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), "edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
			// e.printStackTrace();
		} finally {
			try {
				fios.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				MyLog.error(e.toString(), "edu.sse.ustc.getlocinfo.common.ByteArrayToImages");
				// e.printStackTrace();
			}
		}

		return true;
	}

	public static String getMapFormatString(int mapType) {

		if (mapType == 1) {
			return "JPEG";
		}
		if (mapType == 2) {
			return "BMP";
		}
		if (mapType == 3) {
			return "gif";
		}
		if (mapType == 4) {
			return "png";
		}
		if (mapType == 5) {
			return "psd";
		}

		return null;
	}
}
