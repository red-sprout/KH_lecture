import java.util.Scanner;

public class ControlAndLoop01 {
	public static void main(String[] args) {
		/*
		 * 사용자로부터 문자열을 입력받고 문자열의 검색될 문자를 입력받아 해당문자가 몇 개 있는지 개수 출력
		 * 다시하시겠습니까?(y/n) : y 입력시에만 다시 반복
		 * 
		 * 문자열 : banana
		 * 문자 : a
		 * banana 안에 포함된 a의 개수 : 3
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		char letter, retry;
		int cnt;
		while(true) {
			cnt = 0;
			
			System.out.print("문자열 : ");
			str = sc.nextLine();
			
			System.out.print("문자 : ");
			letter = sc.nextLine().charAt(0);
			
			for(int i = 0; i < str.length(); i++) {
				if(letter == str.charAt(i)) {
					cnt++;
				}
			}
			
			System.out.println(str + " 안에 포함된 " + letter + "의 개수 : " + cnt);
			
			System.out.print("다시하시겠습니까?(y/n) : ");
			retry = sc.nextLine().charAt(0);
			
			if(retry != 'y') break;
		}
		
		sc.close();
	}
}
