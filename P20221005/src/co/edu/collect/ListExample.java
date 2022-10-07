package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		//추가
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		//삭제
		strs.remove(0);
		strs.remove("박유식");
		//특정위치에 추가
		strs.add(0, "최기분"); //첫번째에 추가하면 원래 첫번째에 있던값이 미뤄짐
		
		System.out.println("collect크기: " + strs.size());
		
		for(String str : strs) {
			System.out.println(str);
		}
		for(int i=0; i<strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n", i, strs.get(i)); //정수는d, 문자열은s
		}
		//반복자를 생성
		Iterator<String> itr = strs.iterator();
		while(itr.hasNext()) { //가져올 값이 있습니까? true면 반복
			String result = itr.next();
			System.out.println(result);
		}
		
		// 100 만건
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime(); // 현재시점을 나노타임분으로보여줌
		for(int i=0; i<1000000; i++) {
//			inAry.add(0,1); 처음부터(add(0,1)) 넣을 땐 ary가 빠르고 
			inAry.add(i);
		}
		long end = System.nanoTime();
		System.out.println("ary: " + (end - start));
		
		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		start = System.nanoTime(); // 현재시점을 나노타임분으로보여줌
		for(int i=0; i<1000000; i++) {
//			lnAry.add(0,1);	끝(add(i))에서부터 넣을땐 lna가 빠르다
			lnAry.add(i);
		}
		end = System.nanoTime();
		System.out.println("lna: " + (end - start));
	}
}
