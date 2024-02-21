package com.movie.Test;

public class Movie {
	private String title;
	private String genre;
	private String time;
	private int reservationNum = 0;
	private boolean[][] seat;
	
	public Movie(String title, String genre, String time) {
		this.title = title;
		this.genre = genre;
		this.time = time;
		this.seat = new boolean[8][8];
	}
	
	public void seatList() {
		int rowNum = 1;
		char colNum = 'A';
		for(int i = 0; i <= 8; i++) {
			for(int j = 0; j <= 8; j++) {
				if(i == 0) {
					if(j == 0) {
						System.out.print("  ");
						continue;
					}
					System.out.print((char)(colNum++) + " ");
				} else if(j == 0) {
					System.out.print((rowNum++) + " ");
				} else {
					System.out.print(seat[i - 1][j - 1] ? "X " : "O ");
				}
			}
			System.out.println();
		}
	}
	
	public boolean reserve(int row, int col) {
		row = row - '0' - 1;
		col = col - 'A';
		
		if(row < 0 || row >= 8 || col < 0 || col >= 8) {
			return false;
		} else if(seat[row][col]) {
			return false;
		} else {
			reservationNum++;
			seat[row][col] = true;
			return true;
		}
	}
	
	public void deletaReservation(int key) {
		
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public int remainSeats() {
		return 64 - this.reservationNum;
	}
	
	public void invertSeat(int row, int col) {
		row = row - '0' - 1;
		col = col - 'A';
		seat[row][col] = !seat[row][col];
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", time=" + time + "]";
	}
}
