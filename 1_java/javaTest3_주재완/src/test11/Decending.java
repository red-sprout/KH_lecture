package test11;

import java.util.Comparator;

public class Decending implements Comparator<Object> {
	@Override
	public int compare(Object o1, Object o2) {
		return (Integer)o2 > (Integer)o1 ? 1 : -1;
	}
}
