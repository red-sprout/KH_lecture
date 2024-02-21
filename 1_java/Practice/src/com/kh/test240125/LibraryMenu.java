package com.kh.test240125;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		String name;
		int age;
		char gender;
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별 : ");
		gender = sc.nextLine().charAt(0);
		
		lc.insertMember(new Member(name, age, gender));
		
		int menu = -1;
		while(menu != 9) {
			System.out.println("\n==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				this.selectAll();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
		sc.close();
	}
	
	public void selectAll() {
		Book[] book = lc.selectAll();
		for(int i = 0; i < book.length; i++) {
			if(book[i] == null) {
				break;
			}
			System.out.println(i + "번 도서 : " + book[i]);
		}
	}
	
	public void searchBook() {
		String keyword;
		System.out.print("검색할 제목 키워드 : ");
		keyword = sc.nextLine();
		
		Book[] book = lc.seachBook(keyword);
		
		for(int i = 0; i < book.length; i++) {
			if(book[i] == null) {
				break;
			}
			System.out.println(book[i]);
		}
	}
	
	public void rentBook() {
		Book[] book = lc.selectAll();
		
		System.out.println();
		for(int i = 0; i < book.length; i++) {
			if(book[i] == null) {
				break;
			}
			System.out.println(i + "번 도서 : " + book[i]);
		}
		
		int index;
		
		System.out.print("대여할 도서 번호 선택 : ");
		index = sc.nextInt();
		sc.nextLine();
		
		int result = lc.rentBook(index);
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		}
	}
}
