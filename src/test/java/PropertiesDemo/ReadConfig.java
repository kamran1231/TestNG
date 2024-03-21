package PropertiesDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	String path = "C:\\Users\\khanb\\eclipse-workspace\\"
			+ "TestNG_Pr\\src\\test\\java\\"
			+ "PropertiesDemo\\config.properties";
	
	public ReadConfig() throws IOException {
		// TODO Auto-generated constructor stub
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
	}
	
	
	public String getURL() {
		
		String url = prop.getProperty("url");
		
		if(url!=null) {
			return url;
		}
		else {
			throw new RuntimeException("Url not specified in config file");
		}
	}
	
	public String getUsername() {
		
		String username = prop.getProperty("username");
		
		if(username!=null) {
			return username;
		}
		else {
			throw new RuntimeException("Username not specified in config file");
		}
		
	}
	
	public String getPassword() {
		
		String password = prop.getProperty("password");
		
		if(password!=null) {
			return password;
		}
		else {
			throw new RuntimeException("Password not specified in config file");
		}
	}
	

}
