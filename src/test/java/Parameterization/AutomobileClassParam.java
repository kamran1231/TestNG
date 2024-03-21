package Parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomobileClassParam {

	@Parameters("AutoMobileName")
	@Test
	public void testCase1(String name) {
		
		System.out.println(name);
	}
}
