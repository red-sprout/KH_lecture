package com.kh.Test240122;

public class TV {
	private String brand;
	private int year;
	private int inches;
	private int price;
	
	public TV(String brand, int year, int inches, int price) {
		this.brand = brand;
		this.year = year;
		this.inches = inches;
		this.price = price;
	}
	
	public void show() {
		System.out.println(brand + "에서 만든 " + year + "년형 " + inches + "인치 TV는 " + price + "원");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInches() {
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
