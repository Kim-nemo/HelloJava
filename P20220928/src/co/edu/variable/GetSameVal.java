package co.edu.variable;

import java.util.Scanner; // java밑에 있는 util밑에 있는 Scanner를 가져와 클래스로 쓰겠다
import java.lang.System;

// java.lang 이 베이스 패키지

public class GetSameVal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //Scanner라고 하는 클래스는 사용자 입력값을 저장해줌
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine(); // 사용자가 입력한 값을 읽어들이고 그 값을 반환하겠다
		
		String[] names = {"김현지", "김유리", "남미주", "송지은"}; // 배열값을 담을때 중괄호 사용
		
		int check=0; // boolean isChecked = false;
		for(int i=0; i<names.length; i++) {
			if(names[i].equals(name)) { // 문자열비교는 문자열.equals(비교문자열)
				System.out.println((i+1) + "번째 자리에 있습니다");
				check=1; // isChecked = true;
				break;
			}
		}						// !는 not의 의미
			if(check == 0) { //(check == 0)대신에 (!isChecked)로 바꿔서 boolean 사용해서 할 수 있다
			System.out.println("찾는 이름이 없습니다");
			}
		System.out.println("입력값: "+ name);
		scn.close();
	}
}
