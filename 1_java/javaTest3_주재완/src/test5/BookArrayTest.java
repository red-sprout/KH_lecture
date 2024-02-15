package test5;

public class BookArrayTest {
	public static void main(String[] args) {
		Book bArray[] = new Book[3];
		
		bArray[0] = new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.1);
		bArray[1] = new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.1);
		bArray[2] = new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 0.1);
		
		for(Book book : bArray) {
			System.out.println(book.getTitle() + ", "
							+ book.getAuthor() + ", "
							+ book.getPublisher() + ", "
							+ book.getPrice() + "원, "
							+ (int)(book.getDiscountRate() * 100) + "% 할인");
			System.out.println("할인된 가격 : " + (int)(book.getPrice() * (1 - book.getDiscountRate())) + "원");
		}
	}
}
