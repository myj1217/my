package sec13.ex01;

import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {
		HashSet<Integer> numbers = new HashSet<>();
		
		// 추가
		numbers.add(4);
		numbers.add(7);
		numbers.add(8);
		numbers.add(7); // 중복 저장 (한번만 저장됨)
		
		// 1부터 10까지 출력
		for (int i = 1; i <= 10; i++) {
			// 객체에 포함되어 있는지 확인
			if (numbers.contains(i)) {
				System.out.println(i + " 값이 있습니다------");
			} else {
				System.out.println(i + " 값이 없습니다");
			}
		}
		// 요소 개수 확인
		System.out.println("Set의 크기: " + numbers.size());
		
		// 객체 안을 비움
		numbers.clear();
		
		// 객체에 비어 있는지 확인
		if(numbers.isEmpty()) {System.out.println("비어있습니다.");}
	}

}
