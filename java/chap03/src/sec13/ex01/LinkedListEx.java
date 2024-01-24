package sec13.ex01;

import java.util.LinkedList;

public class LinkedListEx {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		
		// 요소 추가
		linkedList.add("사과");
		linkedList.add("바나나");
		linkedList.add("오렌지");
		linkedList.addFirst("복숭아"); // 맨 처음에 요소 추가
		linkedList.addLast("체리"); // 맨 끝에 요소 추가
		
		// 요소 출력
		System.out.println("리스트: " + linkedList);
		
		// 요소 접근
		String firstElement = linkedList.getFirst(); // 맨 처음 요소 얻기
		String lastElement = linkedList.getLast(); // 맨 끝 요소 얻기
		System.out.println("맨 처음: " + firstElement);
		System.out.println("맨 끝: " + lastElement);
		
		// 요소 검색
		int index = linkedList.indexOf("바나나");
		System.out.println("바나나 위치: " + index);
		
		// 요소 삭제
		linkedList.remove("사과");
		linkedList.removeLast(); // 맨 끝 요소 삭제
		
		// 변경된 Linked List 출력
		System.out.println("업데이트 한 리스트: " + linkedList);
	}

}
