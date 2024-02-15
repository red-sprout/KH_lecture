import java.util.Scanner;

public class Control01 {
	public static void main(String[] args) {
		// 아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 "ㅇㅇ메뉴입니다"를,
		// 종료 번호를 누르면 "프로그램이 종료됩니다"를 출력하세요.
		
		/*
		 * ex.
		 * 
		 * 1. 입력
		 * 2. 수정
		 * 3. 조회
		 * 4. 삭제
		 * 7. 종료
		 * 메뉴번호를 입력하세요 : 4
		 * 삭제 메뉴입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String menu = null;
		
		System.out.println("1. 입력\n2. 수정\r\n3. 조회\r\n4. 삭제\r\n7. 종료");
		System.out.print("메뉴번호를 입력하세요 : ");
		num = sc.nextInt();
		
		sc.close();
		
		// if문을 사용할 경우
		if(num == 1) {
			menu = "입력";
		} else if(num == 2) {
			menu = "수정";
		} else if(num == 3) {
			menu = "조회";
		} else if(num == 4) {
			menu = "삭제";
		} else if(num == 7) {
			menu = "종료";
		} else {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		// switch문을 사용할 경우
		switch(num) {
		case 1:
			menu = "입력";
			break;
		case 2:
			menu = "수정";
			break;
		case 3:
			menu = "조회";
			break;
		case 4:
			menu = "삭제";
			break;
		case 7:
			menu = "종료";
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		System.out.println(menu + " 메뉴입니다.");
	}
}
