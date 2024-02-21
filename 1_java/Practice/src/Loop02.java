import java.util.Scanner;

public class Loop02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		
		System.out.print("첫 번째 숫자 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		
		while(num1 < 1) {
			System.out.print("1 이상의 숫자를 입력해주세요 : ");
			num1 = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.print("두 번째 숫자 : ");
		num2 = sc.nextInt();
		sc.nextLine();
		
		while(num2 < 1) {
			System.out.print("1 이상의 숫자를 입력해주세요 : ");
			num2 = sc.nextInt();
			sc.nextLine();
		}
		
		int min = Math.min(num1, num2);
		int max = Math.max(num1, num2);
		
		for(int i = min; i <= max; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		sc.close();
	}
}
