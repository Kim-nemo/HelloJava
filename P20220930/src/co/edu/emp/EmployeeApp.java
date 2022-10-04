package co.edu.emp;

import java.util.Scanner;

//메인클래스
public class EmployeeApp {
	public static void main(String[] args) {
		// 1. 사원수(초기화) 2. 사원정보입력 3. 사원검색 4. 사원리스트 9.종료
		Scanner scn = new Scanner(System.in);
		EmployeeService service = new EmployeeArray(); // 바꾸고 싶으면 new EmployeeArrayList();로 바꾸면 됨
		
		while(true) {
			System.out.println("1. 사원수(초기화) 2. 사원정보입력 3. 사원검색 4. 사원리스트 9.종료");
			System.out.print("선택>>> ");
			
			int menu = Integer.parseInt(scn.nextLine()); 
			// Integer.parseInt: static 메소드, 문자열을 숫자로 바꿔줌 "1" -> 1
			if(menu ==1) {
				service.init();
			}else if(menu ==2) {
				service.input();
			}else if(menu ==3) {
				System.out.print("검색할 사원번호를 입력>>> ");
				int eId = Integer.parseInt(scn.nextLine()); // "100" (-> 100) Enter
				String name = service.search(eId);
				System.out.println("사원의 이름은 " + name);
			}else if(menu ==4) {
				service.print();
			}else if(menu ==9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}//end of main()
}// end of class
