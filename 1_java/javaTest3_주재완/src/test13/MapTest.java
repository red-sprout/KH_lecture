package test13;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Inventory> map = new HashMap<String, Inventory>();
		
		map.put("삼성 갤럭시S7", new Inventory("삼성 갤럭시S7", new Date(2016 - 1900, 3 - 1, 15), 30));
		map.put("LG G5", new Inventory("LG G5", new Date(2016 - 1900, 2 - 1, 25), 20));
		map.put("애플 아이패드 Pro", new Inventory("애플 아이패드 Pro", new Date(2016 - 1900, 1 - 1, 23), 15));
		
		for(Map.Entry<String, Inventory> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		Inventory[] items = new Inventory[3];
		int idx = 0;
		for(Map.Entry<String, Inventory> entry : map.entrySet()) {
			items[idx++] = entry.getValue();
		}
		
		System.out.println("출고 수량 10 적용시 --------------------------------------------------------------");
		try {
			for(int i = 0; i < items.length; i++) {
				items[i].setGetDate(new Date());
				items[i].setGetAmount(10);
			}
			for(int i = 0; i < items.length; i++) {
				System.out.println(items[i]);
			}
		} catch (AmountNotEnough e) {
			System.out.println(e.getMessage());
		}
	}
}
