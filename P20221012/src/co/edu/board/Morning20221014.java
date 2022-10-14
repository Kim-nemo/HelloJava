package co.edu.board;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Morning20221014 {
	
	public static void main(String[] args) {	
		File file = new File("C:/Temp/memberList.txt");
		List<Member> memberStorage = new ArrayList<>();
		String x = null;
		Scanner scn = new Scanner(System.in);
		
		while(true) {
		System.out.println("회원아이디 또는 quit>> ");
		String mId = scn.nextLine();
		
		if (mId.equals("quit")) {
			break;
		}
		
		System.out.println("회원이름>> ");
		String mName = scn.nextLine();
		System.out.println("회원포인트>> ");
		int mPoint = Integer.parseInt(scn.nextLine());
		
		memberStorage.add(new Member(mId, mName, mPoint));
		}
	// 회원추가	
		
		try(FileWriter fw = new FileWriter(file)){
			for(int i=0; i<memberStorage.size();i++) {
				x = memberStorage.get(i).toString();
				fw.write(x);
			}			
		}catch(Exception e){
			e.printStackTrace();
		} // 파일저장
		scn.close();
		System.out.println("completed!");
	}
}
