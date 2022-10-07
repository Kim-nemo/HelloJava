package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample3 {
	public static void main(String[] args) {
		// 1. 저장 2. 조회 3. 종료
		Map<String, Integer> students = new HashMap<>();
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu ==1) {
				System.out.print("학생이름입력>> ");
				String name = scn.nextLine();
				System.out.print("학생점수입력>> ");
				int score = scn.nextInt();
				//이름을 키 값, 점수를 밸류값
				
				students.put(name,score);
				
			}else if(menu==2) {
				System.out.print("조회할 학생이름입력>> ");
				String searchName = scn.nextLine(); //searchName이 키값
				//점수출력
				System.out.println("점수: " + students.get(searchName));
			}else if(menu==3) {
				System.out.println("프로그램 종료");
				break;
			}
		} // end of while
		System.out.println("프로그램이 종료되었습니다");
	}
}
