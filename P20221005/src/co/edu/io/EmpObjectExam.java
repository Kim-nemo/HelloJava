package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {
		
		// C:/Temp/emp.dat
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry;
			if(menu == 1) {
//				System.out.println("사원id를 입력하세요>> ");
//				int id = Integer.parseInt(scn.nextLine());
//				System.out.println("이름을 입력하세요>> ");
//				String name = scn.nextLine();
//				System.out.println("부서명을 입력하세요>> ");
//				String dept = scn.nextLine();
//				
//				Emp emp = new Emp(id, name, dept);
//				empList.add(emp);
				
				//split을 이용할 경우 
				
				System.out.print(">> ");
				String empVal = scn.nextLine();
				empAry = empVal.split(" ");
				Emp emp = new Emp(Integer.parseInt(empAry[0]),empAry[1],empAry[2]);
				empList.add(emp);
				System.out.println("입력완료");
				
				
				
			}else if(menu == 2) {
				for(Emp emp : empList) {
					System.out.println(emp.toString());
				}
			}else if(menu == 3){
				// 사원번호를 기준으로 삭제
				System.out.print("삭제할 사원의 id를 입력해주세요>> ");
				int delId = Integer.parseInt(scn.nextLine());
				for(int i=0; i<empList.size(); i++) {
					if(delId == empList.get(i).id) {
						empList.remove(i); // 삭제를 원하는 인덱스값 넣어주기
					}
				}
				 		
			}else if(menu == 4) {
				// 컬렉션에 있던 ObjectOutputStream 을 활용해서 C:/Temp/emp.dat 저장
				try(FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					) {
								
					oos.writeObject(empList);
								
					} catch (FileNotFoundException e) {
							e.printStackTrace();
					} catch (IOException e) {
							e.printStackTrace();
					}
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택하셨습니다");
			}
		}
		System.out.println("끝");
	}
}
