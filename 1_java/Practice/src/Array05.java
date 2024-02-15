import java.util.Scanner;

public class Array05 {
	public static void main(String[] args) {
		int n;
		int sum = 0;
		int[] arr;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		n = sc.nextInt();
		sc.nextLine();
		
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("배열 " + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
			sc.nextLine();
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\n총 합 : " + sum);
		sc.close();
	}
}
