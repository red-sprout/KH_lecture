import java.util.Scanner;

public class A_Array03 {
	public static void main(String[] args) {
//		// 1. 크기가 10인 정수형 배열 생성 후
//		int[] arr = new int[10];
//		// 2. 반복문을 활용해서 0 부터 마지막 인덱스까지 순차적으로 접근하면서 값을 대입
//		//	  매번 1~100 사이의 랜덤값
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 100 + 1);
//			System.out.printf("arr[%d] = %d\n", i, arr[i]);
//		}
//		// 3. 반복문을 활용해서 해당 배열의 0 ~ 마지막까지 담겨있는 값 출력
//		// arr[x] : xx
		
		// 1. 사용자에게 배열 길이를 입력받은 후
		//	  해당 크기의 문자열 배열을 생성
//		int length;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("배열의 길이 : ");
//		length = sc.nextInt();
//		sc.nextLine();
//		
//		String[] arr = new String[length];
//		
//		// 2. 반복문을 활용해서 매번 사용자에게 과일명을 입력받아 그 값을 매 인덱스자리에 대입
//		for(int i = 0; i < length; i++) {
//			System.out.print("좋아하는 과일을 입력하세요. : ");
//			String fruit = sc.nextLine();
//			arr[i] = fruit;
//		}
//		// 3. 반복문을 이용해서 출력
//		for(int i = 0; i < length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		sc.close();
		
		// 사용자에게 문자열 하나 입력받은 후
		// 각각의 인덱스에 있는 문자들을 char배열에 옮겨담기
		
		// 1. 사용자에게 문자열 한개 입력받기
//		String str;
//		System.out.print("문자열을 입력하세요 : ");
//		Scanner sc = new Scanner(System.in);
//		
//		str = sc.nextLine();
//		// 2. char배열 생성해두기(배열의 길이 == 문자열의 길이)
//		char[] chArr = str.toCharArray();
//		// 3. 반복문을 통해서 해당 문자열에서 각각 인덱스별 문자를 char배열에 각 인덱스에 대입
//		
//		// 4. 반복문을 이용해서 해당 배열의 0~마지막까지 담긴 값을 출력
//		for(char c : chArr) {
//			System.out.println(c);
//		}
		
		// 1. 사용자에게 배열의 길이를 입력받은 후 해당 크기만큼읠 정수 배열 생성
		int num;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 길이 입력 : ");
		num = sc.nextInt();
		
		int[] arr = new int[num];
		// 2. 반복문 활용해서 0~마지막까지 매번 1~100사이의 랜덤값 발생시켜 대입
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1);
		}
		// 3. 반복문 황용해서 배열에 담긴 모든 값을 출력함과 동시에
		// 짝수인 값들의 총합을 구해라
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if(arr[i] % 2 == 0) sum += arr[i];
		}
		
		System.out.println("짝수인 값들의 총합 : " + sum);
		sc.close();
	}
}
