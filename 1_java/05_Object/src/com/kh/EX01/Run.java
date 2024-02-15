package com.kh.EX01;

public class Run {
	public static void main(String[] args) {
//		// 두개의 인스턴스가 생성된다.
//		BankAccount lee = new BankAccount();
//		BankAccount choi = new BankAccount();
//
//		//각각의 인스턴스를 대상으로 예금을 진행
//		lee.deposit(5000);
//		choi.deposit(3000);
//		
//		//각각의 인스턴스를 대상으로 출금 진행
//		lee.withdraw(2000);
//		choi.withdraw(2000);
//		
//		//각각의 인스턴스 객체의 잔액을 조회
//		lee.checkMyBalance();
//		choi.checkMyBalance();
//		
//		System.out.println(lee.balanceEquals(choi));
		
		BankAccount choi = new BankAccount("12-456-78", "123456-789456", 10000);
		
		BankAccount park = new BankAccount("12-456-78", "123456-789456", 10000);
	}
}
