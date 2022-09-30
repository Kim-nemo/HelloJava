package co.edu;

// 하나의 실행 클래스와 여러개의 라이브러리 클래스가 필요하다
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스 생성
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("탕수육");
		
		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("짬뽕");
		
//		System.out.println(kim);
		
		Student stud1 = new Student();
//		stud1.stuNum = 1234;
		stud1.setStuNum("1234");
//		stud1.name = "박기역";
		stud1.setName("박기역");
//		stud1.subject = "국어국문학과";
		stud1.setSubject("국어국문학과");
		
		stud1.study("카페");
		stud1.game("오버워치");
		stud1.sleep();
		
		Student stud2 = new Student();
//		stud2.stuNum = 2345;
		stud2.setStuNum("2345");
//		stud2.name = "뿡뿡";
		stud2.setName("뿡뿡");
//		stud2.subject = "경찰행정학과";
		stud2.setSubject("경찰행정학과");
		
		Student stud3 = new Student();
		
		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud : students) {
			System.out.println("학번: " + stud.getStuNum() + ", 학생이름: " + stud.getName());
		}
		
		//상속
		WorkMan wman = new WorkMan();
		wman.name = "";
		wman.age = 30;
		
		StudMan sman = new StudMan(); 
		sman.school = "고등학교"; // 본인이 가진 특성과 부모가 가진 특성 모두 사용가능
		sman.height = 164.3;
	}
}
