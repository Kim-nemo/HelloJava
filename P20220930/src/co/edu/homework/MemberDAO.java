package co.edu.homework;

import java.util.Scanner;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Member[] myMember = new Member[100];
	
	//1. 회원 등록
	public void addMember() {
		System.out.println("회원 등록 기능");
		System.out.print("회원 번호를 입력하세요>> ");
		int mNo = scn.nextInt();
		scn.nextLine();
		System.out.print("회원 이름을 입력하세요>> ");
		String memberName = scn.nextLine();
		System.out.print("회원의 생년월일을 입력하세요>> ");
		String birth = scn.nextLine();
		System.out.print("회원의 연락처를 입력하세요>> ");
		String tel = scn.nextLine();
		
		Member mem = new Member(mNo, memberName, birth, tel);
		for(int i=0; i < myMember.length; i++) {
			if(myMember[i] == null) {
				myMember[i] = mem;
				break;
			}
		}
	} // end of addMember
	
	//2. 회원정보 수정
	public void editMember() {
		System.out.println("회원정보 수정 기능");
		System.out.print("수정할 회원의 회원 번호를 입력하세요>> ");
		int mNo = scn.nextInt();
		scn.nextLine();
		
		for(int i=0; i< myMember.length; i++) {
			if(myMember[i] != null && myMember[i].getMemberNo() == mNo) {		
				myMember[i] = null;
				break;
			}
		}
		
		System.out.print("수정할 회원 이름을 입력하세요>> ");
		String memberName = scn.nextLine();
		System.out.print("수정할 회원의 생년월일을 입력하세요>> ");
		String birth = scn.nextLine();
		System.out.print("수정할 회원의 연락처를 입력하세요>> ");
		String tel = scn.nextLine();
		
		Member mem = new Member(mNo, memberName, birth, tel);
		for(int i=0; i < myMember.length; i++) {
			if(myMember[i] == null) {
				myMember[i] = mem;
				break;
			}
		}	
	}
	
	//3. 회원 리스트 조회
	public void memberList() {
		System.out.println("전체 회원 리스트 조회 기능");
		for(Member mem : myMember) {
			if(mem != null) {
				System.out.println(mem.toString());
			}
		}
	}
	
	//4. 회원 조회
	public void memberSearch() {
		System.out.println("회원 조회 기능");
		System.out.print("조회할 회원 번호를 입력하세요>> ");
		int mNo = scn.nextInt();
		scn.nextLine();
		boolean check = true;
		for(int i=0; i < myMember.length; i++) {
			if(myMember[i] != null && myMember[i].getMemberNo() == mNo) {
				System.out.println(myMember[i].toString());
				check = false;
			}
		}if(check) {
			System.out.println("존재하지 않는 회원입니다.");
		}
	}
	
	//5. 회원 정보 삭제
	public void memberDel() {
		System.out.println("회원 삭제 기능");
		System.out.print("삭제할 회원 번호를 입력하세요>> ");
		int mNo = scn.nextInt();
		scn.nextLine();
		for(int i=0; i < myMember.length; i++) {
			if(myMember[i] != null && myMember[i].getMemberNo() == mNo) {
				myMember[i] = null;
				System.out.println("삭제가 완료되었습니다");
			}
		}
	}
	
	//6. 전체 메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.회원 등록, 2.회원정보 수정, 3.전체 회원리스트 조회, 4.회원 조회, 5.회원정보 삭제, 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: addMember(); break;
			case 2: editMember(); break;
			case 3: memberList(); break;
			case 4: memberSearch(); break;
			case 5: memberDel(); break;
			case 9: run = false; break;
			default: System.out.println("잘못된 메뉴입니다.");
			}
		}
		System.out.println("프로그램 종료");
	}
	
}// end of class
