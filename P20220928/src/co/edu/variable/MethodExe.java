package co.edu.variable;

public class MethodExe {
	//main 메소드: 첫번째 실행	// void : 반환값		// 괄호 안: 매개변수
	public static void main(String[] args) {
//		printStar();
//		printStar(3); // 실행부분은 변수타입(ex.int) 기재X 값만 넣음.
//		printCircle("$");
//		printCircle("◆", 5); // 실행부분은 변수타입(ex.int 5) 기재X 값만 넣음.
		int result = sum(sum(2,3), sum(3,4));
		System.out.println("최종값은 " + result);
	}
	
	public static void printStar() { // 반환값: 없음. 매개변수: 없음.
		System.out.println("★");
	}
	
	public static void printStar(int times) { // 반환값: 없음. 매개변수: 있음.
		for(int i=0; i<times; i++) {
			System.out.println("★");
		}
	}
	
	public static void printCircle(String circle) {
		System.out.println(circle); //print(circle)이라는 메소드는 매개변수를 가지고 원하는 출력 결과를 만들 수 있다
	}
	
	//출력하는 모양, 갯수를 매개값으로 가져오겠다
	public static void printCircle(String circle, int times) {
		for(int i=0; i<times; i++) {
			System.out.println(circle);
		}
	}
	
	// 반환값을 가지는 메소드
	public static int sum(int n1, int n2) {
		int result = n1 * 2 + n2 * 3;
		System.out.println("결과값은 " + result);
		return result; // 반환값의 유형은 int
	}
}
