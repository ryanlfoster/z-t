package com.australia.utils;

public class LinkUtils {
	private LinkUtils() {
	}

	public static final String getHrefFromPath(String path){
		if(path.startsWith("/")){
			return path+".html";
		}else{
			return path;
		}
	}
}
