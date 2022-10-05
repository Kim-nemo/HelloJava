package co.edu.api;

class Student{
	String name;
	int age;
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj); // super: 부모클래스
	}
}
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj.equals(obj2)); // obj == obj2 의 각각의 값이 아닌 주솟값 비교
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2));
	}
}
