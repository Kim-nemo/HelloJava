package co.edu.swim;

import java.util.List;
import java.util.Scanner;


public class SwimApp {
	public static void main(String[] args) {
		SwimDAO dao = new SwimDAO();
		Scanner scn = new Scanner(System.in);
		Swim swm = null;
		SwimClass swmc = null;
		
		boolean check = false;
		while(!check) {
			System.out.println("<로그인>\n");
			System.out.print("아이디 입력>> ");
			String id = scn.nextLine();
			System.out.print("비밀번호 입력>> ");
			String pw = scn.nextLine();
		
			if(dao.login(id, pw)== 1) {
				System.out.println("관리자 로그인성공");
				check = true;
			}else if(dao.login(id, pw)== 2) {
				System.out.println("회원 로그인성공");
				check = true;
			}else {
				System.out.println("로그인실패");
				continue;
			}//로그인
			
		while(true) {
			System.out.println("※메뉴※ 1.회원등록 2.회원리스트 조회 3.회원 조회 4.회원정보수정 5.회원탈퇴 6.수강조회 9.종료 ");
			System.out.print(">> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu ==1) {
				System.out.println("< 회원등록 >");
				System.out.print("ID 입력>> ");
				String sId = scn.nextLine();
				System.out.print("비밀번호 입력>> ");
				String sPw = scn.nextLine();
				System.out.print("회원번호 입력>> ");
				int sNo = Integer.parseInt(scn.nextLine());
				System.out.print("회원이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("성별 입력(W/M)>> ");
				String sex = scn.nextLine();
				System.out.print("생년월일 입력>> ");
				String birth = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String phoneNo = scn.nextLine();
				System.out.print("신청 레벨 입력(3,2,1)>> ");
				int level = Integer.parseInt(scn.nextLine());
				
				swm = new Swim(sId, sPw, sNo, name, sex, birth, phoneNo, level);
				dao.insert(swm);
			}else if(menu ==2) {
				if(dao.login(id, pw)== 1) {
				System.out.println("< 전체 회원리스트 조회(관리자 전용) >");
				List<Swim> list = dao.search();
				for(Swim i : list) {
					if(i!=null) {
					System.out.println(i.toString());
					}else {
						System.out.println("조회할 회원이 없습니다");
					}
				}
				}else {
					System.out.println("리스트 조회 메뉴 사용 권한이 없습니다");
				}
			}else if(menu ==3) {
				System.out.println("< 회원 상세조회(회원본인과 관리자만 가능) >");
				
				System.out.print("조회할 회원번호 입력>> ");
				int mNum = Integer.parseInt(scn.nextLine());
				Swim swims = dao.getsNo(mNum);
				String swim = dao.getsNo(mNum).getsId();
				if(dao.login(id, pw)==1) { //관리자 접근 가능
					if(swims != null) {
							System.out.println(swims.getString());
					}else {
						System.out.println("조회할 회원이 없습니다");
					}
				}else if(id.equals(swim)){ // 본인정보만보기
					System.out.println(swims.getString());
				}else {
					System.out.println("상세 조회 사용 권한이 없습니다");
				}
			}else if(menu ==4) {
				System.out.println("< 회원정보 수정(회원본인과 관리자만 가능) >");
				System.out.print("수정할 회원의 회원번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				String mNum = dao.getsNo(num).getsId();
				if(dao.login(id, pw)==1) {
					System.out.println("~수정할 정보를 입력하세요~");
					System.out.print("회원이름 입력>> ");
					String name = scn.nextLine();
					System.out.print("성별 입력(W/M)>> ");
					String sex = scn.nextLine();
					System.out.print("연락처 입력>> ");
					String phoneNo = scn.nextLine();
					System.out.print("생년월일 입력>> ");
					String birth = scn.nextLine();
					System.out.print("신청 레벨 입력(3,2,1)>> ");
					int level = Integer.parseInt(scn.nextLine());
					
					swm = new Swim(num, name, sex, phoneNo, birth, level);
					if(num == dao.getsNo(num).getsNo()) { // 위에서 입력받은 값과 원래 회원번호가 일치하면
						dao.update(swm);
						System.out.println("수정완료");
					}else {
						System.out.println("회원번호가 일치하지 않아 수정이 불가능합니다");
					}
				}else if(id.equals(mNum)) {
					System.out.println("~수정할 정보를 입력하세요~");
					System.out.print("회원이름 입력>> ");
					String name = scn.nextLine();
					System.out.print("성별 입력(W/M)>> ");
					String sex = scn.nextLine();
					System.out.print("연락처 입력>> ");
					String phoneNo = scn.nextLine();
					System.out.print("생년월일 입력>> ");
					String birth = scn.nextLine();
					System.out.print("신청 레벨 입력(3,2,1)>> ");
					int level = Integer.parseInt(scn.nextLine());
					
					swm = new Swim(num, name, sex, phoneNo, birth, level);
					dao.update(swm);
					System.out.println("수정완료");
				}else {
					System.out.println("수정 권한이 없어 수정이 불가능합니다");
				}
			}else if(menu ==5) {
				System.out.println("< 회원 탈퇴 >");
				System.out.print("삭제할 회원의 회원번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				dao.delete(num);
			}else if(menu ==6) { // 수강조회
				System.out.println("< 수강 조회 >");
				System.out.print("레벨을 입력하면 강의 정보를 보여드립니다>> ");
				int level = Integer.parseInt(scn.nextLine());
				
//				System.out.println(.toString());
				
			}else if(menu ==9) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		scn.close();
		System.out.println("종료");
		
		}
	}
}	
