package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar {
	private static MethodCalendar instance = new MethodCalendar();
	private MethodCalendar() {}
	public static MethodCalendar getInstance() {
		return instance;
	}
	
	public void makeCal(int year, int month) {
		System.out.println("      >> "+ year + " 년, " + month+" 월 <<");
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		// 요일 출력
		for(String day : days) { //days는 배열, day는 변수
			System.out.printf("%4s", day); // %4s: 4개의 문자열 안에 변수를 넣겠습니다
		}
		System.out.println();
		
		// 1일의 위치지정
		for(int i=0; i<getFirstDay(year,month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력
		for(int i=1; i<=getLastDate(year,month); i++) {
			System.out.printf("%4d", i); // 변수 값이 정수면 문자열을 나타내는 s를 d로 바꿔줘야한다
			if((i+getFirstDay(year, month))%7 == 0) {
				System.out.println();
			}
		}
	} // end of makeCal()
	
	public int getFirstDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		return cal.get(Calendar.DAY_OF_WEEK) -1; // 1 		
	}// end of getFirstDay()
	
	public int getLastDate(int year, int month) {
		// switch..case.. 구문
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		return cal.getActualMaximum(Calendar.DATE);
	}
} // end of Class.
