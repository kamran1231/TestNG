package RetryTestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformerForRetry implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation testAnnotation,Class testClass, Constructor testConstructor, Method testMethod) {
		
		testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
