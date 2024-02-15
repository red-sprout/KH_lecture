package test6;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 하나 입력하세요(2~5) : ");
		int data = sc.nextInt();
		
		try {
			System.out.println("결과값 : " + calculator.getSum(data));
		} catch(InvalidException ie) {
			System.out.println(ie.getMessage());
		}
		
		sc.close();
	}
}
