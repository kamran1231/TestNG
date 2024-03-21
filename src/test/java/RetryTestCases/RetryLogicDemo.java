package RetryTestCases;

import org.testng.annotations.Test;
import org.testng.Assert;

public class RetryLogicDemo {
	
	@Test
	public void TestCase01() {
		
		Assert.assertTrue(false);
	}
	
	@Test
	public void TestCase02() {
		
		Assert.assertTrue(false);
	}
	
	@Test
	public void TestCase03() {
		
		Assert.assertTrue(true);
	}

}
