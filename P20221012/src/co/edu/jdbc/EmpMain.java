package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);
		Employee employee = null;
		
		// 메뉴=> 1.사원등록(insert) 2.한건조회(getEmp) 3.수정(id기준) 4.삭제(id기준) 5.목록조회 6.일괄등록 9.종료
		
		while(true) {
			
			System.out.println("메뉴=> 1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
			System.out.print(">> ");
			
			int menu = scn.nextInt(); scn.nextLine();
			if(menu == 1) {
				System.out.print("등록할 사원의 번호>> ");
				int employeeId = Integer.parseInt(scn.nextLine());
				System.out.print("등록할 사원의 이름>> ");
				String lastName = scn.nextLine();
				System.out.print("등록할 사원의 이메일>> ");
				String email = scn.nextLine();
				System.out.print("등록할 사원의 입사일>> ");
				String hireDate = scn.nextLine();
				System.out.print("등록할 사원의 직무>> ");
				String jobId = scn.nextLine();
				
				employee = new Employee(employeeId, lastName, email, hireDate, jobId);
				dao.insert(employee);
			}else if(menu == 2) {
				System.out.print("조회할 사원의 번호>> ");
				int findEmp = Integer.parseInt(scn.nextLine());
				Employee i = dao.getEmp(findEmp);
				System.out.println(i);
			}else if(menu == 3) {
				System.out.print("수정할 사원의 번호>> ");
				int employeeId = Integer.parseInt(scn.nextLine());
				System.out.print("수정할 사원의 이름>> ");
				String lastName = scn.nextLine();
				System.out.print("수정할 사원의 이메일>> ");
				String email = scn.nextLine();
				System.out.print("수정할 사원의 입사일>> ");
				String hireDate = scn.nextLine();
				System.out.print("수정할 사원의 직무>> ");
				String jobId = scn.nextLine();
				
				employee = new Employee(employeeId, lastName, email, hireDate, jobId);
				dao.update(employee);
			}else if(menu == 4) {
				System.out.print("삭제할 사원의 번호>> ");
				int employeeId = Integer.parseInt(scn.nextLine());
				if(dao.delete(employeeId)) {
					System.out.println("정상적으로 삭제");
				}else {
					System.out.println("삭제할 데이터 없습니다");
				}
			}else if(menu == 5) {
				System.out.println("전체 목록 조회");
				List<Employee> employees = dao.search();
				for(Employee emp : employees) {
					System.out.println(emp);
				}
			}else if(menu == 6) {
				System.out.println("일괄 등록");
				String[] emps = null;
				try(
					FileReader fr = new FileReader("C:/Temp/emplist.txt");
					BufferedReader br = new BufferedReader(fr);
				){
					while(true) {
						String emp = br.readLine();
						if(emp == null)
							break;
						
						emps = emp.split(" ");
						employee = new Employee(Integer.parseInt(emps[0]), emps[1], emps[2], emps[3], emps[4]);
						dao.insert(employee);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("completed!");
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		
		scn.close();
		System.out.println("종료");
	}
}
