package sec05.ex01;

import java.util.ArrayList;

public class ReferenceType {

	public static void main(String[] args) {
		System.out.println("1. 객체 생성과 참조 변수 할당");
		// 문자열 객체 생성
		String str = new String("Hello, World!");
		
		// ArrayList 객체 생성
		// 정수 타입의 배열 생성, <>로 표시
		// ArrayList 쓰는 이유 : 동적으로 메모리를 관리할 수 있다.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		System.out.println("2. 객체 멤버에 접근");
		// 문자열 길이 가져오기
		int length = str.length();
		
		// ArrayList에 요소 추가
		// 객체에 접근해서 add 메서드 사용
		numbers.add(10);
		numbers.add(20);
		System.out.println(length);
		System.out.println(numbers);
		System.out.println("3. 참조 변수 간의 할당");
		
		// 참조 변수 할당
		String anotherStr = str;
		
		// ArrayList 참조 변수 할당
		ArrayList<Integer> anotherNumbers = numbers;
		
		System.out.println("4. 참조 비교");
		// 참조 변수 비교
		boolean sameString = (str != anotherStr);
		
		// ArrayList 참조 변수 비교
		boolean sameNumbers = (numbers == anotherNumbers);
		System.out.println(sameString);
		System.out.println(sameNumbers);
		
		System.out.println("5. null 검사");
		// null 검사
		if (str == null) {
			// str이 null인 경우의 처리
			System.out.println("null 입니다.");
		} else {
			System.out.println("null이 아닙니다.");
		}
	}

}
