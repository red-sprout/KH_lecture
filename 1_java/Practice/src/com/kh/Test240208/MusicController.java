package com.kh.Test240208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		try {
			list.add(music);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int addAtZero(Music music) {
		try {
			list.add(0, music);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<Music> printAll() {
		return this.list;
	}
	
	public Music searchMusic(String title) {
		for (Music m : list) {
			if (m.getTitle().equals(title)) {
				return m;
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for (Music m : list) {
			if (m.getTitle().equals(title)) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		int index = 0;
		for (Music m : list) {
			if (m.getTitle().equals(title)) {
				list.set(index, music);
				return m;
			}
			index++;
		}
		return null;
	}
	
	public int ascTitle() {
		try {
			Collections.sort(list, new AscTitle());
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int descSinger() {
		try {
			Collections.sort(list);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
