import java.util.Scanner;

public class A_if02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 나이를 입력받아
		// 13세 이하 : 어린이
		// 13세 초과 19세 이하 : 청소년
		// 19세 초과 : 성인
		// xx세는 xxx에 속합니다.
		
//		int age;
//		String type = null;
//		
//		System.out.print("나이(정수만) : ");
//		age = sc.nextInt();
//		sc.nextLine();
//		
//		
//		// if문만 이용해서
//		if(age <= 13) {
//			type = "어린이";
//		} 
//		
//		if(age > 13 && age <= 19) {
//			type = "청소년";
//		}
//		
//		if(age > 19){
//			type = "성인";
//		}
		
//		if(age <= 13) {
//			type = "어린이";
//		} else if(age <= 19) {
//			type = "청소년";
//		} else {
//			type = "성인";
//		}
		
//		System.out.printf("%d세는 %s에 속합니다.", age, type);
		
		//============================================================
		
		/*
		 * 성별을 (m/f)(대소문다 상관없음)로 입력받아 남학생인지 여학생인지
		 * 출력하는 프로그램을 작성하세요
		 * 성별(m/f) :
		 * 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		 */
		
//		String gender, result;
//		
//		System.out.print("성별(m/f) : ");
//		gender = sc.nextLine().toUpperCase();
//		
//		if (gender.equals("M")) {
//			result = "남학생입니다.";
//		} else if (gender.equals("F")) {
//			result = "여학생입니다.";
//		} else {
//			result = "잘못입력하셨습니다.";
//		}
//		
//		System.out.println(result);
		
//		char gender;
//		String result = "";
//		
//		System.out.print("성별(m/f) : ");
//		gender = sc.nextLine().charAt(0);
////		sc.close();
//		
//		if (gender == 'm' || gender == 'M') {
//			result = "남학생";
//		} else if (gender == 'f' || gender == 'F') {
//			result = "여학생";
//		} else {
//			System.out.println("잘못 입력하셨습니다.");
//			return; // 해당 메소드 자체를 빠져나가는 구문
//		}
//		
//		System.out.println(result + "입니다.");
		
		//================================================================
		
		/*
		 * 정수(양수)를 입력받아
		 * 짝수인지 홀수인지 출력하는 프로그램 작성
		 * 정수(양수) 입력 : ()
		 * 짝수입니다./홀수입니다/양수가 아닙니다. 잘못입력하셨습니다.
		 */
		
		int num;
		String result;
		
		System.out.print("정수(양수) 입력 : ");
		num = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		if(!(num > 0)) {
			System.out.println("양수가 아닙니다. 잘못입력하셨습니다.");
			return;
		}
		
		if(num % 2 == 0) {
			result = "짝수";
		} else {
			result = "홀수";
		} 
		
		System.out.println(result + "입니다.");
//		sc.close();
	}
}
