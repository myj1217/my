package sec14.ex01;

import java.util.function.Function;

public class MethodEx {

	public static void main(String[] args) {
		// Function<입력타입, 출력타입>
		Function<String, Integer> parseInt = Integer::parseInt;
		
		// apply 메서드는 함수를 실행해서 입력값을 출력값으로 반환하는 역할을 한다.
		int result = parseInt.apply("123");
		System.out.println(result);
	}

}
