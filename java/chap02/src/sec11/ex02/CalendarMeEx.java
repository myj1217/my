package sec11.ex02;

import java.util.Calendar;

public class CalendarMeEx {

   public static void main(String[] args) {
          Calendar calendar = Calendar.getInstance(); // 현재 날짜와 시간을 나타내는 Calendar 객체 생성
           int year = calendar.get(Calendar.YEAR);    // 현재 년도 가져오기
           int month = calendar.get(Calendar.MONTH);    // 현재 월 가져오기 (0부터 시작)
           int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일자 가져오기
           
           // set(): 특정 필드의 값을 설정함
           calendar.set(Calendar.YEAR, 2023);
           calendar.set(Calendar.MONTH, 11);    // 12월을 나타내는 값은 11
           calendar.set(Calendar.DAY_OF_MONTH, 25);

           year = calendar.get(Calendar.YEAR);
           month = calendar.get(Calendar.MONTH) + 1;
           dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

           System.out.println("set() Year: " + year);
           System.out.println("set() Month: " + month);
           System.out.println("set() Day: " + dayOfMonth);
           System.out.println("-------------------------------------");
           
           // add(): 특정 필드의 값을 증가 또는 감소시킴
//           calendar.add(Calendar.MONTH, 2); // 현재 월에서 2달 후로 설정
//
//           year = calendar.get(Calendar.YEAR);
//           month = calendar.get(Calendar.MONTH) + 1;
//           dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//
//           System.out.println("Year: " + year);
//           System.out.println("add() Month: " + month);
//           System.out.println("Day: " + dayOfMonth);
//           System.out.println("-------------------------------------");
           
           // roll(): 특정 필드의 값을 증가 또는 감소시키지만 상위 필드에 영향을 주지 않음
           // 월과 연도 필드는 영향을 받지 않습니다. 
           calendar.roll(Calendar.DAY_OF_MONTH, 10); // 현재 일자에서 10일 후로 설정

           year = calendar.get(Calendar.YEAR);
           month = calendar.get(Calendar.MONTH) + 1;
           dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

           System.out.println("Year: " + year);
           System.out.println("Month: " + month);
           System.out.println("roll() Day: " + dayOfMonth);
   }

}