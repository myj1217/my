package sec13.ex01;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceComparisonEx {

	public static void main(String[] args) {
		int n = 1000000; // 요소 개수
		long startTime, endTime;
		
		// ArrayList 추가 및 삭제 속도 측정
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		// ArrayList 추가
		startTime = System.nanoTime(); // 시작시간
		for (int i = 0; i < n; i++) {
			arrayList.add((int) (Math.random() * n));
		}
		endTime = System.nanoTime(); // 끝시간
		System.out.println("ArrayList 추가 시간: " + (endTime - startTime) + "ns");
		
		startTime = System.nanoTime();
		arrayList.remove(arrayList.size() - 1); // 마지막 요소 삭제
		endTime = System.nanoTime();
		System.out.println("ArrayList 삭제 시간: " + (endTime - startTime) + "ns");
		
		// LinkedList 추가 및 삭제 속도 측정
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		startTime = System.nanoTime();
		for (int i = 0; i < n; i++) {
			linkedList.add((int) (Math.random() * n));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 추가 시간: " + (endTime - startTime) + "ns");
		
		startTime = System.nanoTime();
		linkedList.removeLast(); // 마지막 요소 삭제
		endTime = System.nanoTime();
		System.out.println("LinkedList 삭제 시간: " + (endTime - startTime) + "ns");
	}

}
