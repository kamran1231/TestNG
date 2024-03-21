package Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	@Test(dataProvider = "getData")
	public void dologin(String username, String password) {
		
		System.out.println(username+"------"+password);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "kamran@gmail.com"; 
		data[0][1] = "khan";
		data[1][0] = "aisha@gmail.com";
		data[1][1] = "kamran";
		data[2][0] = "rahul@gmail.com";
		data[2][1] = "rahul";
		
		
		return data;
	}
}
