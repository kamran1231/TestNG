package CustomListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersNew implements ITestListener {

	public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub	
		
		System.out.println("On Finished method invoked....");

        		
    }		

    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        	
		System.out.println("On start method invoked....");

    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub	
    	System.out.println("Name of test method failed :"+ result.getName());
        		
    }		

    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
    	System.out.println("Name of test method skipped :"+ result.getName());

        		
    }		

    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        
    	System.out.println("Name of test method start :"+ result.getName());

    }		

    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        
    	System.out.println("Name of test method success :"+ result.getName());

    }		
	
}
