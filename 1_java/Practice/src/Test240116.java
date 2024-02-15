import java.util.Scanner;

public class Test240116 {
	public static void main(String[] args) {
		// 정수형 변수 num1, num2를 사용자로부터 입력받아
		// + - * / % 의 결과값을 각각 출력하세요.
		
//		Scanner sc = new Scanner(System.in);
//		int num1, num2;
//		
//		System.out.print("num1 입력 : ");
//		num1 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("num2 입력 : ");
//		num2 = sc.nextInt();
//		
//		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
//		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
//		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
//		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
//		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
//		
//		sc.close();
		
		// 가위바위보를 진행합니다. user1의 가위 바위 보 정보와
		// user2의 가위 바위 보 정보를 받아 누가 이겼는지를 출력하세요.
		
//		Scanner sc = new Scanner(System.in);
//		int user1, user2;
//		
//		System.out.print("user1 가위바위보 정보(가위 = 1, 바위 = 2, 보 = 3) : ");
//		user1 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("user2 가위바위보 정보(가위 = 1, 바위 = 2, 보 = 3) : ");
//		user2 = sc.nextInt();
//		
//		if(user1 == user2) {
//			System.out.println("비겼습니다.");
//		} else if(user1 > user2) {
//			if(user1 == 3 && user2 == 1) {
//				System.out.println("user2가 이겼습니다.");
//			} else {
//				System.out.println("user1이 이겼습니다.");
//			}
//		} else {
//			if(user1 == 1 && user2 == 3) {
//				System.out.println("user1이 이겼습니다.");
//			} else {
//				System.out.println("user2가 이겼습니다.");
//			}
//		}
//		
//		sc.close();
		
		// 15 ~ 111까지의 수를 순서대로 출력하세요.
		
//		for(int i = 15; i <= 111; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		// 숫자를 입력받아 * 2인 숫자를 출력하세요.
		// 유저가 숫자 0을 입력할 때까지 반복하세요.
//		Scanner sc = new Scanner(System.in);
//		int num;
//		
//		while(true) {
//			System.out.print("숫자를 입력하세요(종료 : 0) : ");
//			num = sc.nextInt();
//			if(num == 0) break;
//			System.out.println(num * 2);
//		}
//		
//		sc.close();
		
		// 컴퓨터와의 가위바위보
		
//		Scanner sc = new Scanner(System.in);
//		int user3, computer;
//		while(true) {
//			String userResult = "", computerResult = "";
//			System.out.print("user3 가위바위보 정보(가위 = 1, 바위 = 2, 보 = 3, 종료 : 5) : ");
//			user3 = sc.nextInt();
//			
//			if(user3 == 5) {
//				System.out.println("종료되었습니다.");
//				break;
//			}
//			
//			switch(user3) {
//			case 1:
//				userResult = "가위";
//				break;
//			case 2: 
//				userResult = "바위";
//				break;
//			case 3: 
//				userResult = "보";
//				break;
//			}
//			
//			computer = (int)(Math.random() * 3 + 1);
//			
//			switch(computer) {
//			case 1: 
//				computerResult = "가위";
//				break;
//			case 2: 
//				computerResult = "바위";
//				break;
//			case 3: 
//				computerResult = "보";
//				break;
//			}
//			
//			System.out.println("user3 결과 : " + userResult);
//			System.out.println("computer 결과 : " + computerResult);
//			
//			if(user3 == computer) {
//				System.out.println("비겼습니다.");
//			} else if(user3 > computer) {
//				if(user3 == 3 && computer == 1) {
//					System.out.println("컴퓨터가 이겼습니다.");
//				} else {
//					System.out.println("user3가 이겼습니다.");
//				}
//			} else {
//				if(user3 == 1 && computer == 3) {
//					System.out.println("user3가 이겼습니다.");
//				} else {
//					System.out.println("컴퓨터가 이겼습니다.");
//				}
//			}
//			System.out.println();
//		}
//		
//		sc.close();
		
		int[] arr = new int[3];
		System.out.println(System.identityHashCode(arr));
		System.out.println(System.identityHashCode(arr[0]));
		System.out.println(System.identityHashCode(arr[1]));
		System.out.println(System.identityHashCode(arr[2]));
	}
}
