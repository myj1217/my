package sec11.ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
	       Date currentDate = new Date(); // 현재 날짜와 시간을 나타내는 Date 객체 생성
	        System.out.println(currentDate);
	        
	        // 원하는 형식의 문자열 생성
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd 일 hh시 mm분");
	        String strDate = sdf.format(currentDate); // 원하는 형식의 날짜 정보
	        System.out.println(strDate); 
	}

}
