public class LineComment {
	public static void main(String [] args) {
		/* 
		 * 주석
		 * 코드를 설명하거나 의견을 메모할 때
		 * 코드에 영향을 주지않고 작성할 수 있는 것
		 * (컴파일시 주석은 코드에서 자동으로 삭제된다.)
		 * 
		 * 한줄을 표현할때는 //내용 과 같이 작성하고
		 * 여려줄의 주석을 표현하고 싶을 떄는 /* 내용 */
		/* 처럼 작성하면 된다
		 */
		
		System.out.println(100); //단순한 정수 출력
		
		/*인사말과 함께
		이름을 출력
		*/
		System.out.println("안녕하세요");
		System.out.println("최지원 입니다");
		
		//덧셈 결과 출력(보통 위에 주석을 담)
		System.out.println(3 + 5 + 312);
		System.out.println(5*12);
		System.out.print("5 * 12 = ");
		System.out.println(5*12);
		System.out.println("3 + 5 " + "의 연산 결과는 " + (3+5) + "입니다" );
		System.out.println(3.15 + "는 실수입니다.");
	}
}
