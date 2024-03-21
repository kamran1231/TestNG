package RetryTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	//Counter to keep track of retry attempts
	
	int counterForRetryAttempts = 0;
	int setMaxLimitForRetry = 3;

	
	//Method to retry failed test cases
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(!result.isSuccess()) {
			
			if(counterForRetryAttempts < setMaxLimitForRetry) {
				
				counterForRetryAttempts ++;
				return true;
			}
		}
		return false;
	}
	
	

}
