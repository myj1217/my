package sec13.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashTreeEx {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		
		// 데이터 추가
		hashMap.put("apple", 1000);
		hashMap.put("banana", 2000);
		hashMap.put("orange", 1500);
		
		// 데이터 조회
		System.out.println("HashMap(순서유지 안됨):");
		for (String key: hashMap.keySet()) {
			System.out.println(key + ": " + hashMap.get(key));
		}
		
		// TreeMap 생성
		Map<String, Integer> treeMap = new TreeMap<>();
		
		// 데이터 추가
		treeMap.put("apple", 1000);
		treeMap.put("banana", 2000);
		treeMap.put("orange", 1500);
		
		// 데이터 조회
		System.out.println("\nTreeMap(순서유지):");
		for (String key: treeMap.keySet()) {
			System.out.println(key + ": " + treeMap.get(key));
		}
	}

}
