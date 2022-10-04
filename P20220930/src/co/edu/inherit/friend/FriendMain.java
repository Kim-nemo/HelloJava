package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
//		final String constVar = "Hello"; // final이 클래스에 붙으면 상속불가, 메소드에 붙으면 자식이 재정의 불가
//		constVar = "World"; // 변수 (Const Variable): 재할당,변경 불가
		
		FriendExe app = new FriendExe();
		app.exe();
	}
}
