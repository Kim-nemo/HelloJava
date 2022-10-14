package co.edu.nested;

// 익명구현객체
// 추상메소드가 하나만 존재하는 인터페이스를 Functional 인터페이스 라고 한다.
interface MyInterface{
	void run();
}

interface MyInterface2{
	void run(String kind); 
}

interface MyInterface3{
	int sum(int num1, int num2);
}

public class AnonymousExample3 {
	public static void main(String[] args) {
		
		// 람다표현식 (목적: 기능 구현하는데 코드를 간단하게 만들고 싶을때 사용)
		MyInterface intf = () ->  System.out.println("MyInterface Run."); // run이라는 매개값을 받아서 어떤 구문을 실행하겠다
		intf.run();
		
		MyInterface2 intf2 = kind -> System.out.println(kind + " Run.");
		intf2.run("농구종목");
		
		MyInterface3 intf3 = (num1,num2) -> num1*2 + num2;
		int result = intf3.sum(10, 20);
		
		intf3 = (num1,num2) -> num1*2 + num2*3;
		result = intf3.sum(11, 22);
	}
}
