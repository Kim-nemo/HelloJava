package co.edu.complex;

import java.util.Scanner;

public class ObjectExe {
	
	public static void main(String[] args) {
		
		String s1 = "홍길동";
		int i1 = 20;
		double d1 = 162.3; // 162.0 (promotion: 자동형변환)
		
		Person p1 = new Person(); // 인스턴스 생성, p1이라는 비어있는 공간 만들기
		p1.name = "김짭짭";
		p1.age = 22;
		p1.height = 172.3;
		
		
		Person p2 = new Person();
		p2.name = "김냠냠";
		p2.age = 23;
		p2.height = 163.2;
		
		Person p3 = new Person();
		p3.name = "김큼큼";
		p3.age = 23;
		p3.height = 163.2;
		
		System.out.println("이름: "+p1.name);
		System.out.println("나이: "+p1.age);
		System.out.println("키: "+p1.height);
		
		Person[] persons = {p1,p2,p3};
		System.out.println("이름: "+persons[1].name);
		System.out.println("나이: "+persons[1].age);
		System.out.println("키: "+persons[1].height);
		
//		persons[2].name = "송지은";
//		p3.name = "송지은";
		
		// 김냠냠 이름을 찾아서 나이 23=>22 변경
		//반복 for ==(O,X) => equals
		
		/*
		String kim = "김냠냠"; //문자열 리터럴(고정된 값을 코드안에 입력하는 것을 리터럴이라고 함)
		for(int i=0; i<persons.length;i++) {
			if(persons[i].name.equals(kim)) {
				persons[i].age = 22;
			}
		}
		*/
		
		
		Scanner scn = new Scanner(System.in);
		System.out.println("나이를 변경하고자 하는 사람의 이름>>> ");
		String name = scn.nextLine();
		System.out.println("변경할 나이>>> ");
		int age = scn.nextInt();
		for(int i=0; i<persons.length;i++) {
			if(persons[i].name.equals(name)) {
				persons[i].age = age;
			}
		}
		
		
		// p1변수값과 persons[0]값을 비교.
		System.out.println(persons[0] == p1);
		
		// 전체목록을 출력.
		for(int i=0; i < persons.length; i++) {
			System.out.println(i+1+"번째 이름: "+persons[i].name + ", 나이: "+ persons[i].age);
		}
		/*
		//다릅니다
		String n1 = new String("홍길동");
		String n2 = new String("홍길동");
		//같습니다
		String m1 = "홍길동";
		String m2 = "홍길동";
		
		System.out.println(m1 == m2);
		*/
	}
	
}
