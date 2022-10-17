package co.edu.board;

import java.util.List;
import java.util.Scanner;

//main
public class BoardApp {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		Board brd = null;
		Reply rpl = null;
		
		boolean check = false;
		while(!check) {
			System.out.println("<로그인>\n");
			System.out.print("아이디 입력>> ");
			String id = scn.nextLine();
			System.out.print("비밀번호 입력>> ");
			String pw = scn.nextLine();
		
			if(dao.login(id, pw)== 1) {
				System.out.println("로그인성공");
				check = true;
			}else {
				System.out.println("로그인실패");
				continue;
			}
		
		
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
//				System.out.print("등록할 글의 작성자>> ");
//				String writer = scn.nextLine();
				String writer = id;
				
				brd = new Board(num, title, content, writer);
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
				
				brd = new Board(num, content);
				
				if(dao.getNum(num).getWriter().equals(id)) {
					dao.update(brd);
					System.out.println("수정완료");
				}else {
					System.out.println("수정할 권한이 없습니다");
				}
				
				
			}else if(menu==3) {
				System.out.print("삭제할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				if(dao.getNum(num).getWriter().equals(id)) {
					dao.delete(num);
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
			}else if(menu==4) {
				// 글목록
				System.out.println("전체 목록 조회");
				List<Board> list = dao.search();
				for(Board i : list) {
					System.out.println(i.getString());
				}
			}else if(menu==5) {
				// 상세조회
				System.out.print("조회할 글의 번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				Board i = dao.getNum(num);
				
				if( i != null) {
					System.out.println(i);
					
					List<Reply> list = dao.getR(num);
					for(Reply r : list) {
						System.out.println(r.toString());
					}
	//				if( list!= null) {
	//					System.out.println(list);
	//					continue;
	//				}
					
					System.out.println("댓글 작성하시겠습니까?");
					System.out.print("1.예 2.아니오 >> ");
					int submenu = Integer.parseInt(scn.nextLine());
					if(submenu == 1) {
						int reBNum = num;
						String reWriter = id;
						System.out.print("댓글내용 입력>> ");
						String reContent = scn.nextLine();
						
						rpl = new Reply(reBNum, reContent, reWriter);
						dao.insert(rpl);
					}
				}else {
					System.out.println("글이 존재하지 않습니다");
				}
				

			}else if(menu==9) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		scn.close();
		System.out.println("종료");
	}
	
	}
}
