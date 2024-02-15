package com.kh.test240125;

public class LibraryController {
	private Member mem;
	private Book[] bList;
	
	public LibraryController() {
		this.mem = null;
		this.bList = new Book[5];
		this.bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		this.bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		this.bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		this.bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		this.bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return this.bList;
	}
	
	public Book[] seachBook(String keyword) {
		Book[] book = new Book[5];
		
		int idx = 0;
		for(int i = 0; i < this.bList.length; i++) {
			String title = bList[i].getTitle();
			if(title.contains(keyword)) {
				book[idx++] = bList[i];
			}
		}
		
		return book;
	}
	
	public int rentBook(int index) {
		int result = 0;
		
		Book book = this.bList[index];
		if(book instanceof AniBook) {
			if(((AniBook) book).getAccessAge() > mem.getAge()) {
				result = 1;
			}
		} else if(book instanceof CookBook){
			if(((CookBook) book).isCoupon()) {
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}
		
		return result;
	}
}
