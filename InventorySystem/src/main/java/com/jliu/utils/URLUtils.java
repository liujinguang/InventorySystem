package com.jliu.utils;

import java.net.URL;

public class URLUtils {
	public static URL getResourceUrl(String name) {
		return URLUtils.class.getClassLoader().getResource(name);
	}
}
