package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5]; // 값은 안 넣고 크기만 배열 : new int[i];
		// int[] : 정수만 담을 수 있는 데이터 타입(int)을 정한 배열
		randomAry[0] = (int) (Math.random() * 100) + 1; // Math.random() : 0~1 사이의 임의수 생성
		//실수타입을 정수로 바꿔주는 것: 캐스팅, 윗줄 예시는 (int)를 넣어 정수타입으로 바꿔줌
		// +1하면 1부터 10사이의 임의의 값이 나타나짐.
		randomAry[1] = (int) (Math.random() * 100) + 1;
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;
		
		int minVal = 100; // 배열요소 중 가장 큰 값(maxVal),작은 값(minVal)을 저장할 용도로 변수 지정
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
			// maxVal 변수에 두 값을 비교해서 큰 값을 담기
			if(randomAry[i]<minVal) {
				minVal=randomAry[i];
				}
			}
		System.out.println("생성된 배열의 임의의 값 중 최소값=> "+minVal);		
	}
}
