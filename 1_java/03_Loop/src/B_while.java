import java.util.Scanner;

public class B_while {
	/*
	 * while문
	 * 
	 * [초기식;]
	 * while(조건식) {
	 * 		반복적으로 실행할 코드;
	 * 		[증감식;]
	 * }
	 * 
	 * 조건식의 결과가 true일 경우 해당 코드를 실행한다.
	 * 
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> false일 경우 실행코드 실행x => 반복문 탈출
	 */
	public static void main(String[] args) {
		//for문
//		for(int i = 0; i < 5; i++) {
//			System.out.println("안녕하세요.");
//		}
		
		//while문
//		int i = 0;
//		while(i < 5) {
//			System.out.println("안녕하세요.");
//			i++;
//		}
		
		// 1에서부터 10사이의 홀수만을 출력
//		int i = 1;
//		while(i <= 10) {
//			System.out.print(i + " ");
//			i += 2;
//		}
//		System.out.println();
		
		// 1부터 랜덤값(1~100사이) 까지의 합계를 출력
		// 1부터 xx까지의 총 합계 : xxxx
//		int i = 1, sum = 0;
//		int random = (int)(Math.random() * 100 + 1);
//		
//		while(i <= random) {
//			sum += i;
//			i++;
//		}
//		
//		System.out.printf("1부터 %d까지의 총 합계 : %d\n", random, sum);
		
		// 사용자에게 문자열을 입력받아
		// 해당 문자열의 짝수자리 글자만 출력
		// 문자열을 입력 : hello
		// el
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력 : ");
		String str = sc.nextLine();
		
		int i = 1;
		while(i < str.length()) {
			System.out.print(str.charAt(i));
			i += 2;
		}
		
		System.out.println();
		sc.close();
	}
}
