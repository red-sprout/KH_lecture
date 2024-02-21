import java.util.Scanner;

public class Loop01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		while(num < 1) {
			System.out.print("1 이상의 숫자를 입력해주세요 : ");
			num = sc.nextInt();
			sc.nextLine();
		}
		
		for(int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		sc.close();
	}
}
