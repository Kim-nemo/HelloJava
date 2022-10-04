package co.edu.inherit;

public class MainApp {
	public static void main(String[] args) {
		Child child = new Child(); // field1, mthod1()
		child.method(); // Parent의 메소드.
		child.method1(); // Child의 메소드. 자식클래스는 부모가 가진 메소드 사용가능
		
		Child2 child2 = new Child2();
		child2.method(); // Parent 메소드를 child2가 상속받아야 오류 안 생김.
		child2.method2(); // child2의 메소드.
		
		Parent c1 = new Parent(); //
		c1 = new Child(); // 부모클래스의 변수에 자식인스턴스 대입 가능.
		c1 = new Child2(); // 자동형변환(자식인스턴스 -> 부모인스턴스)
		
//		c1.method2(); // 부모클래스의 멤버들만 호출가능.
		
		if(c1 instanceof Child2) { 
			Child2 c2 = (Child2) c1; // 강제형변환(casting)
			c2.method2();
		}
		
		Parent c3 = new Parent(); //
		if(c3 instanceof Child2) { // 조건문을 넣어서 인스턴스가 맞는지 체크하고 써야 오류가 안 남
			Child2 c4 = (Child2) c3; // casting // 가능하긴 한데 이렇게 쓰면 안된다고 오류남
			c4.method2();
		}
	}
}
