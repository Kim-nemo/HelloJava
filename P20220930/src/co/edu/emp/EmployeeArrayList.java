package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션(ArrayList)을 활용해서 데이터를 저장.
public class EmployeeArrayList implements EmployeeService {
	// 저장공간 생성
		ArrayList<Employee> list;
		int idx;
		Scanner scn = new Scanner(System.in);
		
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료");		
	}

	@Override
	public void input() {
		
		
	int eId = -1; // 의미없는 값 넣어서 선언하기
	while(true) {
		try {
			System.out.println("사번>> ");
			eId = Integer.parseInt(scn.nextLine());
			break;
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
	}
		System.out.println("이름>>" );
		String name = scn.nextLine();
		
		
	int deptId = -1;
	while(true) {	
		try{
			System.out.println("부서>>" );
			deptId = Integer.parseInt(scn.nextLine());
			break;
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
	}
		
	int sal = -1;
	while(true) {
		try{
			System.out.println("급여>> ");
			sal = Integer.parseInt(scn.nextLine());
			break;
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
	}
		System.out.println("이메일>>" );
		String email = scn.nextLine();
		
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId){
				result = list.get(i).getName();
				break;
			}
		}
//		for(Employee emp : list) {
//			if(emp.getEmployeeId() == employeeId) {
//				result = emp.getName();
//				break;
//			}
//		}
		return result;
	}

	@Override
	public void print() {
			System.out.printf("%5s %10s %7s\n", // d를 s로 변경
					"사원번호",
					"이름   ",
					"급여   ");
			System.out.println("===============================");
			for (int i=0; i<list.size();i++) {
			System.out.printf("%5d %10s %7d\n",
					list.get(i).getEmployeeId(), 
					list.get(i).getName(), 
					list.get(i).getSalary()); // %값은 뒤에서 받아오는 용도, d는 int, s는 문자열
			}	
	}	
	@Override
	public int searchSal(int employeeId) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getSalary();
				break;
			}
		}
		return result;
	}
	
}
