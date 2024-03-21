package CustomListeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;



public class TestFailure {
	
	@Test
	public void doLogin() {
		
		AssertJUnit.fail("Fialing the login test");
		System.out.println("Capture Screenshot");
	}
	
	//we can include if we use included method
	@Test
	public void loginByFacebook() {
		
		System.out.println("Login by facebook");
		AssertJUnit.assertEquals("kamran", "kamran");
	}

}
