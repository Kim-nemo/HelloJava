package co.edu.variable;

import java.util.Scanner;

public class WhileExe {
	
	public static void main(String[] args) {
		whileFnc3();
	}
	
	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료하고 싶으면 9를 입력.
		Scanner scn = new Scanner(System.in);
		while(true) {
			
			System.out.println("보고싶은 달을 입력하세요. 종료하려면 -1을 입력하세요!");
			int input = scn.nextInt();
			if(input == -1) {
				break;
			}
			MethodCalendar.makeCal(input);
			System.out.println();
		}
		System.out.println("end of program");
		scn.close();
	}
	
	public static void whileFnc2() {
		//while 구문
		Scanner scn = new Scanner(System.in); // import: ctrl+shf+o
		while(true) {
			System.out.println("값을 입력하세요. 종료하려면 stop을 입력하세요!");
			String inputVal = scn.nextLine();
			if(inputVal.equals("stop")) {
				break;
			}
			System.out.println("사용자입력값> "+ inputVal);
		}
		System.out.println("end of program");
		scn.close(); // 시스템 자원을 반환.
	}
	
	public static void whileFnc() {
		//for 반복문: 반복횟수가 정해져 있을 때. for(int i=0; i<10; i++){}
		int i=0;
		while(i<4) {
			System.out.println(i);
			i++;
		}
		System.out.println("end of program");
	}
	
}
