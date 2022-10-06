package co.edu.friend;

import java.util.Scanner;


public class FriendListImpl implements FriendService {
	Scanner scn = new Scanner(System.in);

	Friend[] friendList = new Friend[10]; // 친구정보 10명을 저장할 수 있는 공간생성 완료.
//	int idx;

	private static FriendListImpl instance = new FriendListImpl();

	FriendListImpl() {}

	public static FriendListImpl getInstance() {
		return instance;
	}

	@Override
	public void addFriend(Friend friend) {
		// 배열에 친구정보를 저장하도록 추가하세요.
		for(int i =0; i<friendList.length; i++) {
			if(friendList[i] == null) {
				friendList[i] = friend;
				break;
			}
		}

//		System.out.println("이름>>" );
//		String name = scn.nextLine();
//		System.out.println("번호>>" );
//		String phoneNumber = scn.nextLine();
//		
//		Friend frnd = new Friend(name, phoneNumber);
//		friendList[idx++] = frnd; 

	}
	
//	@Override
//	public void addUniFriend(Friend unifriend) {
//		System.out.println("이름>>" );
//		String name = scn.nextLine();
//		System.out.println("번호>>" );
//		String phoneNumber = scn.nextLine();
//		System.out.println("학교명>>" );
//		String collage = scn.nextLine();
//		System.out.println("전공>>" );
//		String major = scn.nextLine();
//		
//		Friend unifrnd = new Friend(collage, major);
//		friendList[idx++] = unifrnd; 
//		
//	}
//
//	@Override
//	public void addCoFriend(Friend cofriend) {
//		System.out.println("이름>>" );
//		String name = scn.nextLine();
//		System.out.println("번호>>" );
//		String phoneNumber = scn.nextLine();
//		System.out.println("회사명>>" );
//		String company = scn.nextLine();
//		System.out.println("부서명>>" );
//		String department = scn.nextLine();
//		
//		Friend cofrnd = new Friend(company, department);
//		friendList[idx++] = cofrnd; 
//	}


	@Override
	public Friend[] friendList() {
//		Friend[] list = friendList();
//		System.out.println("친구조회기능");
//		System.out.println("조회할 친구 이름을 입력하세요>>");
//		// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용.
//		String name = scn.nextLine();
//		for(int i=0; i < list.length; i++) {
//			if(list[i].getName().equals(name)) {
//				System.out.println(list[i].getInfo());
//			}
//		}// 전체 친구목록을 반환하도록 수정하세요(반환유형에 유의).
		return friendList;
	}

	@Override
	public void modFriend(String name, String phoneNumber) {
		// 친구이름을 찾아서 연락처를 변경하도록 추가하세요.
//		String result = null;
//		for(int i=0; i<idx; i++) {
//			if(friendList[i].getName() == name) {
//				result = friendList[i].getName();
//				break;
//			}
//		}
		
		for(int i=0; i<friendList.length; i++) {
			if(friendList[i]!= null && friendList[i].getName().equals(name)) {
				friendList[i].setPhoneNumber(phoneNumber);
//				result = friendList[i].getName();
				break;
			}
		}
		
		
	}

	@Override
	public void delFriend(String phoneNumber) {
		// 삭제할 연락처를 입력받아서 배열에서 찾아 삭제하세요.
//		System.out.println("삭제할 친구의 연락처를 입력>> ");
//		String phoneNo = scn.nextLine();
//		String result = null;
//		for(int i=0; i<idx; i++) {
//			if(friendList[i].getPhoneNumber() == phoneNo) {
//				result = friendList[i].getName();
//				break;
//			}
//			result = null;
//		}
//		return;
		
		for(int i=0; i<friendList.length; i++) {
			if(friendList[i]!= null && friendList[i].getPhoneNumber().equals(phoneNumber)) {
				friendList[i]= null;
//				result = friendList[i].getName();
				break;
			}
		}
	
	}
}