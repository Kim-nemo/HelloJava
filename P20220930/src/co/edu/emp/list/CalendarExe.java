package co.edu.emp.list;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		today.set(2022, 1, 1); // = 2022.10.1일
		System.out.println("요일정보: " + today.get(Calendar.DAY_OF_WEEK)); // 일요일부터 1
		System.out.println("날짜정보: " + today.get(Calendar.DATE));
		System.out.println("월정보: " + (today.get(Calendar.MONTH)+1)); // 1월부터 0, 그래서 1더해줌
		System.out.println("월말정보: " + today.getActualMaximum(Calendar.DATE));
	}
}
