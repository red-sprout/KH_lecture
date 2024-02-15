package com.kh.test240124;

public class Rectangle extends Point{
	private int height;
	private int width;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(int x, int y, int height, int width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + height + ", " + width;
	}
}
