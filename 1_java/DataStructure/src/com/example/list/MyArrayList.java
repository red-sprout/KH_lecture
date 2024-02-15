package com.example.list;

public class MyArrayList<E> implements MyList<E> {
	private Object[] array;
	private int size;
	private int index;

	public MyArrayList() {
		super();
		this.size = 1;
		this.array = new Object[this.size];
		this.index = 0;
	}

	public void doubling() {
		this.size = this.size * 2;
		Object[] newArray = new Object[this.size];
		for(int i = 0; i < array.length; i++) {
			 newArray[i] = array[i];
		}
		this.array = newArray;
	}
	
	@Override
	public void add(E e) {
		if(this.index == this.size - 1) {
			doubling();
		}
		array[this.index++] = e;
	}

	@Override
	public boolean contains(E e) {
		for(int i = 0; i <= this.index; i++) {
			if(array[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		return (E)array[index];
	}

	@Override
	public int indexOf(E e) {
		for(int i = 0; i <= this.index; i++) {
			if(array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		for(int i = index; i < this.size; i++) {
			array[i] = array[i + 1];
		}
		this.index--;
	}

	@Override
	public void set(int index, E element) {
		array[index] = element;
	}

	@Override
	public int size() {
		return this.index + 1;
	}
}
