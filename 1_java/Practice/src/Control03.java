import java.util.Scanner;

public class Control03 {
	public static void main(String[] args) {
		// 아이디와 비밀번호를 입력받아 지정해둔 아이디와 비밀번호와 비교해서
		// 로그린 성공 시 로그인 성공
		// 아이디가 틀렸을 시 "아이디가 틀렸습니다"
		// 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다"를 출력하세요.
		
		String id = "myId";
		String pwd = "myPassword12";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String inputPwd = sc.nextLine();
		
		if(!inputId.equals(id)) {
			System.out.println("아이디가 틀렸습니다.");
		} else if(!inputPwd.equals(pwd)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("로그린 성공");
		}
	}
}
