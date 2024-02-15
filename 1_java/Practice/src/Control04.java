import java.util.Scanner;

public class Control04 {
	public static void main(String[] args) {
		/*
		 * 사용자에게 관리자, 회워, 비회원 중 하나를 입력받아 각 등급이 행할 수 있는 권한을 출력하세요.
		 * 단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		 * 회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		 * 비회원은 게시글 조회만 가능합니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		String str = "";
		String user;
		
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		user = sc.nextLine();
		
		switch(user) {
		case "관리자":
			str += "회원 관리, 게시글 관리, ";
		case "회원":
			str += "게시글 작성, 댓글 작성, ";
		case "비회원":
			str += "게시글 조회";
			break;
		default: 
			str = "권한이 올바르지 않습니다.";
		}
		
		System.out.println(str);
		
		sc.close();
	}
}
