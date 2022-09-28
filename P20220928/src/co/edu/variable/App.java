package co.edu.variable;

// 자바는 class 시작.
// 클래스의 main메소드로 시작.
// 컨트롤 스페이스로 자동완성 칸 열 수 있음
public class App {
	public static void main(String[] args) {
		System.out.println("매개값을 출력."); // (괄호 안에 있는 매개값을 출력)
		
		// 변수의 타입 지정. 정수(int, long), 실수(double, float)
		// 참/거짓(boolean), 문자열(String)
		
		int myAge = 25; // 오른쪽 = 왼쪽 타입이 항상 동일해야한다
//		myAge = "스물다섯"; // 컴파일 에러. 타입이 동일하지 않기 때문
		String 내나이 = "스물다섯";
		내나이 = "28"; // 문자열 28
		
		int result = myAge + 30;
		System.out.println(myAge + "라는 값과 30을 더하면 "+ result + "입니다.");
		
		//배열
		//let numAry = [];
		int[] numAry = {20,29,13,44,88,33}; // 배열 선언
		int sum = 0;
		for (int i = 0; i < 6; i++) {
//			System.out.println(numAry[i]);
//			1) 배열의 합계
			//짝수조건일 경우에만 합계
//			if(numAry[i] % 2 == 0) {
//				sum = sum + numAry[i];
//			}
			//1,3,5번째 있는 숫자들만 합계
			if(i%2 == 0) {
				sum = sum + numAry[i];
			}
		}
		System.out.println("합계=> " + sum);
		
//		2) 배열 조건
		sum = 0; //0값으로 초기화 문제: sum의 값이 100을 넘어서는 시점 break;
		for(int i=0; i<6; i++) {
			sum = sum + numAry[i];
			if(sum > 100){
			System.out.println("문제의 답은 "+sum);
			break;
			}
		}
	}
}

