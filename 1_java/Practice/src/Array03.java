import java.util.Scanner;

public class Array03 {
	public static void main(String[] args) {
		/*
		 * 문자열을 입력받아 문자 하나하나를 배열에 넣고 검색할 문자열에 몇개 들어가 있는지
		 * 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		String str;
		char letter;
		int cnt = 0;
		
		System.out.print("문자열 : ");
		str = sc.nextLine();
		
		System.out.print("문자 : ");
		letter = sc.nextLine().charAt(0);
		
		int l = str.length();
		
		System.out.print(str + "에 " + letter + "가 존재하는 위치(인덱스) : ");
		for(int i = 0; i < l; i++) {
			if(str.charAt(i) == letter) {
				cnt++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.println(letter + " 개수 : " + cnt);
		sc.close();
	}
}
