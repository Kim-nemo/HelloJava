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
				System.out.println("[관리자] 로그인 성공");
				check = true;
			}else if(dao.login(id, pw)== 2) {
				System.out.println("[회원] 로그인 성공");
				check = true;
			}else {
				System.out.println("로그인 실패");
				continue;
			}//로그인
			
		while(true) {
			System.out.println("=======================================================================");
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
				System.out.println("< 전체 회원리스트 조회 >");
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
				System.out.println("< 회원 상세조회 >");
				
				System.out.print("조회할 회원번호 입력>> ");
				int mNum = Integer.parseInt(scn.nextLine());
				Swim swimNum = dao.getsNo(mNum);
				if(swimNum != null) {
					String swimId = swimNum.getsId();
					if(dao.login(id, pw)==1) { //관리자 접근 가능
						if(swimId != null) {
								System.out.println(swimNum.getString());
						}else {
							System.out.println("조회할 회원이 없습니다");
						}
					}else if(id.equals(swimId)){ // 본인정보만보기
						System.out.println(swimNum.getString());
					}else {
						System.out.println("상세 조회 사용 권한이 없습니다");
					}
				}else {
					System.out.println("입력하신 번호의 회원이 존재하지 않습니다");
				}
			}else if(menu ==4) {
				System.out.println("< 회원정보 수정 >");
				System.out.print("수정할 회원의 회원번호>> ");
				int num = Integer.parseInt(scn.nextLine());
				if(dao.getsNo(num) != null) {
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
				}else {
					System.out.println("입력하신 번호의 회원이 존재하지 않습니다");
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
				dao.getcLv(level);
				if(dao.getcLv(level)!=null) {
					System.out.println("\n"+"<신청레벨과 강의정보를 확인하시고 신청레벨 수정을 원하신다면 4번 메뉴에서 수정하셔야 합니다>"+"\n");
					System.out.println(dao.getcLv(level)); // 입력한 레벨에 담긴 수강정보 보여줌
					
					if(dao.login(id, pw) != 1) {
						int lv = dao.getsId(id).getLevel(); // 현재 로그인한 아이디의 레벨값을 가져고오고싶음
						if(lv != 0) { // 출력할 내용. 로그인한 아이디의 신청 레벨값을 보고싶다. 널이 아니라면
							System.out.println("[신청하신 레벨: " + lv + "급]");
						}else {
							System.out.println("아직 레벨을 입력하지 않았습니다. 회원등록에서 신청해주세요.");
						}
					}
				}else {
					System.out.println("레벨 조회는 1,2,3급만 가능합니다");
				}
				
			}else if(menu ==9) {
				System.out.println("=======================================================================");
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		scn.close();
		System.out.println("종료");
		
		}
	}
}	
