package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
		
		
	}
	
	public String getBaseURL() {
		String baseURL = pro.getProperty("baseURL");
		return baseURL;
	}
	
	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getchromePath() {
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getfirefoxPath() {
		String firefoxPath = pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	

}
