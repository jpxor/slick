package jpx.slick;

import jpx.slick.layout.Test_SlickLayout;

public class Test {

	public static void main(String[] args) 
	{
		System.out.println("Running Tests: jpx.slick");
		System.out.println();
		
		boolean pass = true;
		pass = Test_SlickLayout.runTest();
		 
		System.out.println("All tests: " + (pass? "PASS":"FAIL")); 
	}

}
