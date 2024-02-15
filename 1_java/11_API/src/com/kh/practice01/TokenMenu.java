package com.kh.practice01;

import java.util.Scanner;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	
	public void mainMenu() {
		int num = -1;
		while(num != 3) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("3. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				tokenMenu();
				break;
			case 2:
				inputMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.print("토큰 처리 전 글자 : " + str + "\n");
		System.out.print("토큰 처리 전 개수 : " + str.length() + "\n");
		
		str = tc.afterToken(str);
		System.out.print("토큰 처리 후 글자 : " + str + "\n");
		System.out.print("토큰 처리 후 개수 : " + str.length() + "\n");
		System.out.print("모두 대문자로 변환 : " + str.toUpperCase() + "\n");
	}
	
	public void inputMenu() {
		String str;
		char one;
		
		System.out.print("문자열을 입력하세요 : ");
		str = sc.nextLine();
		
		str = tc.firstCap(str);
		System.out.println("첫 글자 대문자 : " + str);
		System.out.print("찾을 문자 하나를 입력하세요 : ");
		
		one = sc.nextLine().charAt(0);
		int cnt = tc.findChar(str, one);
		System.out.println(one + " 문자가 들어간 개수 : " + cnt);
	}
}
