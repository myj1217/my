package sec11.ex02;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		// 현재 날짜와 시간을 나타내는 Calendar 객체 생성
		Calendar calendar = Calendar.getInstance();
		// 현재 년도 가져오기
		int year = calendar.get(Calendar.YEAR);
		// 현재 월 가져오기 (0부터 시작)
		int month = calendar.get(Calendar.MONTH);
		// 현재 일자 가져오기
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("Year: " + year);
		System.out.println("Month: " + (month + 1));
		System.out.println("Day: " + dayOfMonth);
		
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		String weekday = "";
		
		switch (week) {
		case Calendar.SUNDAY:
			weekday = "일요일";
			break;
		case Calendar.MONDAY:
			weekday = "월요일";
			break;
		case Calendar.TUESDAY:
			weekday = "화요일";
			break;
		case Calendar.WEDNESDAY:
			weekday = "수요일";
			break;
		case Calendar.THURSDAY:
			weekday = "목요일";
			break;
		case Calendar.FRIDAY:
			weekday = "금요일";
			break;
		case Calendar.SATURDAY:
			weekday = "토요일";
			break;
		}
		System.out.println("오늘은 " + weekday + "입니다.");
		
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		String amPm = hourOfDay < 12 ? "오전":"오후";
		System.out.println("현재 시간은 " + amPm + " " + hour + "시 " + minute + "분입니다.");
	}

}
