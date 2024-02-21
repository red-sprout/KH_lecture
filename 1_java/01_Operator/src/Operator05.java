import java.util.Scanner;

public class Operator05 {
	/*
	 * 논리연산자
	 * 두개의 논리값을 연산해주는 연산자
	 * 논리연산한 결과도 논리값이다.
	 * 
	 * 논리값 && 논리값 : 왼쪽, 오른쪽 두 논리값이 모두 true일 때 결과값이 true이다.
	 * 논리값 || 논리값 : 왼쪽, 오른쪽 둘 중에 하나라도 true값이 있을 경우 true이다.
	 * 
	 * && : 두개의 조건이 모두 true(AND = ~이고, 그리고, ~이면서, 뿐만아니라)
	 * 
	 * true && true => true
	 * true && false => false
	 * false && true => false
	 * false && false => false
	 * 
	 * => && 연산자를 기준으로 앞의 결과가 false일 경우 뒤의 조건을 실행하지 않는다.
	 * 
	 * ||: 두개의 조건 중 하나라도 true이면 결과값이 true이다.(or == 또는, ~이거나)
	 * 
	 * true || true => true
	 * true || false => true
	 * false || true => true
	 * false || false => false
	 * 
	 * => || 연산자를 기준으로 앞의 결과가 true일 경우 뒤의 조건을 실행하지 않는다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		// 사용자에게 숫자를 입력받아 해당 숫자가 1 ~100사이의 값인지 확인
//		System.out.println("정수 하나 입력 : ");
//		int num1 = sc.nextInt();
//		
//		// 1 <= num1 <= 100		=>		1 <= num1 && num1 < 100
//		boolean result = (num1 >= 1) && (num1 <= 100); // num1값이 1이상 "이고" num1값이 100이하이다.
//		
//		System.out.println("사용자가 입력한 값이 1이상 100 이하입니다 : " + result);
		
		/*
		 * && : 왼쪽, 오른쪽 모든 연산의 결과가 true
		 * 		하나라도 false가 나올 시 false
		 */
		
		// 사용자에게 알파벳 하나를 입력받아 대소문자를 확인
		// 문자 하나 입력 : 
		// 사용자가 입력한 값이 대문자 입니다 : (true/false)
		
//		char c;
//		boolean result;
//		
//		System.out.print("문자 하나 입력 : ");
//		c = sc.nextLine().charAt(0);
//		
//		result = (c >= 'A') && (c <= 'Z');
//		System.out.println("사용자가 입력한 값이 대문자 입니다 : " + result);
		
		// 사용자에게 성별을 입력받은 후 여자인지 확인(* 소문자 f, 대문자 F 모두 가능)
		// 성별(M/F) :
		// 사용자가 여자입니까 : (true/false)
		
//		String gender;
//		boolean result;
//		
//		System.out.print("성별(M/F) : ");
//		gender = sc.nextLine().toUpperCase();
//		
//		result = gender.equals("F");
//		System.out.println("사용자가 여자입니까 : " + result);
		
//		char gender;
//		boolean result;
//		
//		System.out.print("성별(M/F) : ");
//		gender = sc.nextLine().charAt(0);
//		
//		result = (gender == 'F') || (gender == 'f');
//		System.out.println("사용자가 여자입니까 : " + result);
		
		int num = 10;
		boolean result1 = (num < 5) && (++num > 0); // 앞의 연산 결과가 거짓일 때
		
		System.out.println("result1 : " + result1);
		System.out.println("&&연산 후의 num : " + num);
		
		int num2 = 10;
		
		boolean result2 = true || (++num2 > 0);
		System.out.println("||연산 후의 num2 : " + num2);
		sc.close();
	}
}
