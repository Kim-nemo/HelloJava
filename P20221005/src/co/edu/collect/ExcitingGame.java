package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("단어를 입력하세요");
		
		
		long gameStart = System.currentTimeMillis();
		String target = "As pressure on our water supplies";
		String[] targetAry = target.split(" ");
		ArrayList list = new ArrayList();
		for(int i=0; i<targetAry.length; i++) {
			list.add(targetAry[i]);
		}
		System.out.println(target);
		
		while(true) {
			System.out.print("\n>> ");
			String inputVal = scn.nextLine();
			if(list.size()==0) {
				break;
			}
		
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals(inputVal)) {
				list.remove(i);
				}
			}
			for(int i=0;i<list.size();i++) {
				System.out.printf("%s ", list.get(i));
			}
		}
		
		long gameEnd = System.currentTimeMillis();
		
		long during = (gameEnd - gameStart); // 1*60*1000+30*1000=63000/60000분, 63000%6000초 
		long min = during/60000;
		long sec = during%60000/1000;
		System.out.println("걸린시간은 : " + min +"분" +sec + "초가 걸렸습니다");
		
		
	}
}
