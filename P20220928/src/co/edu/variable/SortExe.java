package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34,21,12};
		
		//반복적인 처리.
//		numAry = {12,21,34} //작은값 순으로 위치를 바꾸고 싶어
		// 케이스 : n1 > n2 > n3 => ??
		// 케이스 : n1 < n2 > n3 => ??
		
		if(numAry[0] > numAry[1]) { // 34 > 21
			int temp = numAry[0]; // 바꾸기전에 temp라는 변수에 담아놓고 값이 바꿔지지 않도록 한다
			numAry[0] = numAry[1]; // 21
			numAry[1] = temp;
		}
		
		for(int n : numAry) {
			System.out.println(n);
		}
	}
}