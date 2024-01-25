package sec14.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		// ArrayList: 데이터를 인덱스로 처리
		List<String> names = new ArrayList<>();
		names.add("진수");
		names.add("은화");
		names.add("미나");
		names.add("미진");
		names.add("은당");
		
		// Consumer를 사용하여 각 요소 출력
		Consumer<String> printName = name -> System.out.println("이름: " + name);
		// forEach: 있는만큼 순회
		names.forEach(printName);
	}

}
