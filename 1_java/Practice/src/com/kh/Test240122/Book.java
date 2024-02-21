package com.kh.Test240122;

public class Book {
	private String genre;
	private String title;
	private String author;
	private int number;
	
	public Book(String title, String genre, String author, int number) {
		this.genre = genre;
		this.title = title;
		this.author = author;
		this.number = number;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "[genre=" + genre + ", title=" + title + ", author=" + author + ", number=" + number + "]";
	}
}
