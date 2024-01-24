package sec13.ex02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkEx {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		// 데이터를 큐에 추가
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		
		System.out.println("큐: " + queue); // A, B, C
		
		// 큐에서 데이터를 꺼내고 출력
		String dequeuedItem = queue.poll();
		System.out.println("꺼낸 데이터: " + dequeuedItem); // A
		System.out.println("남아있는 데이터: " + queue); // B, C
		
		// 큐의 맨 앞에 있는 데이터를 확인 (꺼내지 않음)
		String peekedItem = queue.peek();
		System.out.println("맨 앞에 있는 데이터: " + peekedItem); // B
		System.out.println("남아있는 데이터: " + queue); // B, C
		
		System.out.println("큐가 비어있나요? " + queue.isEmpty()); // false
		System.out.println("큐의 개수: " + queue.size()); // 2
	}

}
