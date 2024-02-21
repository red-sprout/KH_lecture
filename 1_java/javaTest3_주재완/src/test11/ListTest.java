package test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
	
		for(int i = 0; i < 10; i++) {
			list.add(random.nextInt(100) + 1);
		}
		
		System.out.print("정렬전 : ");
		display(list);
		
		System.out.println();
		Collections.sort(list, new Decending());
		Collections.sort(list, (o1, o2) -> {return (o2 - o1);});
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.print("정렬후 : ");
		display(list);
	}
	public static void display(List<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
