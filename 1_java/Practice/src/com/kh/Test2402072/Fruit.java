package com.kh.Test2402072;

public class Fruit extends Farm {
	private String name;

	public Fruit() {
		super();
	}

	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + ": " + name;
	}

	@Override
	public int hashCode() {
		return super.getKind().hashCode() + this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Fruit)) {
			return false;
		}
		return this.toString().equals(((Fruit) obj).toString());
	}
}
