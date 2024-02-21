import java.util.Scanner;

public class Operator06 {
	/*
	 * 삼항연산자 (항목 3개를 가지고 연산해주는 연산자)
	 * 
	 * [표현법]
	 * 조건식 ? 조건식이 참일 경우 돌려줄 결과값 : 조건식이 거짓일 경우 들어올 결과값
	 * 
	 * 이 때, 조건식은 반드시 true 또는 false가 나오도록 해야된다.
	 * 주로 비교, 논리연산자를 통해 작성한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		// 입력받은 정수값이 양수인지 아닌지 판별 후 출력한다.
//		System.out.print("정수값 입력: ");
//		int num = sc.nextInt();
//		sc.nextLine();
//		
////		String result = num > 0 ? "양수" : "음수";
////		System.out.println(result + "입니다.");
//		
//		System.out.println(num + "은 " + (num > 0 ? "양수이다." : "양수가 아니다."));
		
		// 정수 하나를 입력받아 짝수인지 홀수인지 판별 후 출력
		// 정수값 입력 : 5
		// 5는 홀수이다.
		
//		System.out.print("정수값 입력 : ");
//		int num = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.println(num + "는 " + (num % 2 == 0 ? "짝수" : "홀수") + "이다.");
//		
		
		// 사용자에게 두 개의 정수 값을 입력받으세요.
		// + 또는 -를 입력받아 그에 맞는 연산 결과를 출력해 주세요.
		// 단, + 또는 - 이외에 다른 문자를 입력했을 경우 "잘못 입력했습니다." 출력
		// 첫번째 정수 : 
		// 두번째 정수 : 
		// 연산자 입려(+ 또는 -) : 
		// 결과 : xxx / 잘못 입력했습니다.
		
		int num1, num2;
		char operator;
		String result;
		
		System.out.print("첫번째 정수 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두번째 정수 : ");
		num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("연산자 입려(+ 또는 -) : ");
		operator = sc.nextLine().charAt(0);
		
		// 삼항연산자
//		int num = (operator == '+') ? num1 + num2 : num1 - num2;
//		result = ((operator == '+') || (operator == '-')) ? String.valueOf(num) : "잘못 입력했습니다.";
		
//		result = ((operator == '+') ? num1 + num2 : ((operator == '-') ? num1 - num2 : "잘못 입력했습니다.")) + "";
		
		// 조건문(if)
//		if (operator == '+') {
//			result = num1 + num2 + "";
//		} else if (operator == '-') {
//			result = num1 - num2 + "";
//		} else {
//			result = "잘못 입력했습니다.";
//		}
		
		// 조건문(switch)
		switch(operator) {
		case '+':
			result = num1 + num2 + "";
			break;
		case '-':
			result = num1 - num2 + "";
			break;
		default:
			result = "잘못 입력했습니다.";
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
