import bsh.This;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		practice p = new practice();
		p.practice(4,3);
		

	}
	
	
	public int practice(int a, int b) {
		
		System.out.println("two paramaterize:");
		int c = a +b;
		System.out.println(c);
		return c;
		
	}
	
	public int practice(int x) {
		System.out.println("one parameter");
		return x;
	}
	
	

}
