import java.util.Scanner;

public class Test240117 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사용자로부터 정수형 변수 num1과 num2를 입력받아 큰값에서 작은값을 뺀 결과를 출력하세요.
		
//		System.out.print("num1 입력 : ");
//		int num1 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("num2 입력 : ");
//		int num2 = sc.nextInt();
//		sc.nextLine();
//		
//		int res1 = num1 > num2 ? num1 - num2 : num2 - num1;
//		System.out.println(res1);
		
		//85에서 10까지 수를 1씩 줄여가며 모든 숫자 출력
		
//		for(int i = 85; i >= 10; i--) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		//1~5 생성 후 몇번만에 맞추었는지 출력
		
//		int cnt = 1;
//		int computer = (int)(Math.random() * 5 + 1);
//		while(true) {
//			System.out.print("컴퓨터가 생각하는 수는 : ");
//			int user = sc.nextInt();
//			sc.nextLine();
//			
//			if(computer == user) {
//				System.out.printf("정답입니다 %d번만에 맞추셨습니다.\n", cnt);
//				break;
//			}
//			
//			cnt++;
//		}
		
		//길이 10인 배열 선언 후 1~10까지 값을 대입하고 출력
		
//		int[] arr = new int[10];
//		int value = 1;
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = value++;
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(i + " ");
//		}
		
		//로또 추첨 번호를 예상하는 프로그램 작성
		//임의의 숫자를 1에서 45까지 총 6개 추첨하여 당첨번호를 구합니다.
		//중복된 숫자는 있으면 안된다.
		
		int[] lotto = new int[45];
		int value = 1;
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = value++;
		}
		
		for(int i = 0; i < 10000; i++) {
			int idx1 = (int)(Math.random() * 45);
			int idx2 = (int)(Math.random() * 45);
			
			if(idx1 == idx2) continue;
			
			int tmp = lotto[idx1];
			lotto[idx1] = lotto[idx2];
			lotto[idx2] = tmp;
		}
		
		System.out.print("당첨번호 : ");
		for(int i = 0; i < 6; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		
		sc.close();
	}
}
