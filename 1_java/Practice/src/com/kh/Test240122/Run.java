package com.kh.Test240122;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정수 n(2~9) 입력 2부터 n까지의 짝수의 구구단 출력
//		int n;
//		
//		while(true) {
//			System.out.print("정수 입력(2~9) : ");
//			n = sc.nextInt();
//			
//			if(n <= 9 && n >= 2) {
//				break;
//			} else {
//				System.out.println("다시입력하세요.\n");
//			}
//		}
//		
//		for(int i = 2; i <= n; i += 2) {
//			for(int j = 1; j < 10; j++) {
//				System.out.println(i + " * " + j + " = " + (i * j));
//			}
//			System.out.println();
//		}
		//num의 크기인 배열 만들고 1~100 랜덤값 -> 모든 배열의 홀수 인덱스 값을 더한 값 구하기
//		int num;
//		int[] arr;
//		
//		System.out.print("정수 입력 : ");
//		num = sc.nextInt();
//		arr = new int[num];
//		
//		for(int i = 0; i < num; i++) {
//			arr[i] = (int)(Math.random() * 100 + 1);
//		}
//		
//		int sum = 0;
//		for(int i = 1; i < num; i += 2) {
//			sum += arr[i];
//		}
//		
//		for(int i = 0; i < num; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		
//		System.out.println("홀수 인덱스에 해당하는 값 총합 : " + sum);
		// TV 클래스
//		TV myTV1 = new TV("삼성", 2020, 65, 100000);
//        TV myTV2 = new TV("LG", 2021, 55, 200000);
//		myTV1.show();
//        myTV2.show();
        
        //one 이란 Human 객체 생성, 구매가능 여부 확인
//        Human one = new Human("홍길동", 150000);
//        one.buy(myTV1);
//        one.buy(myTV2);
		
//		Human choi = new Human("최지원", 15000);
//		System.out.println(choi.count);
//		
//		Human kim = new Human("김지원", 15000);
//		System.out.println(choi.count);
//		System.out.println(Human.count);
		
		// ==========================================================
		
		/*
		 * 우리는 도서관에서 책을 관리하는 프로그램을 만든다고 가정한다.
		 * 해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book 클래스이다.
		 * 필요하다고 생각하는 데이터와 기능을 구현해보자
		 * 
		 * Book book1 = new Book(초기화 변수);
		 */
		
		// 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
		// book객체 생성하고 toString메소드를 호출하여 정보를 확인
		
		Book[] bookArr = new Book[100];
		int count = 0;
		int menu = 0;
		
		while(menu != 9) {
			System.out.println("===========도서 관리 프로그램===========");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서목록출력");
			System.out.println("3. 도서검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: {
				int number;
				String title, genre, author;
				
				System.out.print("도서 제목 : ");
				title = sc.nextLine();
				
				System.out.print("장르 : ");
				genre = sc.nextLine();
				
				System.out.print("저자 : ");
				author = sc.nextLine();
				
				System.out.print("책 번호 : ");
				number = sc.nextInt();
				sc.nextLine();
				
				bookArr[count] = new Book(title, genre, author, number);
				System.out.println("도서등록 완료 : " + bookArr[count++].toString());
			} break;
			case 2:
				System.out.println("================등록된 도서정보================");
				if(bookArr[0] == null) {
					System.out.println("등록된 도서가 없습니다.");
					break;
				}
				for(int i = 0; i < count; i++) {
					System.out.println(bookArr[i]);
				}
				break;
			case 3: {
				System.out.println("===============도서 검색===============");
				System.out.print("검색할 도서 제목 : ");
				String title = sc.next();
				Book target = null;
				
				for(int i = 0; i < bookArr.length; i++) {
					if(bookArr[i] == null) {
						break;
					} else if(bookArr[i].getTitle().equals(title)) {
						target = bookArr[i]; // 만약 찾았다면 target != null;
						break;
					}
				}
				
				if(target == null) {
					System.out.println("동일한 제목의 도서가 없습니다.");
				} else {
					System.out.println("검색 도서 정보 : " + target.toString());
				}
			} break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
			}
		}
		
		
		sc.close();
	}
}
