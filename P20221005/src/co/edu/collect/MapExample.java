package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		//key: Integer, val: String 키값이 밸류값을 불러오기 때문에 키값은 중복X
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100,"홍길동");
		map.put(200,"김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식");
		
		map.remove(300); //삭제
		
		System.out.println("컬렉션: " + map.size());
		System.out.println("val: " + map.get(300));
		
		// 반복자 생성
		Set<Integer> keySet = map.keySet(); //키만 새로운 set컬렉션에 저장
		for(Integer key : keySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key)); // 밸류값을 가져오려면 map.get(key)로 가져와야함
		}
		
		Set<Entry<Integer, String>> entSet = map.entrySet(); //entry : 키와 밸류를 모두 담고있는 클래스 , 
		for(Entry<Integer, String> ent : entSet) {
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
		}
	}
}
