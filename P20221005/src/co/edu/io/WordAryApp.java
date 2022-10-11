package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		// 임의의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고 아니면 남아있게 하는 기능
		ArrayList<String> words = randomWords(10);
//		System.out.println(words.size());
		for(String word : words) {
			System.out.println(word);
		}
		while(true) {
			System.out.print("\n>> ");
			String inputVal = scn.nextLine();
			if(words.isEmpty()) {
				System.out.println("모든 문장 입력 완료!");
				break;
			}
			for(int i=0; i<words.size(); i++) {
				if(words.get(i).equals(inputVal)) {
					words.remove(i);
				}
			}
			for(int i=0; i<words.size();i++) {
				System.out.printf("%s \n", words.get(i));
			}
		}
		System.out.println("프로그램이 종료되었습니다");
	}
	
	public static ArrayList<String> randomWords(int times) throws Exception{
		// ArrayList<String>에 전체 문장을 담고
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt";
		File file = new File(path);
		Scanner scn = new Scanner(file); // 하나하나 읽어오기 위해 scanner사용
		while(scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim();
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}
		
		// 임의의 갯수 times 갯수만큼 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>();
//		while(randomWords.size()<times) {
//			randomWords.add(words.get((int)(Math.random()*494)));
//		}
		
		// 중복된 값을 제거하기 위해서 Set 컬렉션을 사용하여 저장
		Set<Integer> idxSet = new HashSet<>();
		while(idxSet.size() < times) {
			idxSet.add((int)(Math.random()*words.size()));
		}
		for(int idx : idxSet) {
			randomWords.add(words.get(idx));
		}
		scn.close();
		return randomWords;
	}
}
