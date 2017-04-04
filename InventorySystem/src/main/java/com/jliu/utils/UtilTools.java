package com.jliu.utils;

import java.net.URL;

import org.apache.log4j.Logger;

public class UtilTools {
	private static Logger rootLogger = Logger.getLogger("rootLogger");
	
	public static URL getResourceUrl(String name) {
		return UtilTools.class.getClassLoader().getResource(name);
	}
	
	public static Logger getLogger() {
		return rootLogger;
	}
}
