package sec13.ex01;

import java.util.HashMap;
import java.util.Map;

public class MapHashCodeEqualsEx {

	public static void main(String[] args) {
		// HashMap 생성 (키: Person 객체, 값: 정수)
		Map<Students, Integer> scores = new HashMap<>();
		
		// 데이터 추가
		Students kim = new Students("김자바", 30);
		Students shin = new Students("신시아", 20);
		Students kimDuplicate = new Students("김자바", 30); // 중복 데이터
		
		scores.put(kim, 90);
		scores.put(shin, 100);
		scores.put(kimDuplicate, 95); // 동등 객체이므로 중복으로 처리됨
		
		// 데이터 조회
		for (Students person: scores.keySet()) {
			int score = scores.get(person);
			System.out.println(person.getName() + "의 정수: " + score);
		}
		
	}

}
