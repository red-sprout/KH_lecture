import java.util.Scanner;

public class Array06 {
	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if(!(num % 2 == 0 || num < 0)) break;
			
			System.out.println("다시 입력하세요.");
		}
		 
		int[] arr = new int[num];
		
//		for(int i = 0; i < num; i++) {
//			if(i <= num / 2) arr[i] = i + 1;
//			else arr[i] = num - i;
//		}
		
		int start = 0;
		int end = num - 1;
		int value = 1;
		while(start <= end) {
			arr[start++] = arr[end--] = value++;
		}
		
		for(int i = 0; i < num; i++) {
			System.out.print(arr[i]);
			if(i != num - 1) System.out.print(", ");
		}
		System.out.println();
		
		sc.close();
	}
}
