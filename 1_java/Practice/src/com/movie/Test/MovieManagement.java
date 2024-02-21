package com.movie.Test;

import java.util.*;

public class MovieManagement {
	private Scanner sc;
	private List<Movie> movieList;
	private Map<Movie, List<String>> reserveMap;
	
	private final String password = "admin";
	
	public MovieManagement() {
		this.sc = new Scanner(System.in);
		this.movieList = new ArrayList<>();
		this.reserveMap = new HashMap<>();
	}
	
	public void showMenu() {
		int menu = 0;
		
		while(menu != 9) {
			System.out.println("========영화 예매 페이지========");
			System.out.println("1. 좌석예매");
			System.out.println("2. 예약조회");
			System.out.println("3. 관리자메뉴");
			System.out.println("9. 종료");
			System.out.print("원하시는 번호를 입력하세요 : ");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				seatReservation();
				break;
			case 2:
				printReserveList();
				break;
			case 3:
				adminMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void seatReservation() {
		int num = -1;
		while(num <= 0 || num > movieList.size()) {
			int i = 1;
			for(Movie movie : movieList) {
				System.out.println((i++) + "번 " + movie);
			}
			
			System.out.print("원하시는 영화 번호를 입력하세요.(뒤로가기 0) : ");
			num = sc.nextInt();
			sc.nextLine();
			
			if(num < 0 || num > movieList.size()) {
				System.out.println("유효한 숫자를 입력해주세요.\n");
			}
			
			if(num == 0) {
				System.out.println("초기 메뉴로 돌아갑니다.");
				return;
			}
		}
		
		num--;
		
		Movie movie = movieList.get(num);
		
		String seat;
		int row = 0, col = 0;
		
		movie.seatList();
		boolean flag = false;
		do {
			System.out.print("예매할 자리를 입력하세요.(예시 1A, 뒤로가기 00) : ");
			seat = sc.nextLine();
			row = seat.charAt(0);
			col = seat.charAt(1);
			
			if(row == '0' && col == '0') {
				return;
			}
			
			flag = movie.reserve(row, col);
			if(!flag) {
				System.out.println("이미 선택되었거나 존재하지 않는 좌석입니다.");
			}
		} while(!flag);
		
		if(reserveMap.get(movie) == null) {
			reserveMap.put(movie, new ArrayList<>());
		}
		
		reserveMap.get(movie).add(seat);
		System.out.println("예매되었습니다.");
	}
	
	public void printReserveList() {
		int num = 1;
		for(Movie movie : reserveMap.keySet()) {
			for(String str : reserveMap.get(movie)) {
				System.out.println((num++) + "번 " + movie + " -> 좌석 : " + str);
			}
		}

		char tmp;
		System.out.print("예매 내역을 모두 삭제하시겠습니까?(y/n) : ");
		tmp = sc.nextLine().toLowerCase().charAt(0);
		
		if(tmp != 'y') {
			return;
		}
		
		for(Movie movie : reserveMap.keySet()) {
			List<String> strList = reserveMap.get(movie);
			for(String str : strList) {
				int row = str.charAt(0);
				int col = str.charAt(1);
				movie.invertSeat(row, col);
			}
		}
		
		reserveMap.clear();
	}
	
	public void adminMenu() {
		String password;
		System.out.print("Password : ");
		password = sc.nextLine();
		
		if(!this.password.equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}

		int num = -1;
		while(num != 0) {
			System.out.println("========관리자 모드========");
			System.out.println("0. 종료");
			System.out.println("1. 추가");
			System.out.println("2. 마지막 삭제");
			System.out.println("3. 보기");
			System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 0:
				System.out.println("관리자 모드를 종료합니다.");
				break;
			case 1:
				addMovie();
				break;
			case 2:
				deleteMovie();
				break;
			case 3:
				showMovie();
				break;
			default:
				System.out.println("잘못입력했습니다.");
			}
		}
	}
	
	private void addMovie() {
		String title, genre, time;
		
		System.out.print("제목 입력 : ");
		title = sc.nextLine();
		
		System.out.print("장르 입력 : ");
		genre = sc.nextLine();
		
		System.out.print("시간 입력 : ");
		time = sc.nextLine();
		
		movieList.add(new Movie(title, genre, time));
	}
	
	private void deleteMovie() {
		char tmp;
		Movie target = null;
		System.out.print("삭제하시겠습니까?(y/n) : ");
		tmp = sc.nextLine().toLowerCase().charAt(0);
		
		if(tmp == 'y') {
			target = movieList.get(movieList.size() - 1);
			movieList.remove(movieList.size() - 1);
			System.out.println("삭제되었습니다.");
			
			if(reserveMap.get(target) != null) {
				reserveMap.remove(target);
			}
		}
	}
	
	private void showMovie() {
		int idx = 1;
		for(Movie movie : movieList) {
			System.out.println((idx++) + "번 " + movie);
		}
	}
}
