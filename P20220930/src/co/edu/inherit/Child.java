package co.edu.inherit;

public class Child extends Parent{  //extends라는 키워드로 부모로부터 상속받을 수 있음
	String field1;
	Child(){
		super("args"); // 부모클래스의 생성자 호출
		System.out.println("Child() call.");
	}
	void method1() {
		System.out.println("method1() call.");
	}
	// 부모클래스의 메소드를 물려받아서 재정의. overriding
	@Override // 어노테이션: 부모클래스의 메소드(반환값, 메소드의이름, 매개값) 체크
	void method() { // 부모클래스에 정의되어진 메소드
		System.out.println("Child method() call."); // 자식이 재정의해서 다른 기능을 넣을 수도 있음
	}
	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
	
}
