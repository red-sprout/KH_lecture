import java.util.Scanner;
// import java.lang.Math; import 사실 안해줘도 됨

public class A_for {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나
	 * 어떤 실행코드를 반복적으로 수행시켜준다.
	 * 
	 * 크게 두 종류로 나뉨(for문 / while문(do-while문))
	 * 
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식){ // 반복 횟수를 지정하기 위해 제시하는 것
	 * 		반복적으로 실행시키고자 하는 구문
	 * }
	 * 
	 * - 초기식 : 반복문이 수행될 때 "처음에 단 한번만 실행하는 구문"
	 * 			(보통 반복문 안에서 사용될 변수를 선언 및 초기화하는 구문)
	 * 
	 * - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 * 			조건식이 true일 경우 해당 구문을 실행
	 * 			조건식이 false가 되는 순간 반복을 멈추구 빠져나옴
	 * 			(보통 초기식에 제시된 변수를 가지고 조건식을 정함)
	 * 
	 * - 증감식 : 반복문을 제어하는 변수 값을 증감 시키는 구문
	 * 			(보통 초기식에 제시된 변수를 가지고 증감연산자를 사용함)
	 * 
	 * for 문을 만나는 순간
	 * 초기식 ->	조건식 검사 -> true일 경우 실행구문 실행 -> 증감식
	 * 			조건식 검사 -> true일 경우 실행구문 싫행 -> 증감식
	 * 			----------------- 반복 -----------------
	 *  		조건식 검사 -> false일 경우 실행구문 싫행x -> 반복문 빠져 나옴
	 */
	public static void main(String[] args) {
//		// "안녕하세요"를 5번 출력하세요.
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		
//		for(int i = 0; i < 5; i++) { // i 값이 0에서부터 4까지 매번 1씩 증가하는 동안 반복수행()
//			System.out.println("안녕하세요");
//		}
		
//		// 1~5까지 순차적으로 출력하세요(1 2 3 4 5)
//		for(int i = 1; i <= 5; i++) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
//		
//		// 5~1까지 순차적으로 출력
//		for(int i = 5; i > 0; i--) {
//			System.out.print(i + " ");
//		}
		
//		// 정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력해라
//		// 정수입력 : 3
//		// 1 2 3
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("정수입력 : ");
//		int n = sc.nextInt();
//		
//		for(int i = 1; i <= n; i++) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
//		
//		sc.close();
		
//		// 1부터 10사이의 홀수만 출력
//		// 1 3 5 7 9
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("정수입력 : ");
//		int n = sc.nextInt();
//		
//		for(int i = 1; i < 2 * n; i += 2) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
//		
//		sc.close();
		
		// 1부터 100까지 총 합계를 구해라
		// 방법 1. 1+2+...+100;
		// 방법 2.
		/*
		 * int sum = 0;
		 * sum += 1;
		 * sum += 2;
		 * ...
		 * sum += 10;
		 * 
		 * 규칙을 찾자! sum변수에 누적해서 합산하는 것 반복적으로 진행됨
		 * 단, 누적해서 더하고자하는 값이 1에서부터 10까지 1씩 증가한다.
		 */
		
//		int sum = 0;
//		
//		for(int i = 1; i < 11; i++) { // 1 2 3 4 5 6 7 8 9 10
//			sum += i;
//		}
//		
//		System.out.println("1부터 10까지 모든 수의 합 : " + sum);
		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가하여 모든 수를 더해서 출력해라.
		// 정수입력 : 5
		// 1부터 5까지의 합 : 15
//		Scanner sc = new Scanner(System.in);
//		
//		int n = 0;
//		int sum = 0;
//		
//		System.out.print("정수입력 : ");
//		n = sc.nextInt();
//		for(int i = 1; i <= n; i++) {
//			sum += i;
//		}
//		
//		System.out.printf("1부터 %d까지의 합 : %d\n", n, sum);
//		sc.close();
		
		/*
		 * java.lang.Math 클래스에서 제공하는 random 메소드 호출해서 매번 다른 랜덤 값을 얻어낼 수 있다.
		 * 
		 * Math.random() 호출시 ==> 0.0 ~ 0.99999999 사이의 랜덤값을 반환
		 * 
		 * int random = Math.random(); // double형이라서 안됨
		 * 
		 * int random = (int)(Math.random() * 10 + 1); 1 ~ 10
		 */
		
//		int random = (int)(Math.random() * 10 + 1);
//		System.out.println(random);
		
		// random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력하세요
		// random 수 : 5
		// 1~5까지의 합 : 15
		
//		int sum = 0;
//		int random = (int)(Math.random() * 10 + 1);
//		
//		System.out.println("random 수 : " + random);
//		for(int i = 1; i <= random; i++) {
//			sum += i;
//		}
//		
//		System.out.println("1 ~ " + random + "까지의 합 : " + sum);
		
		// random(5~50)한 숫자 n을 생성해서 1부터 n까지의 숫자 둥 짝수만 출력해라
		// random 수 : 10
		// 2 4 6 8
		
//		int random = (int)(Math.random() * 46 + 5);
//		
//		System.out.println("random 수 : " + random);
//		for(int i = 2; i < random; i += 2) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
		
//		String str = "Hello";
//		/*
//		 * 각 인덱스별 문자 뽑아서 출력
//		 */
//		
//		for(int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		// 사용자에게 문자열을 입력받아
		// 해당 문자열읠 짝수자리 글자만 출력
		// 문자열을 입력 : hello
		// el
		
//		String str;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("문자열을 입력 : ");
//		str = sc.nextLine();
//		
//		for(int i = 0; i < str.length(); i++) {
//			if(i % 2 == 0) continue;
//			System.out.print(str.charAt(i));
//		}
//		
//		System.out.println();
//		
//		sc.close();
		
		// 구구단 2단을 출력해보자
		// 2 * 1 = 2 ...
//		for(int i = 1; i <= 9; i++) System.out.printf("2 * %d = %d\n", i, 2 * i);
		
		// 사용자로부터 단을 입력받아 사용자가 입력한 단을 출력하기
		// 단 수(2~9)를 입력 :
		// 2 * 1 = 2 ...
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("단 수(2~9)를 입력 : ");
//		int n = sc.nextInt();
//		
//		if(n >= 2 && n <= 9) {
//			for(int i = 1; i < 10; i++) {
//				System.out.printf("%d * %d = %d\n", n, i, n * i);
//			}
//		} else {
//			System.out.println("잘못 입력했습니다");
//		}
//		
//		sc.close();
		
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
//		int row = 3;
//		int col = 5;
//		
//		for(int i = 0; i < row; i++) {
//			for(int j = 1; j <= col; j++) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) System.out.printf("%d * %d = %d\n", i, j,  i * j);
			System.out.println();
		}
	}
}
