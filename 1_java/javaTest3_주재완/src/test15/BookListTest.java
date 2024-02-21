package test15;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookListTest {
	public static void main(String[] args) {
		BookListTest test5 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();
		
		test5.storeList(list);
		
		test5.saveFile(list);
		
		List<Book> booksList = test5.loadFile();
		
		test5.printList(booksList);
	}
	
	public static void storeList(List<Book> list) {
		list.add(new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.15));
		list.add(new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.2));
		list.add(new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 0.1));
	}
	
	public static void saveFile(List<Book> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
			for(Book book : list) {
				oos.writeObject(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static List<Book> loadFile() {
		List<Book> list = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
			while(true) {
				list.add((Book) ois.readObject());
			}
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
		}
		return list;
	}
	
	public static void printList(List<Book> list) {
		for(Book book : list) {
			System.out.println(book);
			System.out.println("할인된 가격 : " + (int)(book.getPrice() * (1 - book.getDiscountRate())) + "원");
		}
	}
}
