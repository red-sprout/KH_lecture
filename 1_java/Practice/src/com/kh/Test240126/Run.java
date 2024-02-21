package com.kh.Test240126;

public class Run {
	public static void main(String[] args) {
		PhoneController controller = new PhoneController();
		String[] result = controller.method();
		
		for(String str : result) {
			System.out.println(str);
		}
	}
}
