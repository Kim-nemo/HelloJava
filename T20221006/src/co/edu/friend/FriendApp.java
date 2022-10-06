package co.edu.friend;

import java.util.Scanner;

public class FriendApp{

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		FriendService service = FriendListImpl.getInstance(); // FriendListImpl 인스턴스 생성.
//		Friend[] friends = new Friend[10];

		while (true) {
			System.out.println("1.추가 2.리스트 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt(); scn.nextLine();
			if (menu == 1) { //
				System.out.println("1.학교친구 2.회사친구 3.친구");
				Friend friend = new Friend();

				int subMenu = scn.nextInt();
				scn.nextLine();
				if (subMenu == 1) {
					// 학교친구정보등록
					System.out.print("학교친구 이름>> ");
					String name = scn.nextLine();
					System.out.print("학교친구 연락처>> ");
					String phoneNumber = scn.nextLine();
					System.out.print("학교친구 학교이름>> ");
					String collage = scn.nextLine();
					System.out.print("학교친구 전공이름>> ");
					String major = scn.nextLine();
					
					friend = new UniFriend(name, phoneNumber, collage, major);
//					service.addUniFriend(unifrnd);
				} else if (subMenu == 2) {
					// 회사친구등록
					System.out.print("회사친구 이름>> ");
					String name = scn.nextLine();
					System.out.print("회사친구 연락처>> ");
					String phoneNumber = scn.nextLine();
					System.out.print("회사친구 회사이름>> ");
					String company = scn.nextLine();
					System.out.print("회사친구 부서이름>> ");
					String department = scn.nextLine();
					
					friend = new CoFriend(name, phoneNumber, company, department);
//					service.addCoFriend(cofrnd);
				} else {
					// 친구정보등록
					System.out.print("친구 이름>> ");
					String name = scn.nextLine();
					System.out.print("친구 연락처>> ");
					String phoneNumber = scn.nextLine();
					
					friend = new Friend(name, phoneNumber);
//					service.addFriend(frnd);
				}
				service.addFriend(friend);

			} else if (menu == 2) {
				Friend[] list = service.friendList();
//				System.out.println("친구조회기능");
//				System.out.println("조회할 친구 이름을 입력하세요>>");
				// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용.
//				String name = scn.nextLine();
				for(int i=0; i < list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].getInfo());
					}
				}
			} else if (menu == 3) {
				System.out.println("변경할 친구이름입력>> ");
				String name = scn.nextLine();
				System.out.println("변경할 연락처 입력>> ");
				String number = scn.nextLine();

				service.modFriend(name, number);

			} else if (menu == 4) {
//				Friend[] list = service.friendList();
				System.out.println("삭제할 친구의 연락처를 입력>> ");
				String phoneNo = scn.nextLine();
				service.delFriend(phoneNo);
//				for(int i=0; i<list.length; i++) {
//					if(list[i].getPhoneNumber().equals(phoneNo)) {
//						
//					}
//				}
				 // phoneNo를 매개값으로 사용하도록 관련된 인터페이스와 클래스를 수정.

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}

		}
		System.out.println("프로그램 종료.");
		scn.close();
	}
}
