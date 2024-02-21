import java.util.Scanner;

public class Array07 {
	public static void main(String[] args) {
		String[] chicken = {"후라이드", "양념", "간장"};
		String kind;
		
		System.out.print("치킨 이름을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		kind = sc.nextLine();
		
		for(int i = 0; i < chicken.length; i++) {
			if(chicken[i].equals(kind)) {
				System.out.println(kind + "치킨 배달 가능");
				return;
			}
		}
		System.out.println(kind + "치킨은 님이 만들어 드세요.");
		
		sc.close();
	}
}
