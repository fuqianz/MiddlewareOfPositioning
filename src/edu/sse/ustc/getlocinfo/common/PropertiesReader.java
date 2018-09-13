package edu.sse.ustc.getlocinfo.common;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import edu.sse.ustc.common.MyLog;

@SuppressWarnings("unchecked")
public class PropertiesReader {

	private static List<Element> child = null;

	static {
		SAXReader reader = new SAXReader();
		Document doc = null;

		try {
			doc = reader.read(PropertiesReader.class.getClassLoader().getResourceAsStream("properties.xml"));
			Element root = doc.getRootElement();

			List<Element> li = root.elements();

			child = li.get(0).elements();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), "edu.sse.ustc.getlocinfo.common.PropertiesReader");
		}
	}

	public static String getServerIP() {
		return child.get(0).attributeValue("values");
	}

	public static Integer getRpcPort() {
		return Integer.valueOf(child.get(1).attributeValue("values"));
	}

	public static Integer getSocketPort() {
		return Integer.valueOf(child.get(2).attributeValue("values"));
	}

	public static String getEnvironmentName() {
		return child.get(3).attributeValue("values");
	}

	// public static void main(String[] args) {
	//
	// System.out.println(getServerIP());
	// System.out.println(getRpcPort());
	//
	// System.out.println(getSocketPort());
	// System.out.println(getEnvironmentName());
	// }
}
