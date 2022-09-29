package co.edu.variable;

import java.util.Arrays;
import java.util.Collections;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34,21,12,9,8,7,5,4,2,1};
		
		//반복적인 처리.
//		numAry = {12,21,34} //작은값 순으로 위치를 바꾸고 싶어
		// 케이스 : n1 > n2 > n3 => ?? 내림차순
		// 케이스 : n1 < n2 < n3 => ?? 오름차순 {12,21,34}
//		if(numAry[0] > numAry[2]) {
//		int temp2 = numAry[0];
//		numAry[0] = numAry[2];
//		numAry[2] = temp2;
//	}
		// 1) 4개 ->3번비교, 2번비교, 1번비교
//		if(numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0]; // 바꾸기전에 temp라는 변수에 담아놓고 값이 바꿔지지 않도록 한다
//			numAry[0] = numAry[1]; // 21
//			numAry[1] = temp;
//		}
//		if(numAry[1]>numAry[2]) {
//			int temp = numAry[1];
//			numAry[1] = numAry[2];
//			numAry[2] = temp;
//		}
//		if(numAry[2] > numAry[3]) {
//			int temp = numAry[2];
//			numAry[2] = numAry[3];
//			numAry[3] = temp;
//		}
//		// 2)
//		if(numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0]; // 바꾸기전에 temp라는 변수에 담아놓고 값이 바꿔지지 않도록 한다
//			numAry[0] = numAry[1]; // 21
//			numAry[1] = temp;
//		}
//		if(numAry[1]>numAry[2]) {
//			int temp = numAry[1];
//			numAry[1] = numAry[2];
//			numAry[2] = temp;
//		}
////		2-1) 숫자가 네개 일 때
//		if(numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0]; // 바꾸기전에 temp라는 변수에 담아놓고 값이 바꿔지지 않도록 한다
//			numAry[0] = numAry[1]; // 21
//			numAry[1] = temp;
//		}
//		-------------------------------------------------
		
	
	for(int j=0; j<numAry.length-1; j++) {	
		for(int i=0; i < numAry.length-1; i++) {
			if(numAry[i] > numAry[i+1]) { // i 값이 0일때,
				int temp = 0;
				temp = numAry[i]; //순서가 먼저 있는 값을 temp
				numAry[i] = numAry[i+1];
				numAry[i+1] = temp;
			}
		}
	}
	
		
//		 3)순서 출력
		for(int n : numAry) {
			System.out.print(n + " ");
		}
	}
}