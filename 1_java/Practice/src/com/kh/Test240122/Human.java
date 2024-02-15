package com.kh.Test240122;

public class Human {
	static int count = 0;
	private String name;
	private int money;
	
	public Human(String name, int money) {
		this.money = money;
		this.name = name;
		this.count++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// buy 메소드
	// 구매가 가능합니다. 예산초과입니다.

	public void buy(TV tv) {
		if(this.money >= tv.getPrice()) {
			System.out.println("구매가 가능합니다.");
		} else {
			System.out.println("예산초과입니다.");
		}
	}
}
