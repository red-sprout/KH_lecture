package com.kh.Object;

public class NumberPrinter {
	private int myNum = 0;
	public static int count = 0;
	
	static void showInt(int n) { 
		System.out.println(n); 
	}
	static void showDouble(double n) {
		System.out.println(n); 
	}
	   
	void setMyNumber(int n) { 
		myNum = n; 
	}
	
	void showMyNumber() {
		showInt(myNum);
	}
}

