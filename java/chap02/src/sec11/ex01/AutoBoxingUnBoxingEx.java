package sec11.ex01;

import java.util.ArrayList;

public class AutoBoxingUnBoxingEx {

	public static void main(String[] args) {
		// Boxing: int를 Integer로 자동 변환
		int num = 10;
		Integer wrapperNum = num;
		
		// Unboxing: Double를 double로 자동 변환
		Double wrapperDouble = 3.14;
		double doubleNum = wrapperDouble;
		
		// Boxing과 Unboxing을 함께 활용
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// Unboxing: int를 Integer로 자동 변환하여 numbers 리스트에 추가
		// Unboxing: Integer를 int로 자동 변환
		numbers.add(1);
		int firstNumber = numbers.get(0);
		
		// 출력하여 확인
		System.out.println("Wrapper class example: ");
		System.out.println("wrapperNum: " + wrapperNum);
		System.out.println("doubleNum: " + doubleNum);
		System.out.println("firstNumber: " + firstNumber);
		
		System.out.println("Type of numbers: " + wrapperNum.getClass().getSimpleName());
	}

}
