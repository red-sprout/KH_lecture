package com.kh.EX02;

// 이름, 평균 합격커스 국어 최저 점수, 영어최저점수
// 모든 데이터를 매개변수로 초기화하는 생성자 정의
public class University {
	private String name;
	private int avgCut;
	private int koCut;
	private int enCut;
	
	public University(String name, int avgCut, int koCut, int enCut) {
		this.name = name;
		this.avgCut = avgCut;
		this.koCut = koCut;
		this.enCut = enCut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvgCut() {
		return avgCut;
	}

	public void setAvgCut(int avgCut) {
		this.avgCut = avgCut;
	}

	public int getKoCut() {
		return koCut;
	}

	public void setKoCut(int koCut) {
		this.koCut = koCut;
	}

	public int getEnCut() {
		return enCut;
	}

	public void setEnCut(int enCut) {
		this.enCut = enCut;
	}
	
	public boolean isEvaluate(Student st) {
		if(st.getAge() >= this.avgCut && st.getEngScore() >= this.enCut && st.getKorScore() >= this.koCut) {
			return true;
		} else {
			return false;
		}
	}
}
