package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependencies {

	@Test
	public void RegistrationUser() {
		System.out.println("Excecuting test Registration");
		AssertJUnit.fail("User no registered Successfully");
	}
	
	
	@Test(dependsOnMethods = {"RegistrationUser"})
	public void loginUser() {
		System.out.println("Login User");
	}
}

