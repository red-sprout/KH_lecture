package com.kh.Test240208;

public class Music implements Comparable<Music> {
	private String title;
	private String singer;
	
	public Music() {
		super();
	}
	
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer + " - " + title;
	}

	@Override
	public int hashCode() {
		return this.getSinger().hashCode() + this.getTitle().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Music)) return false;
		return this.hashCode() == ((Music) obj).hashCode();
	}
	
	@Override
	public int compareTo(Music o) {
		return -1 * this.getSinger().compareTo(o.getSinger());
	}
}
