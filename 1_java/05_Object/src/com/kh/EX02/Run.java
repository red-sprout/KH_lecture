package com.kh.EX02;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
//		Student choi = new Student("최지원", 15, 70, 60, 80);
//		Student kim = new Student("김도현", 17, 85, 95, 80);
		
		// choi 평균
//		double avgChoi = (double)(choi.getMathScore() + choi.getEngScore() + choi.getKorScore()) / 3.0;
//		System.out.println(avgChoi);
		
		// kim 평균
//		double avgKim = (double)(kim.getMathScore() + kim.getEngScore() + kim.getKorScore()) / 3.0;
//		System.out.println(avgKim);
		
		// 사용자로부터 이름, 나이, 영어점수 수학점수, 국어점수를 입력받아
		// 평균을 구하고 출력
		// 이름 : 최정원
		// 나이 : 15
		// 영어점수 : 80
		// 수학점수 : 100
		// 국어점수 : 75
		// 최정원님의 평균 : 85
		
//		Student student;
//		
//		String name;
//		int age, mathScore, engScore, korScore;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("이름 : ");
//		name = sc.nextLine();
//		
//		System.out.print("나이 : ");
//		age = sc.nextInt();
//		
//		System.out.print("영어점수 : ");
//		engScore = sc.nextInt();
//		
//		System.out.print("수학점수 : ");
//		mathScore = sc.nextInt();
//		
//		System.out.print("국어점수 : ");
//		korScore = sc.nextInt();
//		
//		student = new Student(name, age, mathScore, engScore, korScore);
//		
//		System.out.println(student.getName() + "님의 평균 : " + student.getAvg());
//		
//		sc.close();
		
		// kh대학교 평균 75, enCut 60, koCut 60
		University kh = new University("KH대학교", 75, 60, 60);
		Student choi = new Student("최지원", 15, 70, 60, 80);
		
		// choi 학생 입학 가능 여부 보기 합격입니다 불합격입니다
		
//		if(!(kh.getAvgCut() <= choi.getAvg())) {
//			System.out.println("불합격입니다.");
//		} else if(kh.getEnCut() > choi.getEngScore() || kh.getKoCut() > choi.getKorScore()) {
//			System.out.println("불합격입니다.");
//		} else {
//			System.out.println("합격입니다.");
//		}
		
//		System.out.println(kh.isEvaluate(choi) ? "합격입니다." : "불합격입니다.");
	}
}
