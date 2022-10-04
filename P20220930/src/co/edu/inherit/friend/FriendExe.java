package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe extends Friend{
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	// 친구등록 - 학교/회사/친구...
	public void exe() {
		
		
		while(true) {
			System.out.println("1.친구 등록, 2.친구 조회, 3.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();
				scn.nextLine();
				if(subMenu ==1) {
					addComFriend();
				}else if(subMenu ==2) {
					addUnivFriend();
				}else if(subMenu ==3) {
					addFriend();
				}
			}else if(menu == 2) {
				searchFriend();
			}else if(menu == 3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다");
			}
		}
		System.out.println("프로그램 종료");
	} // end of exe()
	
	// 추가 메소드
	public void addComFriend() {
		System.out.print("회사 친구 이름>> ");
		String name = scn.nextLine();
		System.out.print("회사 친구 연락처>> ");
		String phone = scn.nextLine();
		System.out.print("회사 친구 회사 이름>> ");
		String company = scn.nextLine();
		System.out.print("회사 친구 부서 이름>> ");
		String dept = scn.nextLine();
		
		ComFriend comfrnd = new ComFriend(name, phone, company, dept);
//		for(int i=0; i < friends.size(); i++) {
//			if(friends[i] == null) {
//				friends[i] = comfrnd;
//				break;
//			}
//		}
		friends.add(comfrnd);
	}
	public void addUnivFriend() {
		System.out.print("학교 친구 이름>> ");
		String name = scn.nextLine();
		System.out.print("학교 친구 연락처>> ");
		String phone = scn.nextLine();
		System.out.print("학교 친구 학교 이름>> ");
		String univ = scn.nextLine();
		System.out.print("학교 친구 전공 이름>> ");
		String major = scn.nextLine();
		
		UnivFriend univfrnd = new UnivFriend(name, phone, univ, major);
//		for(int i=0; i < friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = univfrnd;
//				break;
//			}
//		}
		friends.add(univfrnd);
	}
	public void addFriend() {
		System.out.print("친구 이름>> ");
		String name = scn.nextLine();
		System.out.print("친구 연락처>> ");
		String phone = scn.nextLine();
		
		Friend frnd = new Friend(name, phone);
//		for(int i=0; i < friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = frnd;
//				break;
//			}
//		}
		friends.add(frnd); // 비워져있는 위치에 한 건 등록.
	}
	public void searchFriend() {
//		System.out.println("친구 조회 기능");
//		System.out.print("조회할 친구 이름을 입력하세요>> ");
//		String name = scn.nextLine();
//		for(int i=0; i < friends.length; i++) {
//			if(friends[i] != null && friends[i].getName().equals(name)) {
//				System.out.println(friends[i].showInfo());
//			}
//			if(friends[i] != null && friends[i].getName().indexOf("미") > -1) {
//				System.out.println(friends[i].getName());
//			}
		
		System.out.println("찾을 친구이름 입력>> ");
		String searchKey = scn.nextLine(); // '미'
		for(int i=0; i < friends.size(); i++) {
			// Friend 클래스의 상속. Friend, ComFriend, UnivFriend
			Object frnd = friends.get(i);// Object타입을 Friend 클래스로 바꿔야함
			if(frnd instanceof Friend) { // frnd 변수의 타입이 어떤 유형의 클래스인지 구분
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
			
//			if(friends.get(i) != null && friends.get(i).getName().contains(searchKey)) {
//					System.out.println(friends.get(i).showInfo());
//			}	
		}
		
		// 권수미, 권미현, 강민기
	}
}
