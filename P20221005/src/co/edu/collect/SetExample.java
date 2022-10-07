package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;
	
	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	//동일한 객체: id만 같으면 같다고 비교하겠다
	@Override
	public int hashCode() {
		return empId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) { // obj가 Employee의 인스턴스가 맞으면
			Employee target = (Employee) obj; // 강제형변환(casting)
			return (this.empId == target.empId &&
					this.name.equals(target.name) && 
					this.salary == target.salary);
			//target이 가진 값이랑 employee가 가진 값이랑 비교하겠다
		}else {
			return false;
		}
	}
}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(new Employee(100,"홍길동",1000));
		employees.add(new Employee(200,"박유식",2000));
		employees.add(new Employee(300,"최윤기",3000));
		employees.add(new Employee(100,"김길동",4000));
		
		//한건 제거
		employees.remove(new Employee(100,"김길동",4000));
		
		System.out.println(employees.size());
		
		Iterator<Employee> iter = employees.iterator(); //반복자 리턴
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId,emp.name,emp.salary);
		}
		
		Set<Integer> set = new HashSet<Integer>(); 
		
		// 중복값 허용X
		while(set.size() < 7) {  //size가 7개가 될 때까지 반복
			set.add((int)(Math.random()*45)+1);
		}
		for(int n : set) {
			System.out.println(n);
		}
		
		// 중복저장 불가
//		int[] lotto = new int[7];
//		for(int i=0; i<lotto.length; i++) {
//			int temp = (int)(Math.random() * 7) + 1;
//			// 현재 인덱스 값보다 적은 위치에 temp와 같은 값이 있는지 체크
//			boolean exists =false;
//			for(int j = 0; j < i; j++) {
//				//같은 값이 있으면..
//				if(temp==lotto[j])
//				exists = true;
//			}
//			//continue;
//			if(exists) {
//				--i;
//				continue;}
//			lotto[i] = temp;
//		}
//		for(int n : lotto) {
//			System.out.printf("%d ", n);
//		}
	}
}
