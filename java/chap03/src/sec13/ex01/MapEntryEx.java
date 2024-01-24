package sec13.ex01;

import java.util.HashMap;
import java.util.Map;

public class MapEntryEx {

	public static void main(String[] args) {
		// HashMap 생성 (키: 문자열, 값: 정수)
		Map<String, Integer> hashMap = new HashMap<>();
		
		// 데이터 추가
		hashMap.put("apple", 1000);
		hashMap.put("banana", 2000);
		hashMap.put("orange", 1500);
		
		// 데이터 조회
		for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		// 데이터 추가
		hashMap.put("grape", 3000);
		System.out.println("데이터 추가 후: " + hashMap);
		
		// 키값으로 데이터 삭제
		hashMap.remove("banana");
		System.out.println("데이터 삭제 후: " + hashMap);
	}

}
