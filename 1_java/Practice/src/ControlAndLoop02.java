import java.util.Scanner;

public class ControlAndLoop02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, userInput;
		String[] rockSissorPaper = {"가위", "바위", "보"};
		int computer;
		int cnt = 0, cntWin = 0, cntDraw = 0, cntLose = 0;
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		name = sc.nextLine();
		
		while(true) {
			System.out.print("가위바위보 : ");
			userInput = sc.nextLine();
			
			if(userInput.equals("exit")) break;
			
			computer = (int)(Math.random() * 3);
			
			if(userInput.equals("가위")) {
				cnt++;
				System.out.println("컴퓨터 : " + rockSissorPaper[computer]);
				System.out.println(name + " : " + userInput);
				switch(computer) {
				case 0: 
					System.out.println("비겼습니다.");
					cntDraw++;
					break;
				case 1: 
					System.out.println("졌습니다 ㅠㅠ");
					cntLose++;
					break;
				default: 
					System.out.println("이겼습니다 !");
					cntWin++;
				}
			} else if(userInput.equals("바위")) {
				cnt++;
				System.out.println("컴퓨터 : " + rockSissorPaper[computer]);
				System.out.println(name + " : " + userInput);
				switch(computer) {
				case 0: 
					System.out.println("이겼습니다 !");
					cntWin++;
					break;
				case 1: 
					System.out.println("비겼습니다.");
					cntDraw++;
					break;
				default: 
					System.out.println("졌습니다 ㅠㅠ");
					cntLose++;
				}
			} else if (userInput.equals("보")) {
				cnt++;
				System.out.println("컴퓨터 : " + rockSissorPaper[computer]);
				System.out.println(name + " : " + userInput);
				switch(computer) {
				case 0: 
					System.out.println("졌습니다 ㅠㅠ");
					cntLose++;
					break;
				case 1: 
					System.out.println("이겼습니다 !");
					cntWin++;
					break;
				default: 
					System.out.println("비겼습니다.");
					cntDraw++;
				}
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			System.out.println();
		}
		
		System.out.printf("%d전 %d승 %d무 %d패\n", cnt, cntWin, cntDraw, cntLose);
		
		sc.close();
	}
}
