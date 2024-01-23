package sec11.ex01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentEx {

	public static void main(String[] args) {
		// 작업 시작 시간 기록
		long startTime = System.currentTimeMillis();
		long startTime1 = System.nanoTime();
		
		// 현재 시간을 날짜 및 시간 형식으로 변환
		Date date = new Date(startTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedTime = dateFormat.format(date);
		
		// 현재 시간 출력
		System.out.println("현재 시간: " + formattedTime);
		
		// 소요시간을 확인하기 위한 작업
		int sum = 0;
		for (int i=1; i<=1000000; i++) {
			sum += i;
		}
		
		// 작업 종료 시간 기록
		long endTime = System.currentTimeMillis();
		long endTime1 = System.nanoTime();
		
		// 실행 시간 계산
		long executionTime = endTime - startTime;
		long executionTime1 = endTime - startTime1;
		
		// 실행 시간 출력
		System.out.println("1~1000000 의 합: " + sum);
		System.out.println("currentTimeMillis의 작업 실행 시간: " + executionTime + "ms");
		System.out.println("nanoTime 작업 실행 시간: " + executionTime1 + "ms");
}

}
