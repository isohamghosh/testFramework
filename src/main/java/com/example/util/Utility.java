package com.example.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	
	public void loaPropertyFile() {
		try(InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\project.properties")) {
			Properties properties = new Properties();
			properties.load(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
