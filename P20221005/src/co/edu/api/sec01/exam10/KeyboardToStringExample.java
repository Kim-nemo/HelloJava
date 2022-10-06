package co.edu.api.sec01.exam10;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException{
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes);
		
		String str = new String(bytes, 0, readByteNo-2); // 2를 빼준 이유는 \r과 \n부분은 문자열로 만들 필요가 없기 때문. 윈도우
		System.out.print(str);
	}
}
