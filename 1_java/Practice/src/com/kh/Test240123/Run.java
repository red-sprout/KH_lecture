package com.kh.Test240123;

//import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);	
//		// 이름, 수학/국어/영어 점수 입력, 평균 실수
//		String name;
//		Student[] student = new Student[100];
//		int mathScore, korScore, engScore;
//		int menu;
//		int cnt = 0;
////		float avg;
//		
////		System.out.print("학생 이름 입력 : ");
////		name = sc.nextLine();
////		
////		System.out.print("수학 점수 입력 : ");
////		mathScore = sc.nextInt();
////		
////		System.out.print("국어 점수 입력 : ");
////		korScore = sc.nextInt();
////		
////		System.out.print("영어 점수 입력 : ");
////		engScore = sc.nextInt();
////		
////		avg = (float)(mathScore + korScore + engScore) / 3.0f;
////		
////		System.out.println(avg);
//		// -> Student 클래스
//		// 평균 구하는 메소드, 필드 정보를 보여주는 메소드를 포함
//		
//		// 성적관리 프로그램
//		// 1. 성적입력
//		// 2. 모든학생 성적 확인
//		// 3. 학생성적검색
//		// 9. 종료
//		// 메뉴를 입력하세요 :
//		// -> 1번 이름 수학/국어/영어 입력받아 객체 배열에 저장
//		// -> 2번 객체 배열에 저장된 모든 객체정보 표시
//		// -> 3번 입력시 이름을 입력받아 해당 이름의 학생 검색 후 정보출력
//		// -> 9번 입력시 종료
//		boolean tobeContinue = true;
//		while(tobeContinue) {
//			System.out.println("===============성적관리 프로그램===============");
//			System.out.print("1. 성적입력\n"
//					+ "2. 모든학생 성적 확인\n"
//					+ "3. 학생성적검색\n"
//					+ "9. 종료\n"
//					+ "메뉴를 입력하세요 : ");
//			menu = sc.nextInt();
//			sc.nextLine();
//			
//			switch(menu) {
//			case 1:
//				System.out.print("학생 이름 입력 : ");
//				name = sc.nextLine();
//				
//				System.out.print("수학 점수 입력 : ");
//				mathScore = sc.nextInt();
//				sc.nextLine();
//				
//				System.out.print("국어 점수 입력 : ");
//				korScore = sc.nextInt();
//				sc.nextLine();
//				
//				System.out.print("영어 점수 입력 : ");
//				engScore = sc.nextInt();
//				sc.nextLine();
//				
//				int idx = 0;
//				boolean isTrue = false;
//				while(student[idx] != null) {
//					if(student[idx++].getName().equals(name)) {
//						System.out.println("해당 학생의 정보가 이미 존재합니다.");
//						isTrue = true;
//						break;
//					}
//				}
//				
//				if(!isTrue) {
//					student[cnt++] = new Student(name, mathScore, korScore, engScore);
//					System.out.println(student[cnt - 1]);
//				}
//				break;
//			case 2:
//				for(int i = 0; i < student.length; i++) {
//					if(student[i] == null) {
//						break;
//					}
//					System.out.println(student[i]);
//				}
//				break;
//			case 3:
//				System.out.print("학생 이름 입력 : ");
//				String target = sc.nextLine();
//
//				boolean flag = true;
//				for(int i = 0; i < student.length; i++) {
//					if(student[i] == null) {
//						break;
//					}
//					if(student[i].getName().equals(target)) {
//						System.out.println(student[i].toString());
//						flag = false;
//						break;
//					}
//				}
//				if(flag) {
//					System.out.println("해당 학생 정보를 찾지 못했습니다.");
//				}
//				break;
//			case 9:
//				System.out.println("프로그램을 종료합니다.");
//				tobeContinue = false;
//				break;
//			default:
//				System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
//			}
//			
//			
//		}
//		sc.close();
		StudentManagement management = new StudentManagement();
		management.startProgram();
	}
}
