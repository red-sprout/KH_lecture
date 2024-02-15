import java.util.Scanner;

public class Test240118 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//실수 num1과 num2를 사용자로부터 입력받아 + % / 3가지 결과 출력
		
//		double num1, num2;
//		
//		System.out.print("실수 1 입력 : ");
//		num1 = sc.nextDouble();
//		
//		System.out.print("실수 2 입력 : ");
//		num2 = sc.nextDouble();
//		
//		System.out.printf("%f + %f = %f\n", num1, num2, (num1 + num2));
//		if(num2 != 0) {
//			System.out.printf("%f %% %f = %f\n", num1, num2, (num1 % num2));
//			System.out.printf("%f / %f = %f\n", num1, num2, (num1 / num2));
//		} else {
//			System.out.printf("%%와 / 연산은 수행할 수 없습니다.\n");
//		}
		
		//정수형 변수 num3를 사용자로부터 입력받아 100보다 작으면 100이하
		//100~200 200이하
		//200~300 300이하 300~ 300초과
		
//		int num3;
//		
//		System.out.print("정수 입력 : ");
//		num3 = sc.nextInt();
//		
//		if(num3 <= 100) {
//			System.out.println("100 이하");
//		} else if(num3 <= 200) {
//			System.out.println("200 이하");
//		} else if(num3 <= 300) {
//			System.out.println("300 이하");
//		} else {
//			System.out.println("300 초과");
//		}
//		
		//수학, 영어, 국어 성적을 입력받아 평균이 60이상이면 합격입니다.
		//작으면 불합격입니다. 출력
		
//		int math, eng, kor;
//		int avg;
//		
//		System.out.print("수학 점수 입력 : ");
//		math = sc.nextInt();
//		
//		System.out.print("영어 점수 입력 : ");
//		eng = sc.nextInt();
//		
//		System.out.print("국어 점수 입력 : ");
//		kor = sc.nextInt();
//		
//		avg = (int)(((float)math + eng + kor) / 3.0);
//		
//		if(avg >= 60) {
//			System.out.println("합격입니다.");
//		} else {
//			System.out.println("불합격입니다.");
//		}
		
		//국어성적을 입력 받아 50 이하 f학점
		//50-60 d학점 60-70 c학점 (70, 80] b학점 (80, ) a학점
		
//		int kor;
//		System.out.print("국어 점수 입력 : ");
//		kor = sc.nextInt();
//		
//		if(kor <= 50) {
//			System.out.println("f학점");
//		} else if(kor <= 60) {
//			System.out.println("d학점");
//		} else if(kor <= 70) {
//			System.out.println("c학점");
//		} else if(kor <= 80) {
//			System.out.println("b학점");
//		} else {
//			System.out.println("a학점");
//		}
//		
		//arr1을 작성
		
//		String[] arr1 = new String[9];
//		
//		for(int i = 0; i < arr1.length; i++) {
//			arr1[i] = "2 * " + (i + 1) + " = " + 2 * (i + 1);
//		}
//		
//		for(int i = 0; i < arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}
		
		//arr2를 작성
		
//		String[] arr2 = new String[9];
//		
//		for(int i = 0; i < arr2.length; i++) {
//			arr2[i] = "3 * " + (i + 1) + " = " + 3 * (i + 1);
//		}
//		
//		for(int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
		
		//arr2 작성
		
		
//		String[][] arr3 = new String[8][9];
//		
//		for(int i = 0; i < arr3.length; i++) {
//			for(int j = 0; j < arr3[i].length; j++) {
//				arr3[i][j] = (i + 2) + " * " + (j + 1) + " = " + (i + 2) * (j + 1);
//			}
//		}
//		
//		for(int i = 0; i < arr3.length; i++) {
//			for(int j = 0; j < arr3[i].length; j++) {
//				System.out.println(arr3[i][j]);;
//			}
//			System.out.println();
//		}
		
		sc.close();
	}
}
