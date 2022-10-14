package co.dev;

import java.util.ArrayList;

public class StudExample {
	public static void main(String[] args) {
		Student stud = new Student(101, "홍길동", 80); // new 키워드: 인스턴스를 만들어서 stud 라는 변수에 담는것
		String name1 = stud.getStudName();
		int score1 = stud.getScore();
		
		ArrayList<Student> studList = new ArrayList<>(); // 값을 담을 변수 인스턴스 만들어주기
		studList.add(stud);
		studList.add(new Student(102, "김현수", 88));
		studList.add(0, new Student(103, "박문수", 78)); // 0번째 위치에 문수 넣음, 나머지는 한칸씩 밀려남
		
		Student hong = new Student(201, "홍수환", 90);
		
		for(int i=0; i<studList.size(); i++) {
			if(studList.get(i).getStudName().equals("김현수")) {
				studList.add(i,hong); // 홍수환을 김현수자리에 넣고싶다
				break;
			}
		}
		
		// 출력
		for(int i=0; i<studList.size(); i++) {
			System.out.println(studList.get(i).getStudName());
		}
		
		// 학생번호 기준으로 정렬
		ArrayList<Student> sortAry = new ArrayList<Student>(); // 정렬한 배열을 담을 변수 만들기
		
//		for(int i=0; i<studList.size(); i++) {
//			for(int j=0; j<i; j++) {
//				sortAry.add(j, studList.get(i));
//			}
//		}
	}
}
