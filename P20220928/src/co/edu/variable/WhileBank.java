package co.edu.variable;

import java.util.Scanner; //ctrl + shift + O : import 단축키

public class WhileBank {
	
	public static void main(String[] args) {
		bankApp();
	}
	
	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		// 메뉴: 1: 예금, 2: 출금, 3: 잔고, 4: 종료
		// 10만원이 넘으면 예금 안됨, 마이너스도 안됨
		while(run) {
			System.out.println("메뉴: 1: 예금, 2: 출금, 3: 잔고, 4: 종료");
			int menu = scn.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("예금처리하는 메뉴");
				System.out.println("예금액을 입력>>> ");
				int input = scn.nextInt();	
				if(money + input > 100000) {
					System.out.println("10만원 이상 입금 불가입니다");
				}else{
					money=money+input;
				}
				break;
			case 2:
				System.out.println("출금처리하는 메뉴");
				System.out.println("출금액을 입력>>> ");
				int output = scn.nextInt();
				if(money - output < 0) {
					System.out.println("잔액이 부족합니다");
				}else {
					money= money-output;
				}
				break;
			case 3:
				System.out.println("잔고조회하는 메뉴");
				System.out.println("현재 잔고는: "+money+"원 입니다");
				break;
			case 4:
				System.out.println("종료하는 메뉴");
				run = false;
			}
		} // end of while
		System.out.println();
		System.out.println("end of program");
	} // end of bankApp()
}
