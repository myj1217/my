package sec13.ex01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx {

	public static void main(String[] args) {
		// HashSet 생성
		Set<String> set = new HashSet<>();
		
		// 요소 추가
		set.add("사과");
		set.add("바나나");
		set.add("오렌지");
		set.add("포도");
		
		// Iterator를 사용하여 Set의 모든 요소 출력
		// Iterator: Set 안에 있는 객체들을 들여다볼 수 있는 능력이 있음
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String fruit = iterator.next(); // next(): 하나만 담는다
			System.out.println(fruit);
			
			if (fruit.equals("바나나")) {
				iterator.remove(); // "바나나" 삭제
			}
		}
		
		// 삭제 후 남은 요소 출력
		System.out.println("=== 삭제 후 남은 요소 ===");
		for (String fruit: set) {
			System.out.println(fruit);
		}
		// "바나나"가 Set에 있는지 확인
		System.out.println("Set에 '바나나'가 있나요? " + set.contains("바나나"));
	}

}
