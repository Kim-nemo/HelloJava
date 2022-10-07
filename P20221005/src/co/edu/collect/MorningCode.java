package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ{
	int empId;
	String empName;
	int salary;
	
	public Employ(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		
	}	
	public Employ() {}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	
}

public class MorningCode {
	public static void main(String[] args) {
//		String tok = "Hello World Good";
//		Scanner scn = new Scanner(tok);
		
		
//		while(scn.hasNext()) // 가지고 올 값이 있는지 없는지 체크하는 메소드 hasNext() 있으면 들고옴
//			System.out.println(scn.next()); //공백을 기준으로 단어를 잘라서 들고옴
		
//		String[] toks = tok.split(" "); //공백을 기준으로 단어를 잘라서 들고옴
//		for(String str : toks) {
//			System.out.println(str);
//		}
		
		Scanner scanner = new Scanner(System.in); //키보드 입력으로 들어온 애들
		// 첫번재 값 => empId, 두번째 값 => empName, 세번째 값 => salary
		// Employee클래스의 인스턴스생성
		// ArrayList에 저장
		// 종료를 하고싶으면 quit 종료
		ArrayList<Employ> list = new ArrayList<>();
		System.out.println("입력>> ex) 100 홍길동 2500");
		while(true) {
			System.out.print(">> ");
			String inputVal = scanner.nextLine();
			String[] inputs = inputVal.split(" ");
			if(inputs[0].equals("quit")) {
				break;
			}
			
			if(inputs.length != 3) {
				System.out.println("다시 입력");
				continue;
			}
			
			list.add(new Employ(Integer.parseInt(inputs[0]), inputs[1], Integer.parseInt(inputs[2])));

		}
		// for(반복문) 출력
		for(Employ emp : list) {
			System.out.println(emp);
		}
		System.out.println("end of prog.");
	}
}
