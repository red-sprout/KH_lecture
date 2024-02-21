package com.kh.Test2402062;

import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery> {
	
	@Override
	public int compare(Lottery l1, Lottery l2) {
		if(l1.getName().compareTo(l2.getName()) == 0) {
			return l1.getPhone().compareTo(l2.getPhone());
		} else {
			return l1.getName().compareTo(l2.getName());
		}
	}
}
