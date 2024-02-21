package com.kh.EX02;

// 이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고있는 객체를 만들기 위한
// 클래스를 작성해라.
// 데이터는 직접 접근을 허용하지 않고 모두 간접적으로 set/get해줄 수 있도록 작성해라.
// 모든 데이터를 초기화하면서 객체를 생성할 수 있는 생성자를 작성
public class Student {
	private String name;
	private int age;
	private int mathScore;
	private int engScore;
	private int korScore;
	
	public Student(String name, int age, int mathScore, int engScore, int korScore) {
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.korScore = korScore;
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	
	public int getAvg() {
		int avg = (this.mathScore + this.engScore + this.korScore) / 3;
		return avg;
	}
}
