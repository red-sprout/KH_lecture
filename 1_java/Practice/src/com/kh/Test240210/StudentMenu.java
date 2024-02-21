package com.kh.Test240210;

public class StudentMenu {
	private StudentController ssm;
	
	public StudentMenu() {
		this.ssm = new StudentController();
		System.out.println("========== 학생 정보 출력 ==========");
		
		Student[] sArr = ssm.printStudent();
		for(Student s : sArr) {
			System.out.println(s.inform());
		}
		
		System.out.println("\n========== 학생 성적 출력 ==========");
		
		double[] score = ssm.avgScore();
		System.out.printf("학생 점수 합계 : %d\n", (int)score[0]);
		System.out.printf("학생 점수 평균 : %.1f\n", score[1]);
		
		System.out.println("\n========== 성적 결과 출력 ==========");
		
		for(Student s : sArr) {
			System.out.println(s.getName() + "학생은 " + (s.getScore() < StudentController.CUT_LINE ? "재시험 대상" : "통과") + "입니다.");
		}
	}
}
