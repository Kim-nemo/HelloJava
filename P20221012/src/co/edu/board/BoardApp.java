package co.edu.board;

import java.util.Scanner;

//main
public class BoardApp {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		Board brd = null;
		
		
		while(true) {
			
			System.out.println("메뉴) 1.글 등록 2.글 수정 3.글 삭제 4.글 목록 5.상세조회 9.종료");
			System.out.print(">> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu ==1) {
				System.out.print("등록할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("등록할 글의 제목>> ");
				String title = scn.nextLine();
				System.out.print("등록할 글의 내용>> ");
				String content = scn.nextLine();
				System.out.print("등록할 글의 작성자>> ");
				String writer = scn.nextLine();
				System.out.print("등록할 글의 작성일시>> ");
				String date = scn.nextLine();
				System.out.print("등록할 글의 조회수>> ");
				String cnt = scn.nextLine();
				
				brd = new Board(num, title, content, writer, date, cnt);
				dao.insert(brd);
			}else if(menu==2) {
				System.out.print("수정할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("수정할 글의 내용>> ");
				String content = scn.nextLine();
				System.out.print("수정할 글의 작성일시>> ");
				String date = scn.nextLine();
				
//				brd2 = new Board(num, content, date);
//				dao.update(brd2);
			}else if(menu==3) {
				System.out.print("삭제할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
			}else if(menu==4) {
				// 글목록
			}else if(menu==5) {
				// 상세조회
				System.out.print("조회할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
			}else if(menu==9) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
