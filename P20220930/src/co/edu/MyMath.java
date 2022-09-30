package co.edu;

public class MyMath {
	// 절대값 구하는 메소드
	public static int abs(int num) {
		return num > 0 ? num : -num; // num이 0보다 큰 값이면 num을, 작은 값으면 -num을.
	}
	// 지수값 구하는 메소드
	public static int power(int base, int exponent) {
		int result = 1;
		for(int i=1; i <= exponent; i++) {
			result = result * base;
		}
		return result;
	}
}
