package test4;

public class ProductTest {
	public static void main(String[] args) {
		Product product = new Product("갤럭시 s7", 563500, 3);
		
		int totalPurchase = product.getPrice() * product.getQuantity();
		
		System.out.println(product.information() + "총 구매 가격 : " + totalPurchase + " 원");
	}
}
