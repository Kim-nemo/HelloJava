package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
		Student.staticMethod(); // 인스턴스 따로 안 만들어도 사용할 수 있음. 클래스이름.메소드이름();
		
		Math.random();// 정적 메소드
		Math.round(.5); // 반올림 해주는 정적 메소드
		
		Student s1 = new Student();
//		s1.staticMethod(); // error 아닌데 warning.
		
		s1.setStuNum("111-111");
		s1.setName("홍길동");
		s1.setSubject("컴퓨터공학과");
		s1.setAge(20);
		
		System.out.println(s1.getStuNum()); // String = null, 초기값 출력
		System.out.println(s1.getAge()); // int = 0;
		System.out.println(s1.showInfo()); // showInfo는 String 타입으로 반환해주는 메소드
		
		System.out.println("여기=>>> "+ s1);
		
		Student s2 = new Student();
		
		s2.setStuNum("222-222");
		s2.setName("김민숙");
		s2.setSubject("역사학과");
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());
		
		String[] hob2 = {"영화감상", "킥보드"};
		s2.setHobbies(hob2);
		s2.addHobby("드럼치기");
		System.out.println(s2.getHobb());
		
		Student s3 = new Student();
		System.out.println(s3.getName());
		
		Student s4 = new Student("111-234", "주소영", "경제학부");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("222-223", "송지은", "역사학과");
		System.out.println(s5.showInfo());
		
		
	}
}
