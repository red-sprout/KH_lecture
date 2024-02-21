package com.kh.Test240206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookController {
	private List<Book> list = new ArrayList<>();

	public BookController() {
		super();
		list.add(new Book("자바의 정석", "남궁성", "기타", 27000));
		list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 21000));
	}
	
	public void insertBook(Book bk) {
		list.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		return (ArrayList<Book>) this.list;
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book b : list) {
			if(b.getTitle().contains(keyword) || b.getAuthor().contains(keyword)) {
				result.add(b);
			}
		}
		return result;
	}
	
	public Book deleteBook(String title, String author) {
		for(Book b : list) {
			if(b.getTitle().equals(title) && b.getAuthor().equals(author)) {
				list.remove(b);
				return b;
			}
		}
		return null;
	}
	/*
	 * 문자열.compareTo => 두 문자열이 동일한 경우 : 0
	 * 					사전적으로 먼저 위치한 문자열이 앞에 나온 경우 : 음수
	 * 					사전적으로 먼저 위치한 문자열이 뒤에 나온 경우 : 양수
	 */
	public int ascBook() {
//		try {
//			Collections.sort(list);
//			return 1;
//		} catch(Exception e) {
//			return 0;
//		}
		try {
			this.list.sort((o1, o2) -> ((Book)o1).getTitle().compareTo(((Book)o2).getTitle()));
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}
}
