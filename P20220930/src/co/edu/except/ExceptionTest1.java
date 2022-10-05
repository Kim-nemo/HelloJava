package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조
		String str = "Hello World!!";
		// 예외처리 RuntimeExceptino 상속받아서 처리하는 예외클래스
		try {
			String result = str.substring(0, 10);
			char chr = result.charAt(20);
			System.out.println(chr);
			
		}catch(NullPointerException | StringIndexOutOfBoundsException e) { // 널값 때문에 프로그램이 강제로 종료하지않게 NullPointerException 로 이동
			System.out.println("참조하는 값이 없습니다");
			System.out.println("인덱스범위를 벗어난 값입니다");
//		}catch(StringIndexOutOfBoundsException e1) { // 인덱스값보다 클 때 예외처리
//			System.out.println("인덱스범위를 벗어난 값입니다");
		}catch(RuntimeException e2) {
			System.out.println("실행예외가 발생했습니다"); 
		}catch(Exception e3) {
			System.out.println("알 수 없는 예외가 발생했습니다"); // 가장 큰 범위의 예외를 가장 마지막 위치에 두기
		}
		
		
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("숫자입력>> ");			
			try {
				int menu = scn.nextInt(); // InputMismatchException
				System.out.println("입력한 값은 : " + menu);
				break;
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요!");
				scn.nextLine(); // abc (Enter) 값을 소진시켜주는 용도
			}finally {
				System.out.println("반드시 실행할 코드");
				// db connection 사용하고 resource 반환
				
			}
		}
		
		// 예외를 떠넘길수도 있다
		try {
			exceptMethod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}// end of main()
	
	public static void exceptMethod() throws ClassNotFoundException {
		// 일반예외 : Exception 상속받아서 처리하는 예외클래스
//			try {
				Class.forName("java.lang.String");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
		
	}
	
}
