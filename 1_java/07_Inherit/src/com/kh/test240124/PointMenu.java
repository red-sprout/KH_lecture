package com.kh.test240124;

import java.util.Scanner;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		int menu = 0;
		while(menu != 9) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	
	public void circleMenu() {
		int menu = 0;
		while(menu != 9) {
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				calcCircum();
				break;
			case 2:
				calcCircleArea();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	
	public void rectangleMenu() {
		int menu = 0;
		while(menu != 9) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				calcPerimeter();
				break;
			case 2:
				calcRectArea();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
		sc.close();
	}
	
	public void calcCircum() {
		int x, y, radius;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		System.out.print("반지름 : ");
		radius = sc.nextInt();
		sc.nextLine();
		System.out.println(cc.calcCircum(x, y, radius));
	}
	
	public void calcCircleArea() {
		int x, y, radius;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		System.out.print("반지름 : ");
		radius = sc.nextInt();
		sc.nextLine();
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		int x, y, height, width;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		System.out.print("높이 : ");
		height = sc.nextInt();
		sc.nextLine();
		System.out.print("너비 : ");
		width = sc.nextInt();
		sc.nextLine();
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	
	public void calcRectArea() {
		int x, y, height, width;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		System.out.print("높이 : ");
		height = sc.nextInt();
		sc.nextLine();
		System.out.print("너비 : ");
		width = sc.nextInt();
		sc.nextLine();
		System.out.println(rc.calcArea(x, y, height, width));
	}
}
