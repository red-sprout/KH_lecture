package com.kh.EX01;

public class BankAccount {
	int balance = 0;
	String accNumber;
	String ssNumber;
	
	// 생성자
	public BankAccount() {
		
	}
	
	public BankAccount(String acc, String ss, int bal) {
		System.out.println("객체생성");
		this.accNumber = acc;
		this.ssNumber = ss;
		this.balance = bal;
	}
	
	public BankAccount(String acc, String ss) {
		this(acc, ss, 0);
	}

	// 데이터 초기값 세팅
	public void initAccount(String acc, String ss, int bal) {
		accNumber = acc;
		ssNumber = ss;
		balance = bal;
	}
	
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	
	public int checkMyBalance() {
		System.out.println("잔액 : " + balance);
		return balance;
	}
	
	public boolean balanceEquals(BankAccount act01) {
		return balance == act01.balance;
	}
	
	public void test(StringBuilder sb) {
		sb.append("world");
	}
}
