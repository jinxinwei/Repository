package com.mybos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.mybos.domain.User;

public class MyUtil {
	
	private static Properties properties;
	static{
		try {
			InputStream inputStream=MyUtil.class.getClassLoader().getResourceAsStream("urlAddress.properties");
			properties=new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	public static String VALIDATECODE="validateCode";
	public static String USER="user";
	
	public static User getSessionUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(USER);
	}
	
	public static String getUrl(String key){
		return properties.getProperty(key);
	}

}
