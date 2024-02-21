package review;

import java.io.Serializable;

public class Food implements Serializable {
	private String name;
	private int kcal;
	
	public Food() {
		super();
	}

	public Food(String name, int kcal) {
		super();
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "음식이름 : " + name + ", 칼로리 : " + kcal + "kcal";
	}
}
