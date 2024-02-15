package com.kh.Test240123;

import java.util.Scanner;

public class StudentManagement {
	Scanner sc;
	Student[] student;
	
	public StudentManagement() {
		this.sc = new Scanner(System.in);
		this.student = new Student[100];
	}
	
	public int printMenu() {
		System.out.println("===============성적관리 프로그램===============");
		System.out.print("1. 성적입력\n"
				+ "2. 모든학생 성적 확인\n"
				+ "3. 학생성적검색\n"
				+ "4. 마지막 저장된 정보 삭제\n"
				+ "5. 조건검색\n"
				+ "9. 종료\n"
				+ "메뉴를 입력하세요 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		return menu;
	}
	
	public void startProgram() {
		int menu = 0;
		while(menu != 9) {
			menu = this.printMenu();
			
			switch(menu) {
			case 1: // 성적입력
				this.insertGrade();
				break;
			case 2:
				this.printAllGrade();
				break;
			case 3:
				this.searchGradeByName();
				break;
			case 4: // 삭제
				this.lastGradeDelete();
				break;
			case 5:
				this.searchGradeByCondition();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			default:
				System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertGrade() {
		String name;
		int mathScore, korScore, engScore;
		
		System.out.print("학생 이름 입력 : ");
		name = sc.nextLine();
		
		System.out.print("수학 점수 입력 : ");
		mathScore = sc.nextInt();
		sc.nextLine();
		
		System.out.print("국어 점수 입력 : ");
		korScore = sc.nextInt();
		sc.nextLine();
		
		System.out.print("영어 점수 입력 : ");
		engScore = sc.nextInt();
		sc.nextLine();
		
		int i = 0;
		boolean isTrue = false;
		while(student[i] != null) {
			if(student[i++].getName().equals(name)) {
				System.out.println("해당 학생의 정보가 이미 존재합니다.");
				isTrue = true;
				break;
			}
		}
		
		if(!isTrue) {
			student[i] = new Student(name, mathScore, korScore, engScore);
			System.out.println(student[i]);
		}
	}
	
	public void printAllGrade() {
		for(int i = 0; i < student.length; i++) {
			if(student[i] == null) {
				break;
			}
			System.out.println(student[i]);
		}
		
		if (student[0] == null) {
			System.out.println("입력된 성적이 없습니다.");
			return;
		}
	}
	
	public void searchGradeByName() {
		System.out.print("학생 이름 입력 : ");
		String target = sc.nextLine();

		boolean flag = true;
		for(int i = 0; i < student.length; i++) {
			if(student[i] == null) {
				break;
			}
			if(student[i].getName().equals(target)) {
				System.out.println(student[i].toString());
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("해당 학생 정보를 찾지 못했습니다.");
		}
	}

	public void lastGradeDelete() {
		if (student[0] == null) {
			System.out.println("삭제할 성적이 없습니다.");
			return;
		}
		
		for(int i = 1; i < student.length; i++) {
			if(student[i] == null) {
				System.out.println("삭제정보 : " + student[i - 1]);
				student[i - 1] = null;
				return;
			}
		}
	}
	
	public void searchGradeByCondition() {
		// 1. 평균 2. 수학 3. 국어 4. 영어
		// (다른번호 입력시 잘못입력하셨습니다. 출력하고 성적관리프로그램으로 돌아가기)
		// 조회할 조건 입력 : 1
		// 기준점수(이상) : 30
		// 기준점수(이하) : 50
		
		// 30 이상과 50 이하의 평균학생
		
		int select;
		int lowerLimit, upperLimit;
		
		System.out.println("===============조건 검색===============");
		System.out.println("1. 평균 2. 수학 3. 국어 4. 영어");
		System.out.print("조회할 번호를 입력하세요 : ");
		select = sc.nextInt();
		sc.nextLine();
		
		System.out.print("기준점수(이상) : ");
		lowerLimit = sc.nextInt();
		
		System.out.print("기준점수(이하) : ");
		upperLimit = sc.nextInt();
		
		switch(select) {
		case 1:
			System.out.println(lowerLimit + " 이상과 " + upperLimit + " 이하의 평균학생");
			for(int i = 0; student[i] != null; i++) {
				if(student[i].getAvg() >= lowerLimit && student[i].getAvg() <= upperLimit) {
					System.out.println(student[i]);
				}
			}
			break;
		case 2:
			System.out.println(lowerLimit + " 이상과 " + upperLimit + " 이하의 평균학생");
			for(int i = 0; student[i] != null; i++) {
				if(student[i].getMathScore() >= lowerLimit && student[i].getMathScore() <= upperLimit) {
					System.out.println(student[i]);
				}
			}
			break;
		case 3:
			System.out.println(lowerLimit + " 이상과 " + upperLimit + " 이하의 평균학생");
			for(int i = 0; student[i] != null; i++) {
				if(student[i].getKorScore() >= lowerLimit && student[i].getKorScore() <= upperLimit) {
					System.out.println(student[i]);
				}
			}
			break;
		case 4:
			System.out.println(lowerLimit + " 이상과 " + upperLimit + " 이하의 평균학생");
			for(int i = 0; student[i] != null; i++) {
				if(student[i].getEngScore() >= lowerLimit && student[i].getEngScore() <= upperLimit) {
					System.out.println(student[i]);
				}
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
		}
	}
}
