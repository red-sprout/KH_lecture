import java.util.*;

public class Practice1 {
	/*
	 * 이름, 성별, 나이, 키를 사용자에게 입력받아 각가의 값을 변수에 담고 출력하세요.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		// char gender = sc.next().charAt(0);
		String gender = sc.next();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("키를 입력하세요 : ");
		float height = sc.nextFloat();
		sc.nextLine();
		
		System.out.printf("키 %.1fcm인 %d살 %s자 %s님 반갑습니다 ^^", height, age, gender, name);
	}
}
