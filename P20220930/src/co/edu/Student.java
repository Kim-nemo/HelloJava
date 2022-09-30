package co.edu;

public class Student {
	// 필드
	private String stuNum;
	private String name;
	private String subject;
	private int age; // 정수값 23, 0, -12
	private String[] hobbies = new String[5];
	
	// 정적메소드
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}
	
	// 생성자(필드의 값을 초기화) 생성자의 오버로딩(동일한 이름으로 생성자를 여러번 정의하는 것)
	public Student() {
		// 매개값이 없는 생성자 => 기본 생성자
		// 기본 생성자가 없으면 오류. 기본 생성자를 정의해줘야함
		this.name = "기본값";
		this.stuNum = "000-000";
	}
	public Student(String stuNum, String name) {
		this.stuNum = stuNum;
		this.name = name;
	}
	public Student(String stuNum, String name, String subject) {
		this(stuNum, name); // 기본생성자
		this.subject = subject;
	}
	// 메소드 (+ 메소드는 반드시 반환타입이 있어야 한다)
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for(String hobby : hobbies) { // hobbies에서 차례대로 객체를 꺼내서 hobby에 담겠다는 의미
			for(int i=0; i<this.hobbies.length; i++) {
				if(this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String[] getHobbies() {
		return this.hobbies;
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby : hobbies) {
			if(hobby != null) {
			str += hobby + " ";
			}
		}
		str += "입니다.";
		return str;
	}
	// 취미 추가
	void addHobby(String hobby) {
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}
	
	void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	String getStuNum() {
		return this.stuNum;
	}
	
	// 학생 이름 set, get
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return this.name;
	}
	
	//전공 set, get
	void setSubject(String subject) {
		this.subject = subject;
	}
	String getSubject() {
		return this.subject;
	}
	
	void setAge(int age) {
		if(age < 0) {
			this.age = 0; // 필드 age를 나타내기 위해 this. 붙임. 위에 매개변수 age(파란색이 아닌)와 구분하기 위함
		}else {
			this.age = age;
		}
	}
	int getAge() { // 값을 불러오고 싶어서 getAge 사용
		return this.age;
	}
	// showInfo()
	public String showInfo() {
		return "이름은 " + this.name + "이고, 학번은 " + this.stuNum +"입니다."
				+ "전공은 " + this.subject +"입니다.";
	}
	
	void study(String place) {
		System.out.println(name + "은 "+place+"에서 공부한다");
	}
	void game(String gname) {
		System.out.println(name + "은 "+gname+"라는 게임을 좋아한다");
	}
	void sleep() {
		System.out.println(name + "은 잠을 잔다");
	}
}
