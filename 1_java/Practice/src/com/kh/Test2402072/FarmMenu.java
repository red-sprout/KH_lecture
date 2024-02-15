package com.kh.Test2402072;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		int select = -1;
		while (select != 9) {
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료\n");
			
			System.out.print("메뉴 번호 입력 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				sc.close();
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		int select = -1;
		while (select != 9) {
			System.out.println("=====***** 직원 메뉴 *****=====");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기\n");
			
			System.out.print("메뉴 번호 입력 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void customerMenu() {
		int select = -1;
		while (select != 9) {
			System.out.println("현재 KH마트 농산물 수량");
			printFarm();
			System.out.println("\n=====***** 고객 메뉴 *****=====");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 종료\n");
			
			System.out.print("메뉴 번호 입력 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addNewKind() {
		boolean isContinue = true;
		boolean isAdd = false;
		int kind = 0;
		String name = null;
		int amount = 0;
		Farm f = null;
		while (isContinue) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			kind = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("수량 : ");
			amount = sc.nextInt();
			sc.nextLine();
			
			isContinue = false;
			
			switch (kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
			
			if(isContinue) {
				continue;
			}
			
			isAdd = fc.addNewKind(f, amount);
			if(isAdd) {
				System.out.println("새 농산물이 추가되었습니다.");
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
		}
	}
	
	public void removeKind() {
		boolean isContinue = true;
		boolean isRemove = false;
		int kind = 0;
		String name = null;
		Farm f = null;
		while (isContinue) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			kind = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			
			isContinue = false;
			
			switch (kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
			
			if(isContinue) {
				continue;
			}
			
			isRemove = fc.removeKind(f);
			if(isRemove) {
				System.out.println("농산물 삭제에 성공하였습니다.");
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
		}
	}
	
	public void changeAmount() {
		boolean isContinue = true;
		boolean isChange = false;
		int kind = 0;
		String name = null;
		int amount = 0;
		Farm f = null;
		while (isContinue) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			kind = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("수정할 수량 : ");
			amount = sc.nextInt();
			sc.nextLine();
			
			isContinue = false;
			
			switch (kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
			
			if(isContinue) {
				continue;
			}
			
			isChange = fc.changeAmount(f, amount);
			if(isChange) {
				System.out.println("“농산물 수량이 수정되었습니다.");
			} else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
		}
	}
	
	public void printFarm() {
		HashMap<Farm, Integer> hMap = fc.printFarm();
		for(Farm f : hMap.keySet()) {
			System.out.println(f + "(" + hMap.get(f) + "개)");
		}
	}
	
	public void buyFarm() {
		boolean isContinue = true;
		boolean isAdd = false;
		int kind = 0;
		String name = null;
		Farm f = null;
		while (isContinue) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			kind = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			
			isContinue = false;
			
			switch (kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
			
			if(isContinue) {
				continue;
			}
			
			isAdd = fc.buyFarm(f);
			if(isAdd) {
				System.out.println("구매에 성공하였습니다.");
			} else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
				isContinue = true;
			}
		}
	}
	
	public void removeFarm() {
		boolean isContinue = true;
		boolean isRemove = false;
		int kind = 0;
		String name = null;
		Farm f = null;
		while (isContinue) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소 종류 번호 : ");
			kind = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			
			isContinue = false;
			
			switch (kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				isContinue = true;
			}
			
			if(isContinue) {
				continue;
			}
			
			isRemove = fc.removeFarm(f);
			if(isRemove) {
				System.out.println("구매 취소에 성공하였습니다.");
			} else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
				isContinue = true;
			}
		}
	}
	
	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
