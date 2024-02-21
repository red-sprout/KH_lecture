
public class Operator03 {
	/*
	 * 산술연산자 (이항 연산자 == 두개의 값을 가지고 연산한다)
	 * + - * / %
	 * * / % > + -
	 * 
	 * 복합 대입 연산자
	 * 산술연산자와 대입연산자가 결합되어있는 형태
	 * 연산처리 속도가 빨라지므로 사용하는 걸 권장!
	 * 
	 * += -= /= *= %=
	 * 
	 * a = a + s;		->		a += 3;
	 * a = a - 3;		-> 		a -= 3;
	 * a = a * 3;		->		a *= 3;
	 * a = a / 3;		->		a /= 3;
	 * a = a % 3;		->		a /= 3;
	 */
	public static void main(String[] args) {
		int a = 5; // 5 -> 6 -> 7
		int b = 10; // 10 -> 9
		
//		a = a + b;
//		a += b;
//		
//		int score = 0;
//		
//		score += 100; -> 복합 대응 연산자
		
		int c = (++a) + b; // 16 -> 15
		int d = c / a; // 2 -> 1
		int e = c % a; // 4 -> 5 -> 6
		int f = e++; // 4
		int g = (--b) + (d--); // 11 -> 10
		int h = 2; // 2
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
		// 6 + 9 / (15 / 4) * (11 - 1) % (6 + 2)
		// 6 + 3 * 10 % 8
		// 6 + 6 = 12
		
//		System.out.println(a + b);
//		System.out.println(a - b);
//		System.out.println(a * b);
//		System.out.println(a / b);
//		System.out.println(a % b);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
	}
}
