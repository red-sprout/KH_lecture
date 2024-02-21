
public class OperatorTest {
	public static void main(String[] args) {
		int num1 = 7;
		int num2 = 3;
//		System.out.println("num1 / num2 = " + (num1 / num2));
//		System.out.println("num1 / num2 = " + (7.0 / 3.0));
		
//		num1 += num2;	// num1 = num1 + num2;
						// num1 = 7 + 3;
		
		num1 %= num2;	// num1 = num1 % num2;
						// num1 = 7 % 3;
		
		System.out.println(num1); // case1 : 10 case2 : 1
		System.out.println(num2); // case1 : 3 case2 : 3
		
		// ++num 전위 연산일 경우 먼저 연산 진행 후 코드 실행
		// num++ 후위 연산일 경우 먼저 코드 실행 후 연산 진행
		int num = 0;
		System.out.println(num++);
		System.out.println(++num);
		System.out.println(num--);
		System.out.println(--num);
	}
}
