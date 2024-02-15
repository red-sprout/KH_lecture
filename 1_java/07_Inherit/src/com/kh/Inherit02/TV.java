package com.kh.Inherit02;

public class TV extends Product {
	private int inch; //크기

	public TV(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	//super. 으로 부모에게 접근이 가능하다
	//오버라이딩 : 부모클래스에 있는 메소드를 자식 클래스에서 재정의하는 것
	@Override
	public String information() {
		return super.information() + ", inch : " + this.inch;
	}
}
