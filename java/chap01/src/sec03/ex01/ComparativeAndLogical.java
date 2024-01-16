package sec03.ex01;

public class ComparativeAndLogical {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// 동등 비교
		boolean isEqual = (a == b); // false
		
		// 부등 비교
		boolean notEqual = (a != b); // true
		
		// 크기 비교
		boolean greaterThan = (a > b); // true
		boolean lessThan = (a < b); // false
		boolean greaterThanOrEqual = (a >= b); // true
		boolean lessThanOrEqual = (a <= b); // false
		
		System.out.println(isEqual);
		System.out.println(notEqual);
		System.out.println("========================");
		
		boolean c = true;
		boolean d = false;
		
		// 논리 곱 (AND): 두 개의 논리 값이 모두 'true'일 때만 'true'를 반환
		// && 앞에 있는 것(c)이 true 일 때만 && 뒤에 있는 것(d)도 연산
		// 둘 다 true 여야만 true이기 때문에 앞이 false면 바로 false 출력
		boolean result1 = c && d; // false
		
		// 논리 합 (OR): 두 개의 논리 값 중 하나 이상이 'true'이면 'true'를 반환
		boolean result2 = c || d; // true
		
		// 논리 부정 (NOT): 단일 논리 값의 반대를 반환
		boolean result3 = !c; // false
		
		System.out.println(result1);
		System.out.println(result2);
	}

}
