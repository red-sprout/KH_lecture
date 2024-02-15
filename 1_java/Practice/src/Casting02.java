import java.util.*;

public class Casting02 {
	// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력받아 총점과 평균을 출력하세요.
	// 이 때 총점과 평균은 정수형으로 처리하세요.
	
	/*
	 * ex.
	 * 국어 : 90.0
	 * 수학 : 90.0
	 * 영어 : 90.0
	 * 
	 * 총점 : 270
	 * 평균 : 90
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float kor, math, eng;
		int total;
		
		System.out.print("국어 : ");
		kor = sc.nextFloat();
		sc.nextLine();
		
		System.out.print("수학 : ");
		math = sc.nextFloat();
		sc.nextLine();
		
		System.out.print("영어 : ");
		eng = sc.nextFloat();
		sc.nextLine();
		
		total = (int)(kor + math + eng);
		
		System.out.println("\n총점 : " + total);
		System.out.println("평균 : " + total / 3);
		
		sc.close();
	}	
}
