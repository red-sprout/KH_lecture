package test13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
	private String productName;
	private Date putDate;
	private Date getDate;
	private int putAmount;
	private int getAmount;
	private int inventoryAmount;
	
	public Inventory() {
		super();
	}

	public Inventory(String productName, Date putDate, int putAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.getDate = null;
		this.putAmount = putAmount;
		this.getAmount = 0;
		this.inventoryAmount = putAmount;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdfPut = new SimpleDateFormat("yyyy년 M월 dd일 입고");
		SimpleDateFormat sdfGet = new SimpleDateFormat("yyyy년 M월 dd일 출고");
		
		String getDateToString = (getDate == null) ? "null" :sdfGet.format(getDate);
		return productName + ", " 
			+ sdfPut.format(putDate) + ", " 
			+ putAmount + "개, " 
			+ getDateToString + ", " 
			+ getAmount + "개, 재고 " 
			+ inventoryAmount + "개";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough {
		if(getAmount > this.putAmount) {
			throw new AmountNotEnough("현재 재고가 부족합니다. 재고수량 확인하시기 바랍니다.");
		} else {
			this.getAmount = getAmount;
			this.inventoryAmount = this.putAmount - this.getAmount;
		}
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
}
