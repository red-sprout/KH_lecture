package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodsTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		Goods goods = new Goods();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("상품명 : ");
			String name = br.readLine();
			System.out.print("가격 : ");
			int price = Integer.parseInt(br.readLine());
			System.out.print("수량 : ");
			int quantity = Integer.parseInt(br.readLine());
			
			goods = new Goods(name, price, quantity);
			
			System.out.println("입력된 결과는 다음과 같습니다.");
			System.out.println(goods);
			System.out.println("총 구매 가격 : " + goods.getPrice() * goods.getQuantity() + " 원");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
