package com.kh.Inherit01;

public class Run {
	public static void main(String[] args) {
		BusinessMan man = new BusinessMan("지원", "kh", "강사");
//		man.name = "지원";
//		man.tellYourName();
//		
//		man.company = "kh";
//		man.position = "강사";
		man.tellYourInfo();
	}
}
