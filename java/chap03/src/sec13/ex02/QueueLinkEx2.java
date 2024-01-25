package sec13.ex02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkEx2 {

	public static void main(String[] args) {
		Queue<String> messageQueue = new LinkedList<>();
		
		// 메시지 추가
		messageQueue.offer("안녕하세요!");
		messageQueue.offer("반갑습니다.");
		messageQueue.offer("잘 지내세요.");
		
		// 메시지 큐에서 메시지 꺼내서 출력
		while (!messageQueue.isEmpty()) {
			String message = messageQueue.poll();
			System.out.println("수신 메시지: " + message);
		}
	}

}
