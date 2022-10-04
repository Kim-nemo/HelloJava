package co.edu.inherit;

public class Parent{ // 모든 클래스는 Object라고 하는 제일 상위에 존재하는 클래스의 상속을 받는다
	String field;
	Parent(){ // 매개값이 없는 기본 생성자
		System.out.println("Parent() call.");
	}
	Parent(String args){ // 매개값을 하나 받는 생성자
		System.out.println("Parent(String args) call.");
	}
	void method() {
		System.out.println("parent method() call.");
	}
	
	@Override
	public String toString() { // toString이라는 메소드를 쓸 수 있는 이유는 이 메소드가 Object라는 최상위클래스에 이미 있기 때문
		return "Parent [field=" + field + "]";
	}
	
}
