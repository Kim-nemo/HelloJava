package co.edu.api;

import java.util.ArrayList;
import java.util.List;
	// <T> 클래스가 만들어질때말고 사용되어질때 형식을 정하겠습니다
class Box<T>{ // 어떤 내용물을 담기위한 클래스, 어떤 형식이라도 다 받을 수 있음 
	T obj;
	void set(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}

class Member {
	private String name;
	private String id;
	private int point;
	
	public Member(String name, String id, int point) { // 생성자 만들기
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}

class Employee {
	private String empName;
	private String empId;
	private int salary;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

public class StringExe3 {
	public static void main(String[] args) {
		
		Box<String> box = new Box<String>();
		box.set("Hello");
//		box.set(200); error.
		String result = box.get();
		System.out.println(result);
		
		String[] stAry; //문자열을 담을 수 있는 배열
		List<String> list = new ArrayList<String>(); //컬렉션
		list.add("Hello");
		
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", "hong", 10000));
		members.add(new Member("김민기", "kim", 20000));
		members.add(new Member("박인기", "park", 30000));
		
		List<Employee> employees = changeType(members); //Member 클래스의 각각의 값들을 Employee라는 클래스의 값들로 바꿔서 인스턴스로 리턴
		for(Employee emp : employees) {
			System.out.println("name: " + emp.getEmpName() + " id: " + emp.getEmpId()
								+" salary: " +emp.getSalary());
		}
	}
	
	public static List<Employee> changeType(List<Member> collect){
		// Member 값 3 -> Employee 3
		List<Employee> empls = new ArrayList<Employee>();
		for(Member member : collect) {
			Employee emp = new Employee();
			emp.setEmpId(member.getId());
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());
			
			empls.add(emp);
		}
		return empls;
	}
}
