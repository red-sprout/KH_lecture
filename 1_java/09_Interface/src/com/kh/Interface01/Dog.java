package com.kh.Interface01;

public class Dog implements Animal, Baby{

	@Override
	public void move() {
		System.out.println("촐랑촐랑 뜁니다");
	}

	@Override
	public void eat() {
		System.out.println("촵촵촬 먹습니다.");
	}

	@Override
	public void makeSound() {
		System.out.println("멍멍~");
	}
}
