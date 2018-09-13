package edu.sse.ustc.common;

import org.apache.log4j.Logger;
/**
 * mylog
 * @author fqbrighter
 *
 */
public class MyLog {

	private static Logger log = null;

	public static void error(String message, String object) {

		log = Logger.getLogger(object);
		log.error(message);
	}

	public static void info(String message, String object) {

		log = Logger.getLogger(object);
		log.info(message);
	}

	public static void warn(String message, String object) {

		log = Logger.getLogger(object);
		log.warn(message);
	}

	public static void debug(String message, String object) {

		log = Logger.getLogger(object);
		log.debug(message);
	}
}
