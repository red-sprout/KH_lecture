import java.util.Scanner;

public class Control02 {
	// 정수형으로 국어, 영어, 수학 세 과목의 점수를 입력받아 총점과 평균을 계산하고,
	// 합격인지 불합격인지 나타내는 프로그램을 작성하세요.
	// (합격 조건 : 세과목 점수가 각각 40점 이상 그리고 평균이 60점 이상일 경우)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kor, math, eng;
		int total;
		float avg;
		
		System.out.print("국어점수 : ");
		kor = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수학점수 : ");
		math = sc.nextInt();
		sc.nextLine();
		
		System.out.print("영어점수 : ");
		eng = sc.nextInt();
		sc.nextLine();
		
		total = kor + math + eng;
		avg = (float)total / 3;
		
		if(kor < 40 || math < 40 || eng < 40 || avg < 60) {
			System.out.println("불합격입니다.");
		} else {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + total);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}
		
		sc.close();
	}	
}