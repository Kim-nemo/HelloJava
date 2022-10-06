package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
		System.out.println("abcDEF".toLowerCase());
		while(true) {
//			System.out.print("알파벳>> ");
			try {
				int bytes = System.in.read(); // system.in = 키보드로 입력한다는 뜻
				if(bytes == 122) // z값이 122
					break;
				
				System.out.println("입력값: " + bytes);
			}catch (IOException e) {
				e.printStackTrace();
		}
	}
		System.out.println("끝");
}
	public static void changeCapital(String msg) {
		// 대문자 -> 소문자, 소문자 ->대문자
		// aBcD => AbCd 97:65, 98:66	<-두개 값의 차가 32라서 더하면 대문자, 빼면 소문자로 변환	122
		// 소문자: 97~122, 대문자: 65~90
	}
}
