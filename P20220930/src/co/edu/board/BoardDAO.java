package co.edu.board;

import java.util.Scanner;

// 기능만.
public class BoardDAO {
	// Singleton 방식 : 메모리 절약을 위해 인스턴스를 하나만 만들겠습니다
	private static BoardDAO instance = new BoardDAO(); // 필드 : 정보를 담을 용도로 클래스에 만듬
	private BoardDAO() {} // 메소드
	public static BoardDAO getInstance() { // 여러개를 만들지 않고 하나만 만들겠다 => static 쓰는 이유
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];

	// 1. 글 등록
	public void addBoard() {
		System.out.println("글 등록 기능.");
		System.out.print("글 번호를 입력하세요>> ");
		int bNo= scn.nextInt();
		scn.nextLine();
		System.out.print("글 제목을 입력하세요>> ");
		String title = scn.nextLine();
		System.out.print("글 내용을 입력하세요>> ");
		String content = scn.nextLine();
		
		Board brd = new Board(bNo, title, content);
		// 배열등록
		for(int i=0; i < myBoards.length; i++) {
			if(myBoards[i] == null) {
				myBoards[i] = brd;
				break;
			}
		}
		
	}
	
	// 2. 글 목록
	public void boardList() {
		System.out.println("글 목록 기능.");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
	}
	
	// 3. 글 상세보기
	public void boardDetail() {
		System.out.println("글 상세보기 기능.");
		System.out.println("글 번호를 입력하세요>> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		boolean check = true;
		for(int i=0; i < myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo()==(bNo)) {
				System.out.println(myBoards[i].toString());
				check = false;
				break;
			}				
		}if(check) {
			System.out.println("글이 존재하지 않습니다");
		}
	}
	
	// 4. 글 삭제
	public void delBoard() {
		System.out.println("글 삭제 기능.");
		System.out.println("삭제할 글 번호를 입력하세요>> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		for(int i=0; i< myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo()==(bNo)) {
				myBoards[i] = null;
				System.out.println("삭제가 완료되었습니다");
			}
		}
	}
	
	// 5. 전체 메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.글 등록, 2.글 목록보기, 3.글 상세보기, 4.글 삭제, 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: addBoard(); break;
			case 2: boardList(); break;
			case 3: boardDetail(); break;
			case 4: delBoard(); break;
			case 9: run = false; break;
			default: System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while
		System.out.println("프로그램 종료.");
	} // end of exe()
}
