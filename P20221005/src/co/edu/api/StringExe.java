package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
		
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);
		
		String searchKey = "자 바";
		searchKey = searchKey.replace(" ",""); // 공백을 널로 바꿔줌
		
		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while(true) {
				String str = scn.nextLine();
				if(str == null)
					break;
				
//				if(str.indexOf(searchKey) != -1)
//				System.out.println(str);
				if(str.replace("-","").charAt(6)%2 == 1) {
					System.out.println("남자입니다");
				}else if(str.replace("-", "").charAt(6)%2 == 0){
					System.out.println("여자입니다");
				}else { // 년도, 월, 일 정보가 잘못되면 잘못된 번호로 인식하도록 조건 넣어보기
					System.out.println("잘못된 번호입니다");
				}
//				char sex = str.charAt(7);
//				switch(sex) {
//				case '1' :
//				case '3' :
//					System.out.println("남자입니다");
//					break;
//				case '2' :
//				case '4' :
//					System.out.println("여자입니다");
//					break;
//				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			
		}
		
		System.out.println("end of prog.");
	}
}
