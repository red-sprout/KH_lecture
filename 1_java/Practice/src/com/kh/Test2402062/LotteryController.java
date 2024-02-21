package com.kh.Test2402062;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		try {
			lottery.remove(l);
		} catch (Exception e) {
			return false;
		}
		
		if(win == null) {
			return false;
		}
		
		for(Lottery lotto : win) {
			if(lotto.equals(l)) {
				win.remove(lotto);
				return true;
			}
		}
		
		return false;
	}
	
	public HashSet<Lottery> winObject() {
		List<Lottery> list = new ArrayList<>(lottery);
		
		if(list.size() < 4) {
			System.out.println("대상자가 부족합니다.");
			return null;
		}
		
		while (win.size() < 4) {
			int rand = (int)(Math.random() * list.size());
			win.add(list.get(rand));
		}
		
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> set = new TreeSet<>(new SortedLottery());
		set.addAll(win);
		return set;
	}
	
	public boolean searchWinner(Lottery l) {
		for(Lottery lotto : win) {
			if(lotto.equals(l)) {
				return true;
			}
		}
		return false;
	}
}
