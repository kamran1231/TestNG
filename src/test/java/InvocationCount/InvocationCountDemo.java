package InvocationCount;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class InvocationCountDemo {

	@Test(invocationCount = 5)
	public void testMethod1(ITestContext context) {
		
		int invoCount = context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing" + invoCount);
		System.out.println("Test method1............");
	}
	
	@Test
	public void testMethod2() {
		
		System.out.println("Test 2............");
	}
}
