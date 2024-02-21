import java.util.Scanner;

public class Loop03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		System.out.print("숫자 : ");
		num = sc.nextInt();
		
		while(num > 9 || num < 1) {
			System.out.print("1에서 9 사이의 숫자만 입력해주세요 : ");
			num = sc.nextInt();
		}
		
		for(int i = num; i < 10; i++) {
			System.out.printf("===== %d단 =====\n", i);
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}
		
		sc.close();
	}
}
