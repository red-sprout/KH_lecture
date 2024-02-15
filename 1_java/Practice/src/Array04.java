import java.util.Scanner;

public class Array04 {
	public static void main(String[] args) {
		/*
		 * 월요일부터 일요일까지 요일에 대한 정보를 가지고 있는 배열을 하나 만들어 줍니다.
		 * 0~6까지의 숫자를 입력받아 해당 인덱스에 있는 요일을 출력하고 범위에 없는 숫자를 입력시
		 * 0~6사이의 숫자를 입력하세요 : 를 출력하고 다시 입력을 받습니다.
		 */
		Scanner sc = new Scanner(System.in);
		char[] day = {'일', '월', '화', '수', '목', '금', '토'};
		int idx;
		
		while(true) {
			System.out.print("0~6사이의 숫자를 입력하세요 : ");
			idx = sc.nextInt();
			sc.nextLine();
			
			if(idx <= 6 && idx >= 0) break;
		}
		
		System.out.println(day[idx] + "요일입니다.");
		
		sc.close();
	}
}
