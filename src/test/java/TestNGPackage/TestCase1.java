package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


//If we use Assert then it will print value up to the Pass condition, once the condition become
//failed then it will not print anything, if u need to print so you can use SoftAsset method 
//instead of Hard Assert and at the end of the code u need to add assetAll() 

public class TestCase1 {
	String expected_title = "Google.com";
	String Actual_title = "Yahoo.com";
	
	SoftAssert SoftAssert = new SoftAssert();
	
	@Test
	public void ValidateTitles() {
		
		
		if(expected_title.equals(Actual_title)) {
			System.out.println("Title has been Matched");
		}
		else {
			System.out.println("Not Matched");
		}
	}
	
	@Test
	public void ValidateTitles2() {
		
		AssertJUnit.assertEquals(Actual_title, expected_title);
		SoftAssert.assertAll();
	}
	
	@Test
	public void ValidateTitles3() {
		
		AssertJUnit.assertEquals(true, false);
		System.out.println("Validate titles 3");
	
		SoftAssert.assertAll();
	}
	

}
