package co.edu.nested;

interface Run {
	void run();
}

class Runner implements Run{
	@Override
	public void run() {
		System.out.println("run.");
	}
}
public class AnonymousExample2 {
	public static void main(String[] args) {
		
		// 익명구현객체: 상황에 따라 기능이 다를 경우
		Run runner = new Run() { //Run이라고 하는 인터페이스를 구현하는 객체 만들기
			String kind;
			
			void runKind() {
				System.out.println("육상");
			}
			
			@Override
			public void run() {
				System.out.println("구현 run.");
				runKind();
			}
		};
		runner.run();
		
		Run runner2 = new Run() {
			@Override
			public void run() {
				System.out.println("구기종목");
			}
		}; // 실행문이기 때문에 세미콜론 붙여줘야함
		runner2.run();
	}
}
