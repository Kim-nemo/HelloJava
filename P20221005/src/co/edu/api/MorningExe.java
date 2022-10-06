package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int num =1;
		for(int i=1; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.printf("%3d", num++);
			}
			System.out.println();
		}
		System.out.println();
		
		String blank = " ";
		int no =1;
		for(int i=1; i<5; i++) {
			for(int b=0; b<4-i; b++) {
				System.out.printf("%3s",blank);
			}
			for(int j=0; j<i; j++) {
				System.out.printf("%3d", no++);
			}
			System.out.println();
		}
	}
}
