import java.util.Scanner;

public class Test240119 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정수형 변수 age를 입력받아 7세 이하면 어린이, 19세 이하면 청소년 20세 이상이면 성인을 출력
		
//		int age;
//		
//		System.out.print("나이를 입력하세요 : ");
//		age = sc.nextInt();
//		
//		if(age <= 7) {
//			System.out.println(age + "세는 어린이입니다.");
//		} else if(age <= 19) {
//			System.out.println(age + "세는 청소년입니다.");
//		} else {
//			System.out.println(age + "세는 성인입니다.");
//		}
		
		// 정수 num1, num2 두개를 입력받아 두 수 사이에 있는 3의 배수의 모든 합
		
//		int sum = 0;
//		int num1, num2;
//		
//		System.out.print("정수 1 입력 : ");
//		num1 = sc.nextInt();
//		
//		System.out.print("정수 2 입력 : ");
//		num2 = sc.nextInt();
//		
//		int min = Math.min(num1, num2);
//		int max = Math.max(num1, num2);
//		
//		for(int i = min; i <= max; i++) {
//			if(i % 3 == 0) {
//				sum += i;
//			}
//		}
//		
//		System.out.println(sum);
		
		// 정수 num1, num2를 입력받아 두 수 사이에 있는 모든 홀수의 합과 짝수의 합을 각각 구하세요.
		
//		int sumEven = 0;
//		int sumOdd = 0;
//		int num1, num2;
//		
//		System.out.print("정수 1 입력 : ");
//		num1 = sc.nextInt();
//		
//		System.out.print("정수 2 입력 : ");
//		num2 = sc.nextInt();
//		
//		int min = Math.min(num1, num2);
//		int max = Math.max(num1, num2);
//		
//		for(int i = min; i <= max; i++) {
//			if(i % 2 == 0) {
//				sumEven += i;
//			} else {
//				sumOdd += i;
//			}
//		}
//		
//		System.out.println("짝수의 합 : " + sumEven);
//		System.out.println("홓수의 합 : " + sumOdd);
		
		// 첫쌔중에 데이터 개수 n개를 입력, 사용자로부터 n개의 정수를 입력받아 입력받은 반대로 출력
		// 정수 입력 : 5
		// 숫자입력 : 1 7 5 9 4
		// 반대로 출력 : 4 9 5 7 1
		
//		int n;
//		int[] arr;
//		
//		System.out.print("정수 입력 : ");
//		n = sc.nextInt();
//		arr = new int[n];
//		
//		System.out.print("숫자입력 : ");
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		System.out.print("반대로 출력 : ");
//		for(int i = arr.length - 1; i >= 0; i--) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		
		// 행 크기 입력 후 그 수만틈 반복으로 열 크기 받고 문자형 가변 배열 선언 및 알파벳 순 할당, 출력
		
//		int row, col;
//		char letter = 'a';
//		char[][] arr;
//		
//		System.out.print("행의 크기 : ");
//		row = sc.nextInt();
//		sc.nextLine();
//		
//		arr = new char[row][];
//		
//		for(int i = 0; i < row; i++) {
//			System.out.print(i + "행의 열 크기 : ");
//			col = sc.nextInt();
//			sc.nextLine();
//			
//			arr[i] = new char[col];
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = (char)(letter);
//				letter++;
//			}
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		sc.close();
	}
}
