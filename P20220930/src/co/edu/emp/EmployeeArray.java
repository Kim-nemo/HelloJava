package co.edu.emp;

import java.util.Scanner;

// 배열을 활용해서 정보를 저장
public class EmployeeArray implements EmployeeService{
	// 저장공간 생성
	Employee[] list;
	int idx;
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		System.out.println("사원수 입력>>> ");
		int cnt = Integer.parseInt(scn.nextLine()); 
		list = new Employee[cnt]; // 만약 5를 입력한다면 5개 인스턴스를 저장할 수 있는 공간생성
	}

	@Override
	public void input() {
		
		if(idx >= list.length) {
			System.out.println("더 이상 입력불가");
			return; //메소드 종료
		}
		
		System.out.println("사번>> ");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>>" );
		String name = scn.nextLine();
		System.out.println("부서>>" );
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("급여>> ");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>>" );
		String email = scn.nextLine();
		
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list[idx++] = emp; // list 는 배열, idx는 int타입의 필드값(기본이 num값)
		
	}

	@Override
	public String search(int employeeId) {
		// 입력된 값 중에서 찾도록. list[5] => idx
		// 100,200,300 
		String result = null;
		for(int i=0; i<idx; i++) {
			if(list[i].getEmployeeId() == employeeId){
				result = list[i].getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) {
			System.out.printf("%5d %10s %7d\n", 
					list[i].getEmployeeId(), 
					list[i].getName(), 
					list[i].getSalary()); // %값은 뒤에서 받아오는 용도, d는 int, s는 문자열
		}
	}

	@Override
	public int searchSal(int employeeId) {
		// 사원번호 => 급여반환
		int result = 0;
		for(int i=0; i<idx; i++) {
			if(list[i].getEmployeeId() == employeeId) {
				result = list[i].getSalary();
				break;
			}
		}
		return result;
	}
	
}