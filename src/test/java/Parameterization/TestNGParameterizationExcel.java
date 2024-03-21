package Parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestNGParameterizationExcel {
	
	@Parameters({"i","j"})
	@Test
	public void add(int i,int j) {
		
		System.out.println("add :"+ (i+j));
	}
	
	@Parameters({"i","j"})
	@Test
	public void sub(int i, int j) {
		
		System.out.println("sub :"+ (i-j));
	}
	
	@Parameters({"i","j"})
	@Test
	public void mul(int i,int j) {
		
		System.out.println("mul :"+(i*j));
	}
}
