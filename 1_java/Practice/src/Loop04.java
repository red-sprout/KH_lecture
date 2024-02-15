import java.util.Scanner;

public class Loop04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command;
		int num1, num2;
		
		while(true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			command = sc.nextLine();
			
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.print("정수1 : ");
			num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("정수2 : ");
			num2 = sc.nextInt();
			sc.nextLine();
			
			int ans;
			
			switch(command) {
			case "+":
				ans = num1 + num2;
				System.out.printf("%d %s %d = %d\n", num1, command, num2, ans);
				break;
			case "-":
				ans = num1 - num2;
				System.out.printf("%d %s %d = %d\n", num1, command, num2, ans);
				break;
			case "*":
				ans = num1 * num2;
				System.out.printf("%d %s %d = %d\n", num1, command, num2, ans);
				break;
			case "/":
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					break;
				}
				ans = num1 / num2;
				System.out.printf("%d %s %d = %d\n", num1, command, num2, ans);
				break;
			case "%":
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					break;
				}
				ans = num1 % num2;
				System.out.printf("%d %s %d = %d\n", num1, command, num2, ans);
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
			}
		}
		
		sc.close();
	}
}
