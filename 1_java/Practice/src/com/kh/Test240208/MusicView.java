package com.kh.Test240208;

import java.util.List;
import java.util.Scanner;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		int input = -1;
		while (input != 9) {
			System.out.println("\n=====***** 메인 메뉴 *****=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료\n");
			
			System.out.print("메뉴 번호 입력 : ");
			input = sc.nextInt();
			sc.nextLine();
			
			switch (input) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println();
			}
		}
		
		sc.close();
	}
	
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addList(new Music(title, singer));
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addAtZero(new Music(title, singer));
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		List<Music> list = mc.printAll();
		System.out.println(list.toString());
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		Music music = mc.searchMusic(title);
		
		if (music == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(music.toString());
		}
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title);
		
		if (music == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(music.toString() + "을(를) 삭제했습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String oldTitle = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String newTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String newSinger = sc.nextLine();
		
		Music music = mc.setMusic(oldTitle, new Music(newTitle, newSinger));
		
		if (music == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			System.out.println(music.toString() + "가 값이 변경되었습니다.");
		}
	}
	
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		int result = mc.ascTitle();
		
		if (result == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
	public void descSinger() {
		System.out.println("****** 가수 명 오름차순 정렬 ******");
		int result = mc.descSinger();
		
		if (result == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}
