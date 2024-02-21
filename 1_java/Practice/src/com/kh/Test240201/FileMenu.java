package com.kh.Test240201;

import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		int num = -1;
		while (num != 9) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3 : 
				fileEdit();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void fileSave() {
		String input = null;
		String file = null;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			System.out.println("파일에 저장할 내용을 입력하세요");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			input = sc.nextLine();
			
			if(input.equals("ex끝it")) {
				break;
			}
			
			sb.append(input + "\n");
		}
		
		while (true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			file = sc.nextLine();
			
			if(fc.checkName(file)) {
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까? (y/n) : ");
				char select = sc.nextLine().toLowerCase().charAt(0);
				if(select == 'y') break;
			} else {
				break;
			}
		}
		
		fc.fileSave(file, sb);
	}
	
	public void fileOpen() {
		String file = null;
		System.out.print("열 파일 명 : ");
		file = sc.nextLine();
		
		if(fc.checkName(file)) {
			System.out.println(fc.fileOpen(file));
		} else {
			System.out.println("없는 파일입니다.");
		}
	}
	
	public void fileEdit() {
		String file = null;
		System.out.print("수정할 파일 명 : ");
		file = sc.nextLine();
		
		if(fc.checkName(file)) {
			fc.fileOpen(file);
		} else {
			System.out.println("없는 파일입니다.");
			return;
		}
		
		String input = null;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			System.out.println("파일에 저장할 내용을 입력하세요");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			input = sc.nextLine();
			
			if(input.equals("ex끝it")) {
				break;
			}
			
			sb.append(input + "\n");
		}
		
		fc.fileEdit(file, sb);
	}
}
