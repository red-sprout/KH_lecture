import java.util.Scanner;

public class LoopTest {
	public static void main(String[] args) {
		
//		System.out.println("반복문 시작전");
//		// for (초기식; 조건식; 증감식)
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("반복문 실행 : " + i);
//		}
//		System.out.println("반복문 종료");
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String menu = null;
		
		num = 0;
		
		while(num != 7) {
			System.out.println("1. 입력\n2. 수정\r\n3. 조회\r\n4. 삭제\r\n7. 종료");
			System.out.print("메뉴번호를 입력하세요 : ");
			num = sc.nextInt();
			
			if(num == 1) {
				menu = "입력";
				System.out.println(menu + " 메뉴입니다.");
			} else if(num == 2) {
				menu = "수정";
				System.out.println(menu + " 메뉴입니다.");
			} else if(num == 3) {
				menu = "조회";
				System.out.println(menu + " 메뉴입니다.");
			} else if(num == 4) {
				menu = "삭제";
				System.out.println(menu + " 메뉴입니다.");
			} else if(num == 7) {
				menu = "종료";
				System.out.println(menu + " 메뉴입니다.");
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		
		sc.close();
	}
}
